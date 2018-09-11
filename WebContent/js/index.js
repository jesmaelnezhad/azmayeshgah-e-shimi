var itemsArray = [];
var itemSchema = [];
var interestingItems = [];
var interestingItemSchema = [];
function submitSearchQuery(){
	var search_query = document.getElementById("search_query").value;
	if(search_query =='' ){
		itemsArray = [];
		populateItemsBox(itemSchema, itemsArray, "SearchResults", "SearchResultTemplate");
		return;
	}
	var xhttp = new XMLHttpRequest();
	xhttp.open("GET", "./search?query="+search_query, true);
	xhttp.onload = function (e) {
	  if (xhttp.readyState === 4) {
	    if (xhttp.status === 200) {
	    	if(xhttp.responseText == ''){
	    		return;
	    	}
	      var responseObj = JSON.parse(xhttp.responseText);
	      itemSchema = responseObj["schema"];
	      interestingItemSchema = itemSchema.slice();
	      interestingItemSchema.push("extraInfo");
	      itemsArray = responseObj["data"];
	      populateItemsBox(itemSchema, itemsArray, "SearchResults", "SearchResultTemplate");
	    } else {
	      console.error(xhttp.statusText);
	    }
	  }
	};
	xhttp.onerror = function (e) {
	  console.error(xhttp.statusText);
	};
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(null);
}

function removeInterestingItem(itemElement){
	// first check if extra info is given
	var extraInfo = itemElement.querySelector("#extraInfo").value;
	var id = itemElement.querySelector("#id").innerHTML;
	if(extraInfo == ""){
		itemElement.querySelector("#warning").style.display="block";
		itemElement.querySelector("#checkbox").checked = false;
		setTimeout(function (itemElement){itemElement.querySelector("#warning").style.display="none";}, 3000, itemElement);
		return;
	}
	
	// remove the corresponding item from the items array
	var itemIndex = elementToItem(itemElement, interestingItems);
	var itemToMove = null;
	if(itemIndex > -1){
		itemToMove = interestingItems.splice(itemIndex, 1)[0];
	}else{
		return;
	}
	
	// now delete the element from its parent which is items box
	itemElement.parentElement.removeChild(itemElement);
	
	// prepare the Interesting item
	// update the extra info value because user could have changed it
	itemToMove["extraInfo"] = extraInfo;
	
	// inform the server that this item is interesting
	var request = new XMLHttpRequest();
	request.open('GET', "./makeinteresting?id="+id+"&action=remove", false);  // `false` makes the request synchronous
	request.send(null);

	if (request.status === 200) {
		populateItemsBox(interestingItemSchema, interestingItems, "Selections", "SelectionTemplate");
		submitSearchQuery();
		populateItemsBox(schema, itemsArray, "SearchResults", "SearchResultTemplate");
	}else{
		alert("Server not responding properly.");
		interestingItems.splice(itemIndex, 0, itemToMove);
		populateItemsBox(interestingItemSchema, interestingItems, "Selections", "SelectionTemplate");
		populateItemsBox(schema, itemsArray, "SearchResults", "SearchResultTemplate");
		return;
	}
	
}

function makeInteresting(itemElement){
	// first check if extra info is given
	var extraInfo = itemElement.querySelector("#extraInfo").value;
	var id = itemElement.querySelector("#id").innerHTML;
	if(extraInfo == ""){
		itemElement.querySelector("#warning").style.display="block";
		itemElement.querySelector("#checkbox").checked = true;
		setTimeout(function (itemElement){itemElement.querySelector("#warning").style.display="none";}, 3000, itemElement);
		return;
	}
	
	// remove the corresponding item from the items array
	var itemIndex = elementToItem(itemElement, itemsArray);
	var itemToMove = null;
	if(itemIndex > -1){
		itemToMove = itemsArray.splice(itemIndex, 1)[0];
	}else{
		return;
	}
	
	// now delete the element from its parent which is items box
	itemElement.parentElement.removeChild(itemElement);
	
	// prepare the Interesting item
	itemToMove["extraInfo"] = extraInfo;
	
	// inform the server that this item is interesting
	var request = new XMLHttpRequest();
	request.open('GET', "./makeinteresting?id="+id+"&extra_info="+extraInfo, false);  // `false` makes the request synchronous
	request.send(null);

	if (request.status === 200) {
		interestingItems.push(itemToMove);
		
		populateItemsBox(interestingItemSchema, interestingItems, "Selections", "SelectionTemplate");
	}else{
		alert("Server not responding properly.");
		delete itemToMove["extraInfo"];
		itemsArray.splice(itemIndex, 0, itemToMove);
		populateItemsBox(schema, itemsArray, "SearchResults", "SearchResultTemplate");
		return;
	}
	
}

function loadPage(){
	loadSelections();
}

function loadSelections(){
	var request = new XMLHttpRequest();
	request.open('GET', "./interestingitems", false);  // `false` makes the request synchronous
	request.send(null);

	if (request.status === 200) {
		if(request.responseText == ''){
			return;
		}
		var responseObj = JSON.parse(request.responseText);
		interestingItemSchema = responseObj["schema"];
		interestingItems = responseObj["data"];
		
		populateItemsBox(interestingItemSchema, interestingItems, "Selections", "SelectionTemplate");
	}else{
		alert("Server not responding properly.");
		return;
	}
}
function loadPage(){
	loadActiveSearches();
	loadOptimizedOffers();
}

var activeSearchesSchema = [];
var activeSearchItems = [];

function loadActiveSearches(){
	var request = new XMLHttpRequest();
	request.open('GET', "./activesearches", false);  // `false` makes the request synchronous
	request.send(null);

	if (request.status === 200) {
		if(request.responseText == ''){
			return;
		}
		var responseObj = JSON.parse(request.responseText);
		activeSearchesSchema = responseObj["schema"];
		if(typeof(activeSearchesSchema) == "string"){
			activeSearchesSchema = JSON.parse(activeSearchesSchema); 
		}
		activeSearchItems = responseObj["data"];
		if(typeof(activeSearchItems) == "string"){
			activeSearchItems = JSON.parse(activeSearchItems); 
		}
		
		populateItemsBox(activeSearchesSchema, activeSearchItems, "ActiveSearches", "ActiveSearchTemplate");
	}else{
		alert("Server not responding properly.");
		return;
	}
}

function addOfferInputRow(){
	var rowElement = document.getElementById("offerInputRowTemplate");
	var tableElement = document.getElementById("offerInputTable");
	
	var rowCopy = rowElement.cloneNode(true);
	rowCopy.style.display="block";
	tableElement.appendChild(rowCopy);
}

function removeOfferInputRow(rowElement){
	if(rowElement.parentElement.childElementCount > 3){
		rowElement.parentElement.removeChild(rowElement);
	}
}

function uploadOffers(){
	if(! validateOfferInputs()){
		return;
	}
	alert("Sending offers to the server ...");
}

function validateOfferInputs(){
	//TODO : validate offer input fields (whether they have value and whether count is a number)
	
	return true;
}

function loadOrders(){
	alert("Loading optimized offer box ...");
	//TODO
}




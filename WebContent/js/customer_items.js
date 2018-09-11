function loadPage(){
	loadActiveSearches();
	loadOptimizedOffers();
}
function loadActiveSearches(){
	alert("Loading active search box ...");
	//TODO
}

function loadOptimizedOffers(){
	alert("Loading optimized offer box ...");
	//TODO
}

class Item{
	constructor(CAS, name, size){
		this.CAS = CAS;
		this.name = name;
		this.size = size;
	}
	show(){
		alert(this.CAS + " / " + this.name + " / " + this.size);
	}
}



function loadActiveSearchItems() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      //alert(this.responseText);
	      activeSearchItems = JSON.parse(this.responseText);
	    }
	  };
	  xhttp.open("GET", "./items", false);
	  xhttp.send();
}

function refreshBox(items, fields, boxId, itemTemplateId){
	var box = document.getElementById(boxId);
	box.innerHTML = "";
	var templateObj = document.getElementById(itemTemplateId);
	for(var i = 0 ; i < items.length; i++){
		var newChild = templateObj.cloneNode(true);
		newChild.style.display = "block";
		for(var f = 0 ; f < fields.length; f++){
			var field = fields[f];
			newChild.querySelector("#" + field).innerHTML = items[i][field];
		}
//		alert(newChild.innerHTML);
		box.appendChild(newChild);
	}
}




var activeSearchItems ;

loadActiveSearchItems();

refreshBox(activeSearchItems, ["CAS", "name1", "name2", "size", "status"], "activeSearchBox", "activeSearchTemplate");




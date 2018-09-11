

function showOfferModal(activeSearch){
	var modal = document.getElementById('myModal');
	modal.style.display = "block";
	var span = document.getElementsByClassName("close")[0];
	span.onclick = function() {
	    modal.style.display = "none";
	}
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	    }
	}
	document.getElementById("modalItemInfo").innerHTML = activeSearch.innerHTML;
	document.getElementById("modalItemInfo").querySelector("#removeButton").parentElement.removeChild(document.getElementById("modalItemInfo").querySelector("#removeButton"));
	document.getElementById("modalItemInfo").style.fontSize="14px";
}
function populateItemsBox(schema, itemsArray, boxId, itemTemplateId){
	var box = document.getElementById(boxId);
	var itemTemplate = document.getElementById(itemTemplateId);
	box.innerHTML = "";
	for(var i = 0; i < itemsArray.length; i++){
		var item = itemsArray[i];
		if(typeof(item) == "string"){
			item = JSON.parse(item);
		}
		var newItemTag = itemTemplate.cloneNode(true);
		for(var s = 0; s < schema.length; s++){
			var fieldName = schema[s];
			var fieldTag = newItemTag.querySelector("#" + fieldName);
			
			if(fieldTag != null){
				if(fieldTag.tagName == "INPUT"){
					fieldTag.value = item[fieldName];
				}else{
					fieldTag.innerHTML = item[fieldName];
				}
			}
		}
		newItemTag.style.display = "block";
		box.appendChild(newItemTag);
	}
}

function elementToItem(element, itemsArrayInput){
	var id = element.querySelector("#id").innerHTML;
	for(var i = 0; i < itemsArrayInput.length; i++){
		var itemObj = null;
		if(typeof(itemsArrayInput[i]) == "string"){
			itemObj = JSON.parse(itemsArrayInput[i]);
		}else if(typeof(itemsArrayInput[i]) == "object"){
			itemObj = itemsArrayInput[i];
		}
		if(itemObj["id"] == id) return i;
	}
	return -1;
}
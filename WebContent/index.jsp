<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
<style>
body {
    background-color: #dee7f4;
}
.SearchForm {
    width: 1000px;
    height: 50px;
    border: 0px solid black;
    margin: 10px;
    padding:5px;
    background-color: white;
}
.OperationsForm {
    width: 1000px;
    height: 50px;
    border: 0px solid black;
    margin: 10px;
    padding:5px;
    padding-top:20px;
    background-color: white;
}
.SearchResults {
    width: 1000px;
    height: 300px;
    border: 0px solid black;
    margin: 10px;
    padding:5px;
    float:none;
    overflow-y: scroll;
    background-color: white;
}
.SearchResult {
    width: 950px;
    border:0px;
    border-bottom: 1px solid black;
    margin: 5px;
    padding-bottom:5px;
    float:none;
}
.Selections {
    width: 1000px;
    height: 100px;
    border: 0px solid black;
    margin: 10px;
    padding:5px;
    overflow-y: scroll;
    background-color: white;
}
.Selection {
    width: 950px;
    border:0px;
    border-bottom: 1px solid black;
    margin: 5px;
    padding-bottom:5px;
    float:none;
}
label {display: inline-block;}
</style>
</head>
<body onload="loadPage();">
<div class="SearchForm">

<p><img src="./images/logo.png" 
style="width:200px;height:30px;float:left;margin-right:15px;">
<form id="search_form" > 
<input id="search_query" name="search_query" style="margin:10px" type="text" width="100px" placeholder="CAS, name, keyword, ..." />
<input type="button" value="Search" id="searchButton" onClick="submitSearchQuery()"/>
</form>
</p>
</div>
<script type="text/javascript">
//Get the input field
var input = document.getElementById("search_query");

// Execute a function when the user releases a key on the keyboard
input.addEventListener("keyup", function(event) {
  // Cancel the default action, if needed
  event.preventDefault();
  // Number 13 is the "Enter" key on the keyboard
  if (event.keyCode === 13) {
    // Trigger the button element with a click
    document.getElementById("searchButton").click();
  }
});
</script>
<div class="SearchResults" id="SearchResults">

</div>
<div class="Selections" id="Selections">

</div>
<div class="OperationsForm">
<center>
<form method="get" action="./requestprice">
<input type="submit" value="درخواست قیمت" onClick="requestPrices();"/>
</form>
</center>
</div>


	<div class="SearchResult" id="SearchResultTemplate" style="display:none;">
		<label id="id" style="display:none"></label>
		<input id="checkbox" style="margin:0px;font-size:12px" type="checkbox" onClick="makeInteresting(this.parentElement);"/>
		<label id="casNumber" style="width:100px;margin:0px;margin-left:20px;padding:0px;font-size:12px">67-64-1</label>
		<label id="name" style="width:200px;margin:0px;margin-left:20px;padding:0px;font-size:12px">Acetone</label>
		<label id="formula" style="width:200px;margin:0px;margin-left:20px;padding:0px;font-size:12px">استون</label>
		<input id="extraInfo" style="margin:0px;margin-left:20px" type="text" size="15" placeholder="Amount or Extra info" />
		<label id="warning" style="display:none;float:right;margin:0px;margin-left:20px;padding:0px;color:red">مقدار مورد نیاز را وارد کنید</label>
	</div>
	
	<div class="Selection" id="SelectionTemplate" style="display:none;">
		<label id="id" style="display:none"></label>
		<input id="checkbox" style="margin:0px;font-size:12px" type="checkbox" checked onClick="removeInterestingItem(this.parentElement);"/>
		<label id="casNumber" style="width:100px;margin:0px;margin-left:20px;padding:0px;font-size:12px">67-64-1</label>
		<label id="name" style="width:200px;margin:0px;margin-left:20px;padding:0px;font-size:12px">Acetone</label>
		<label id="formula" style="width:200px;margin:0px;margin-left:20px;padding:0px;font-size:12px">استون</label>
		<input id="extraInfo" style="margin:0px;margin-left:20px" type="text" size="15" placeholder="Amount or Extra info" />
	</div>
<script src="./js/index.js"></script>
<script src="./js/helper.js"></script>
</body>
</html>
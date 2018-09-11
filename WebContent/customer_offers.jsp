<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Price Check</title>
<style>
body {
    background-color: #dee7f4;
}
.Top {
    width: 1000px;
    height: 50px;
    border: 0px solid black;
    margin: 10px;
    padding:5px;
    background-color: white;
}
.ActiveSearches {
    width: 1000px;
    height: 150px;
    border: 0px solid black;
    margin: 10px;
    padding:5px;
    overflow-y: scroll;
    background-color: white;
}
.ActiveSearch {
    width: 950px;
    height: 20px;
    border:0px;
    border-bottom: 1px solid black;
    margin: 5px;
    padding-bottom:5px;
    float:none;
}
.OptimizedOffers {
    width: 1000px;
    height: 200px;
    border: 0px solid black;
    margin: 10px;
    padding:5px;
    overflow-y: scroll;
    background-color: white;
}
.OptimizedOffer {
    width: 950px;
    height: 20px;
    border:0px;
    border-bottom: 1px solid black;
    margin: 5px;
    padding-bottom:5px;
    float:none;
}
.Selections {
    width: 1000px;
    height: 110px;
    border: 0px solid black;
    margin: 10px;
    padding:5px;
    background-color: white;
}
.Selection {
    width: 950px;
    height: 20px;
    border:0px;
    border-bottom: 1px solid black;
    margin: 5px;
    padding-bottom:5px;
    float:none;
}
.OperationsForm {
    width: 1000px;
    height: 40px;
    border: 0px solid black;
    margin: 10px;
    padding:5px;
    padding-top:20px;
    background-color: white;
}
label {display: inline-block;}
</style>
</head>
<body onload="loadPage();">
<div class="Top">
	<p><img src="./images/logo.png" 
	style="width:200px;height:30px;float:left;margin-right:15px;">
	</p>
</div>
<div class="ActiveSearches" id="activeSearchBox">

</div>
<div class="OptimizedOffers">
	<div class="OptimizedOffer"><b>
		<input style="margin:0px" type="checkbox" disabled/>
		<label style="width:100px;margin:0px;margin-left:20px;padding:0px">CAS</label>
		<label style="width:200px;margin:0px;margin-left:20px;padding:0px">Name</label>
		<label style="width:100px;margin:0px;margin-left:20px;padding:0px">‌برند</label>
		<label style="width:25px;margin:0px;margin-left:20px;padding:0px">تعداد</label>
		<label style="width:50px;margin:0px;margin-left:20px;padding:0px">Item</label>
		<label style="width:50px;margin:0px;margin-left:20px;padding:0px">قیمت</label>
		<label style="width:150px;margin:0px;margin-left:20px;padding:0px">هزینه حمل و نقل</label>
		<label style="width:70px;margin:0px;margin-left:20px;padding:0px">هزینه کل</label>
	</b></div>
	<div class="OptimizedOffer">
		<input style="margin:0px" type="checkbox" />
		<label style="width:100px;margin:0px;margin-left:20px;padding:0px">67-64-1</label>
		<label style="width:200px;margin:0px;margin-left:20px;padding:0px">Acetone</label>
		<label style="width:100px;margin:0px;margin-left:20px;padding:0px">برند آمریکایی</label>
		<label style="width:25px;margin:0px;margin-left:20px;padding:0px">2</label>
		<label style="width:50px;margin:0px;margin-left:20px;padding:0px">300ml</label>
		<label style="width:50px;margin:0px;margin-left:20px;padding:0px">20000</label>
		<label style="width:150px;margin:0px;margin-left:20px;padding:0px">15000</label>
		<label style="width:70px;margin:0px;margin-left:20px;padding:0px">35000</label>
	</div>
	<div class="OptimizedOffer">
		<input style="margin:0px" type="checkbox" />
		<label style="width:100px;margin:0px;margin-left:20px;padding:0px">67-64-1</label>
		<label style="width:200px;margin:0px;margin-left:20px;padding:0px">Acetone</label>
		<label style="width:100px;margin:0px;margin-left:20px;padding:0px">برند ژاپنی</label>
		<label style="width:25px;margin:0px;margin-left:20px;padding:0px">1</label>
		<label style="width:50px;margin:0px;margin-left:20px;padding:0px">800ml</label>
		<label style="width:50px;margin:0px;margin-left:20px;padding:0px">25000</label>
		<label style="width:150px;margin:0px;margin-left:20px;padding:0px">15000</label>
		<label style="width:70px;margin:0px;margin-left:20px;padding:0px">40000</label>
	</div>
	<div class="OptimizedOffer">
		<input style="margin:0px" type="checkbox" />
		<label style="width:100px;margin:0px;margin-left:20px;padding:0px">67-64-1</label>
		<label style="width:200px;margin:0px;margin-left:20px;padding:0px">Acetone</label>
		<label style="width:100px;margin:0px;margin-left:20px;padding:0px">برند ایرانی</label>
		<label style="width:25px;margin:0px;margin-left:20px;padding:0px">1</label>
		<label style="width:50px;margin:0px;margin-left:20px;padding:0px">800ml</label>
		<label style="width:50px;margin:0px;margin-left:20px;padding:0px">50000</label>
		<label style="width:150px;margin:0px;margin-left:20px;padding:0px">15000</label>
		<label style="width:70px;margin:0px;margin-left:20px;padding:0px">65000</label>
	</div>
</div>

<div class="Selections">
	<div class="Selection">
		<input style="margin:0px" type="checkbox" checked/>
		<label style="width:100px;margin:0px;margin-left:20px;padding:0px">67-56-1</label>
		<label style="width:200px;margin:0px;margin-left:20px;padding:0px">Methanol</label>
		<label style="width:100px;margin:0px;margin-left:20px;padding:0px">برند ایرانی</label>
		<label style="width:25px;margin:0px;margin-left:20px;padding:0px">1</label>
		<label style="width:50px;margin:0px;margin-left:20px;padding:0px">800ml</label>
		<label style="width:50px;margin:0px;margin-left:20px;padding:0px">50000</label>
		<label style="width:150px;margin:0px;margin-left:20px;padding:0px">55000</label>
		<label style="width:70px;margin:0px;margin-left:20px;padding:0px">105000</label>
	</div>
	<div class="Selection">
		<label style="width:100px;margin:0px;margin-left:20px;padding:0px"></label>
		<label style="width:200px;margin:0px;margin-left:20px;padding:0px"></label>
		<label style="width:100px;margin:0px;margin-left:20px;padding:0px"></label>
		<label style="width:25px;margin:0px;margin-left:20px;padding:0px"></label>
		<label style="width:50px;margin:0px;margin-left:20px;padding:0px"></label>
		<label style="width:50px;margin:0px;margin-left:20px;padding:0px"></label>
		<label style="width:150px;margin:0px;margin-left:20px;padding:0px"></label>
		<label style="width:70px;margin:0px;margin-left:20px;padding:0px">105000</label>
	</div>
</div>
<div class="OperationsForm">
<center>
<form>
<input type="submit" value="خرید"/>
</form>
</center>
</div>



<div class="ActiveSearch" style="display:none" id="activeSearchTemplate">
	<label id="id" style="display:none"></label>
	<label id="casNumber" style="width:100px;margin:0px;margin-left:20px;padding:0px;font-size:12px">67-64-1</label>
	<label id="name" style="width:200px;margin:0px;margin-left:20px;padding:0px;font-size:12px">Acetone</label>
	<label id="formula" style="width:200px;margin:0px;margin-left:20px;padding:0px;font-size:12px">استون</label>
	<label id="extraInfo" style="width:25px;margin:0px;margin-left:20px;padding:0px;font-size:12px">400ml</label>
	<label id="status" style="float:right;margin:0px;margin-left:20px;padding:0px;color:green;font-size:12px">در حال قیمت گیری</label>
</div>

<script src="./js/customer_items.js"></script>
<script src="./js/helper.js"></script>
</body>
</html>
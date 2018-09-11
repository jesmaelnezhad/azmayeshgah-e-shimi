<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Price Requests and Orders</title>
<link rel="stylesheet" href="./css/modal.css">
<style>
body {
    background-color: #dee7f4;
}
.Top {
    width: 1000px;
    height: 50px;
    border: 0px solid black;
    margin:10px;
    margin-left: auto;
    margin-right: auto;
    padding:5px;
    background-color: white;
}
.ActiveSearches {
    width: 1000px;
    height: 150px;
    border: 0px solid black;
    margin:10px;
    margin-left: auto;
    margin-right: auto;
    padding:5px;
    overflow-y: scroll;
    background-color: white;
}
.ActiveSearch {
    width: 950px;
    height: 20px;
    border:0px;
    border-bottom: 1px solid black;
    margin: 0px;
    padding-bottom:5px;
    padding-top:5px;
    float:none;
}
.Orders {
    width: 1000px;
    height: 200px;
    border: 0px solid black;
    margin:10px;
    margin-left: auto;
    margin-right: auto;
    padding:5px;
    overflow-y: scroll;
    background-color: white;
}
.Order {
    width: 950px;
    height: 20px;
    border:0px;
    border-bottom: 1px solid black;
    margin: 5px;
    padding-bottom:5px;
    float:none;
}
div.ActiveSearch:hover, div.ActiveSearch:hover *{
	background-color: #edf2f9;
	cursor:pointer;
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
<div class="ActiveSearches" id="ActiveSearches">

</div>
<div class="Orders">
	<form style="display:inline;" action="./sent" method="post">
		<div class="Order"><b>
			<span style="width:50px;margin:0px;margin-left:20px;padding:0px">
				<input type="submit" value="پست شد" name="sent"/>
			</span>
			<label style="width:100px;margin:0px;margin-left:20px;padding:0px">CAS</label>
			<label style="width:200px;margin:0px;margin-left:20px;padding:0px">Name</label>
			<label style="width:100px;margin:0px;margin-left:20px;padding:0px">‌برند</label>
			<label style="width:25px;margin:0px;margin-left:20px;padding:0px">تعداد</label>
			<label style="width:50px;margin:0px;margin-left:20px;padding:0px">Item</label>
		</b></div>
		<div class="Order">
			<span style="width:50px;margin:0px;margin-left:20px;padding:0px">
				<input type="submit" value="پست شد" name="sent"/>
			</span>
			<label style="width:100px;margin:0px;margin-left:20px;padding:0px">67-64-1</label>
			<label style="width:200px;margin:0px;margin-left:20px;padding:0px">Acetone</label>
			<label style="width:100px;margin:0px;margin-left:20px;padding:0px">برند آمریکایی</label>
			<label style="width:25px;margin:0px;margin-left:20px;padding:0px">2</label>
			<label style="width:50px;margin:0px;margin-left:20px;padding:0px">300ml</label>
		</div>
		<div class="Order">
			<span style="width:50px;margin:0px;margin-left:20px;padding:0px">
				<input type="submit" value="پست شد" name="reject"/>
			</span>
			<label style="width:100px;margin:0px;margin-left:20px;padding:0px">67-56-1</label>
			<label style="width:200px;margin:0px;margin-left:20px;padding:0px">Methanol</label>
			<label style="width:100px;margin:0px;margin-left:20px;padding:0px">برند ایرانی</label>
			<label style="width:25px;margin:0px;margin-left:20px;padding:0px">1</label>
			<label style="width:50px;margin:0px;margin-left:20px;padding:0px">800ml</label>
		</div>
	</form>
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
	
	<div class="ActiveSearch" id="ActiveSearchTemplate" style="display:none;" onClick="showOfferModal(this);">
		<a  id="removeButton" title="موجود نیست" class="RemoveButton" href="" style="cursor:pointer;text-decoration:none;font-size:12px;margin-top:5px;">
			<img src="./images/red_cross.png" style="width:20px;height:20px;" />
		</a>
		<label id="question_id" style="display:none"></label>
		<label id="id" style="display:none"></label>
		<label id="casNumber" style="width:100px;margin:0px;margin-left:20px;padding:0px;font-size:12px">67-64-1</label>
		<label id="name" style="width:200px;margin:0px;margin-left:20px;padding:0px;font-size:12px">Acetone</label>
		<label id="formula" style="width:200px;margin:0px;margin-left:20px;padding:0px;font-size:12px">استون</label>
		<label id="extraInfo" style="width:200px;margin:0px;margin-left:20px;padding:0px;font-size:12px">استون</label>
	</div>
	
	<!-- The Modal -->
	<div id="myModal" class="modal">
	
	  <!-- Modal content -->
	  <div class="modal-content">
	    <span class="close">&times;</span>
	    <b><span id="modalItemInfo">Some text in the Modal..</span></b>
	    <hr style="width:100%"/>
	    <form>
	    <div style="width:90%" id="offerInputTable">
	    	<div style="float:left;width:100%">
	    		<label style="width:18%;height:20px;margin:0px;padding:0px;text-align:center;font-size:12px;">برند یا نام محصول</label>
	    		<label style="width:18%;height:20px;margin:0px;padding:0px;text-align:center;font-size:12px;">اندازه یا اطلاعات دیگر</label>
	    		<label style="width:18%;height:20px;margin:0px;padding:0px;text-align:center;font-size:12px;">تعداد</label>
	    		<label style="width:18%;height:20px;margin:0px;padding:0px;text-align:center;font-size:12px;">قیمت هر کدام</label>
				<label style="width:18%;height:20px;margin:0px;padding:0px;text-align:center;font-size:12px;">قیمت کل</label>
	    	</div>
	    	<div id="offerInputRowTemplate" style="display:none;float:left;width:100%;margin-bottom:5px;padding:0px;">
				<img title="حذف پیشنهاد" src="./images/red_cross.png" style="cursor:pointer;width:20px;height:20px;margin-top:0px;" onClick="removeOfferInputRow(this.parentElement);" />
    			<input style="width:18%;height:20px;margin:0px;padding:0px;text-align:center;" type="text" id="offer_brand" placeholder="برند"/>
    			<input style="width:18%;height:20px;margin:0px;padding:0px;text-align:center;" type="text" id="offer_brand" placeholder="اندازه یا اطلاعات دیگر"/>
    			<input style="width:18%;height:20px;margin:0px;padding:0px;text-align:center;" type="text" value="1" id="offer_brand" placeholder="تعداد"/>
    			<input style="width:18%;height:20px;margin:0px;padding:0px;text-align:center;" type="text" id="offer_brand" placeholder="قیمت هر کدام"/>
    			<label style="width:18%;height:20px;margin:0px;padding:0px;text-align:center;" id="offer_brand" >قیمت کل</label>
	    	</div>
	    	<div id="offerInputRow" style="float:left;width:100%;margin-bottom:5px;padding:0px;">
				<img title="حذف پیشنهاد" src="./images/red_cross.png" style="cursor:pointer;width:20px;height:20px;margin-top:0px;" onClick="removeOfferInputRow(this.parentElement);" />
    			<input style="width:18%;height:20px;margin:0px;padding:0px;text-align:center;" type="text" id="offer_brand" placeholder="برند"/>
    			<input style="width:18%;height:20px;margin:0px;padding:0px;text-align:center;" type="text" id="offer_brand" placeholder="اندازه یا اطلاعات دیگر"/>
    			<input style="width:18%;height:20px;margin:0px;padding:0px;text-align:center;" type="text" value="1" id="offer_brand" placeholder="تعداد"/>
    			<input style="width:18%;height:20px;margin:0px;padding:0px;text-align:center;" type="text" id="offer_brand" placeholder="قیمت هر کدام"/>
    			<label style="width:18%;height:20px;margin:0px;padding:0px;text-align:center;" id="offer_brand" >قیمت کل</label>
	    	</div>
	    </div>
	    <br style="clear:both;"/>
		<a  id="addButton" title="اضافه کردن یک پیشنهاد دیگر" class="AddButton" style="cursor:pointer;text-decoration:none;font-size:12px;float:left;" onClick="addOfferInputRow();">
			<img src="./images/green_plus.png" style="width:20px;height:20px;margin-top:20px;" />
		</a>
		
		<a  id="uploadButton" title="فرستادن پیشنهادها" class="UploadButton" style="cursor:pointer;text-decoration:none;font-size:12px;float:left;margin-left:10px;" onClick="uploadOffers();">
			<img src="./images/upload.png" style="width:20px;height:20px;margin-top:20px;" />
		</a>
	    </form>
	  </div>
	
	</div>
	
<script src="./js/seller.js"></script>
<script src="./js/helper.js"></script>
<script src="./js/modal.js"></script>

</body>
</html>
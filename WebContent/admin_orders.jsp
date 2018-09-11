<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Price Requests and Orders</title>
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

.Orders {
    width: 1000px;
    height: 200px;
    border: 0px solid black;
    margin: 10px;
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


label {display: inline-block;}
</style>
</head>
<body>
<div class="Top">
	<p><img src="./images/logo.png" 
	style="width:200px;height:30px;float:left;margin-right:15px;">
	</p>
</div>

<div class="Orders">
	<form style="display:inline;" action="./sent" method="post">
		<div class="Order"><b>
			<span style="width:50px;margin:0px;margin-left:20px;padding:0px">
				<input type="submit" value="تحویل داده شد" name="sent"/>
			</span>
			<label style="width:100px;margin:0px;margin-left:20px;padding:0px">CAS</label>
			<label style="width:200px;margin:0px;margin-left:20px;padding:0px">Name</label>
			<label style="width:150px;margin:0px;margin-left:20px;padding:0px">Seller</label>
			<label style="width:250px;margin:0px;margin-left:20px;padding:0px">‌وضعیت</label>
		</b></div>
		<div class="Order">
			<span style="width:50px;margin:0px;margin-left:20px;padding:0px">
				<input type="submit" value="تحویل داده شد" name="sent"/>
			</span>
		<label style="width:100px;margin:0px;margin-left:20px;padding:0px">67-64-1</label>
		<label style="width:200px;margin:0px;margin-left:20px;padding:0px">Acetone</label>
		<label style="width:150px;margin:0px;margin-left:20px;padding:0px">مواد شیمیایی پارس</label>
		<label style="width:250px;margin:0px;margin-left:20px;padding:0px;color:green">‌در حال بسته بندی</label>
		</div>
		<div class="Order">
			<span style="width:50px;margin:0px;margin-left:20px;padding:0px">
				<input type="submit" value="تحویل داده شد" name="sent"/>
			</span>
		<label style="width:100px;margin:0px;margin-left:20px;padding:0px">67-56-1</label>
		<label style="width:200px;margin:0px;margin-left:20px;padding:0px">Methanol</label>
		<label style="width:150px;margin:0px;margin-left:20px;padding:0px">خزر متانول</label>
		<label style="width:250px;margin:0px;margin-left:20px;padding:0px;color:green">‌پست شد</label>
		</div>
		<div class="Order">
			<span style="width:50px;margin:0px;margin-left:20px;padding:0px">
				<input type="submit" value="تحویل داده شد" name="sent"/>
			</span>
			<label style="width:100px;margin:0px;margin-left:20px;padding:0px">91-20-3</label>
			<label style="width:200px;margin:0px;margin-left:20px;padding:0px">Naphthalene</label>
			<label style="width:150px;margin:0px;margin-left:20px;padding:0px">Merck</label>
		<label style="width:250px;margin:0px;margin-left:20px;padding:0px;color:green">‌پست شد</label>
		</div>
	</form>
</div>
</body>
</html>
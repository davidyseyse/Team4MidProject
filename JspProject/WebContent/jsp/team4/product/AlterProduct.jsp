<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>alter</title>
<style>
    *{
        padding: 0;
        margin: 0;
    }
    .Insertbox1{
        width: 400px;
        border: 2px solid black;
        
    }
</style>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<div class="Insertbox1">
		<h1>修改商品</h1>
		<form action="http://localhost:8080/JspProject/MidAlterServlet.do"
			method="POST" target="">
			<label >商品名：</label>
			<input type="text" maxlength="50"name="productName"><br/> 			
			<label>商品種類：</label>
			<input type="text" maxlength="50"name="productType"><br/> 
			<label>店家名：</label>
			<input type="text" maxlength="50"name="storeId"><br/> 	
			<label>訂價：</label>
			<input type="text" maxlength="50"name="productPrice"><br/> 
			<label>存貨量：</label>
			<input type="text" maxlength="50"name="productStuck"><br/> 
			<label>折扣：</label>
			<input type="text" maxlength="50"name="discount"><br/> 
		
			 	<input type="submit" value="送出"> 
			 	<input type="reset" value="清除">

		</form>
<a href="/JspProject/MidJdbcServlet.do">查看目前擁有的活動</a>
	</div>
	<script>
	
		$(":submit").click(function() {
			let productName = $("input[name='productName']").val();
			let productType = $("input[name='productType']").val();
			let storeId = $("input[name='storeId']").val();
			let productPrice = $("input[name='productPrice']").val();
			let productStuck = $("input[name='productStuck']").val();
			let discount = $("input[name='discount']").val();
			$("form").submit();
		})
		
		 
	</script>

</body>
</html>
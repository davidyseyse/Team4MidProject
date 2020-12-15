<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="tw.team4.jspproject.javabean.MidProductJavaBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
<style>
.Insertbox1 {
	width: 400px;
	border: 2px solid black;
}
</style>

</head>
<body>

	<!-- 	<form action=""> -->
<div class="Insertbox1">
	<table border='1'>

		<tr>
			<td>大平台</td>
		</tr>
		<c:forEach var="list" items="${list}">
			<table border='1'>
				<tr>
					<td>商品名：${list.productName}</td>
				</tr>
				<tr>
					<td>店家名：${list.storeId}</td>
				</tr>
				
				<tr>
					<td>訂價：${(list.productPrice)}元</td>
				</tr>
				<tr>
					<td>實售:${list.productPrice*list.discount}元</td>
				</tr>

			</table>
	</table>



	<br>
	</c:forEach>

	<!-- 	</form> -->
</div>

</body>
</html>
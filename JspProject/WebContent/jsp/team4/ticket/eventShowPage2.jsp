<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Event Show Page</title>
</head>
<body>
<div class="jumbotron text-center">
  <h1>E-Ticket票券系統</h1>
</div>
<form action="updateEventServlet.do" method="post">
<h2>您輸入的資訊:</h2><br>
<input type="hidden" name="eventId" value="${event.eventId}" />
<input type="hidden" name="typeId" value="${event.typeId}"/>

<table style="margin: auto;width: 800px;border:3px #cccccc solid;" cellpadding="10" border='1'>

<tr><td>序號</td> <td>${event.eventId}</td></tr>
<tr><td>名稱</td> <td>${event.eventName}</td></tr>
<tr><td>地點</td> <td>${event.eventLocation}</td></tr>
<tr><td>售票系統代碼</td> <td>${event.organizationId}</td></tr>
<tr><td>售票期間</td> <td>${attraction.onSaleDate} ~ ${attraction.offSaleDate}</td></tr>
<tr><td>展出期間 </td> <td>${attraction.commDate} ~ ${attraction.dueDate}</td></tr>
<tr><td>展覽介紹</td> <td>${attraction.description}</td></tr>
</table>
<br>
<br>
<table style="margin: auto;width: 800px;border:3px #cccccc solid;" cellpadding="10" border='1'>
<tr><td>票券名稱</td> <c:forEach var="pn" items="${pricename}"><td>${pn}</td></c:forEach></tr>
<tr><td>票券價格</td> <c:forEach var="pc" items="${pricecost}"><td>${pc}</td></c:forEach></tr>
</table>


<input type="submit" name="sumbmit" value="修改">
</form>	
<a href="serviceShowEventServlet.do" class="btn btn-success" role="button">查詢所有票券</a>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event Update Page</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style>
        .t1 {
            width:150px;
            float:left;
            text-align:right;
        }
        select option[value=""]{
            display:none;
        }
    </style>
</head>
<body>
<div class="jumbotron text-center">
  <h1>E-Ticket票券系統</h1>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<h3>Event Update Page-樂園與景點</h3>
<form name="myForm" action="EventUpdateSystemProcessServlet2.do" method="post">
	<a href="eventInputPage1.jsp">展覽</a>
	<a href="eventInputPage2.jsp">樂園與景點</a>
	<a href="eventInputPage3.jsp">運動賽事</a>
	<a href="eventInputPage4.jsp">台灣高鐵</a>
	<a href="eventInputPage5.jsp">演唱會與戲劇</a>
	<hr/>
		<input type="hidden" name="typeId" value="2"/>
		<input type="hidden" name="companyId" value="1"/>
		<input type="hidden" name="eventId" value="${event.eventId}" />
	
		<label class="t1" for="">景點名稱:</label>
			<input type="text" name="eventName" value="${event.eventName}" required="required"><br><br>
		<label class="t1" for="">景點地點:</label>
			<input type="text" name="eventLocation" value="${event.eventLocation}" required="required"><br><br>		
		<label class="t1" for="">售票系統:</label>
			<select name="organizationId" required>
				<option value="1">寬宏</option>
				<option value="2">兩廳院</option>
				<option value="3">中信兄弟</option>
				<option value="4">統一獅</option>
				<option value="5">UDN</option>
				<option value="6">博客來</option>
			</select><br><br>
		
		<label class="t1" for="">景點宣傳圖片:</label>
			<input type="text" name="eventImage"><br><br>
			
		
	<%-- 以上為attractionBean 以下為priceBean --%>
	<label class="t1" for="" >起始售票時間:</label>
			<input type="date" name="onSaleD" required="required">
			<input type="time" name="onSaleT" required="required"><br><br>
		<label class="t1" for="">結束售票時間:</label>
			<input type="date" name="offSaleD" required="required">
			<input type="time" name="offSaleT" required="required"><br><br>
		<label class="t1" for="">景點起始日:</label>
			<input type="date" name="commDate" value="${attraction.commDate}" required="required"><br><br>
		<label class="t1" for="">景點終止日:</label>
			<input type="date" name="dueDate" value="${attraction.dueDate}"><br><br>
		<label class="t1" for="">描述:</label>
			<textarea style="resize:none;width:600px;height:200px;" name="description">${attraction.description}</textarea><br><br>
		
	<%-- 以上為attractionBean 以下為priceBean --%>
	<div id="price">
	<div>
	<label class="t1" for="">票券名稱:</label>
			<input type="text" name="priceName" required="required"><br><br>
	<label class="t1" for="">票券價格:</label>
			<input type="text" name="priceCost" required="required"><br><br><br>
	</div>
	</div>

		<input id="Button1" type="button" value="新增價位與名稱" onclick="addPrice()" />
		<script>
		$("#Button1").click(function(){
			console.log($("#price").html());
			
			$("#price").html($("#price").html() +  '<div>'+
					'<label class="t1" for="">票券名稱:</label>'+
					'<input type="text" name="priceName" required="required"><br><br>'+
					'<label class="t1" for="">票券價格:</label>'+
					'<input type="text" name="priceCost" required="required"><a href="#" class="btn btn-danger">刪除</a><br><br><br></div>');
			console.log($("#price").html());
		})
		

		$("#price").on("change","input",function(){		
			$(this).attr("value",$(this).val()) 
		})
		
			$("#price").on("click",".btn-danger",function(){
                $(this).closest("div").remove(); 
            })
		</script>
	<input type="submit" name="sumbmit" id="s1" value="更新">
	<a href="serviceShowEventServlet.do" class="btn btn-success" role="button">查詢所有票券</a>	
</form>

</body>
</html>
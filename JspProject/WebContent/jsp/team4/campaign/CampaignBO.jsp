<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<html>
<head>
<meta charset="UTF-8">
<title>新增活動</title>
<style>
* {
	padding: 0;
	margin: 0;
}

.title {
	text-align: center;
}
</style>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>


	<div class="container">
		<c:if test="${empty camp}">
			<h1 class="title">活動新增</h1>
		</c:if>
		
		<c:if test="${!(empty camp)}">
			<h1 class="title">活動修改</h1>
		</c:if>
			
		<c:if test="${empty camp}">
			<c:set var="servletType" value="CampaignBOServlet"/>
		</c:if>
		
		<c:if test="${!empty camp}">
			<c:set var="servletType" value="CampaignUpdateServlet"/>
		</c:if>
		
		<!-- action是動態的，會依照新增或修改變更處理的Servlet -->
		<form action= "${servletType}" method="POST">
			<input type="hidden" name="campId" value="${camp.id}"/>
			<div class="form-group">
				<label for="name" >活動名稱:</label> 
				<input type="text"class="form-control" id="name" name="title" value="${camp.title}">
			</div>

			<div class="form-group">
				<label for="strdate">開始時間:</label> 
				<input type="date" name="startDate"
					id="strdate" class="form-control" value="2020-01-01" )> 
				<input
					type="time" name="startTime" class="form-control" value="00:00">
			</div>

			<div class="form-group">
				<label for="usr">結束時間:</label> <input type="date" name="endDate"
					class="form-control" value="2021-01-01" > <input
					type="time" name="endTime" class="form-control" value="00:00">
			</div>

			<div class="form-check-inline">
				<label class="form-check-label"> 上架狀態:<br> 
				<c:if test="${camp.status}">
				
				<input
					type="radio" class="form-check-input" name="status" value="true" checked>上架 <input
					type="radio" class="form-check-input" name="status" value="false" >下架
				
				</c:if>
				
				<c:if test="${!camp.status}">
				
				<input
					type="radio" class="form-check-input" name="status" value="true" >上架 <input
					type="radio" class="form-check-input" name="status" value="false" checked>下架
				
				</c:if>
				
				</label>
			</div>

			<div class="form-group">
				<label for="comment">活動描述:</label>
				<textarea name="description" class="form-control" rows="5" id="comment" >${camp.description}</textarea>
			</div>
			
			<c:if test="${empty camp}">
				<button id="addCamp"type="submit" class="btn btn-primary">新增</button>
			</c:if>
			
			<c:if test="${!empty camp}">
				<button id="addCamp"type="submit" class="btn btn-primary">修改</button>
			</c:if>
			
			<button type="reset" class="btn btn-primary">清除</button>
			<span id="warning" style="color: red;font-size: 20px"></span>
		</form>

	</div>
	
	<script>

		$("#addCamp").click(
				function() {
					let title = $("input[name='title']").val();
					let description = $("textarea[name='description']").val();
					let startDate = $("input[name='startDate']").val();
					let startTime = $("input[name='startTime']").val();
					let endDate = $("input[name='endDate']").val();
					let endTime = $("input[name='endTime']").val();


					if (title == "" || startDate == "" || startTime == ""
							|| endDate == "" || endTime == ""
							|| description == "") {
						
						event.preventDefault();
						$("#warning").text("您輸入的資料並不完整");

					} else {

						$("form").submit();

					}
				})
	</script>

</body>
</html>
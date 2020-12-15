<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page import="tw.team4.jspproject.javabean.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員註冊</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>

<style>
body {
	background-repeat: repeat;
	font-weight: bold;
}

.hint {
	color: grey;
	font-size: 12px;
}

#RegisterDiv form {
	margin: 0px;
	margin-top: 20px;
	box-shadow: 5px 5px 5px rgb(160, 160, 160);
	padding: 50px;
}

span.note {
	color: #888;
	font-size: 10px;
}
</style>
</head>
<body>
	<jsp:include page="/jsp/team4/layout/LukeTop.jsp" />
	<div id="RegisterDiv" class="container">
		<form id="RegisterForm" action="AccountServlet.do" method="post">
			<fieldset>
				<legend>
					<h2>會員清單</h2>
				</legend>
				<%
				if (request.getAttribute("Deleted") != null) {
					Boolean deleted = (Boolean) request.getAttribute("Deleted");
					String memberIdStr = (String)request.getParameter("memberId");
					if (deleted) {
							out.write("<div class='alert alert-info' role='alert'>已成功刪除會員(Id: " + memberIdStr + ")</div>");
					}
				} 
				%>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>姓名</th>
							<th>暱稱</th>
							<th>電子郵件</th>
							<th>建立日期</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach varStatus="stVar"  var="member"  items="${members}" >
						<tr>
							<td>${member.fullname}<input type="hidden" value="${member.id}" /></td>
							<td>${member.nickname}</td>
							<td>${member.email}</td>
							<td>${member.createdDate}</td>
							<td>
								<button type="button" class="editbutton btn btn-primary">編輯</button>
								<button type="button" class="deletebutton btn btn-danger">刪除</button>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<input type="hidden" id="memberId" name="memberId" value="" />
				<input type="hidden" id="action" name="action" value="" />
				<button type="submit" id="RegisterSubmit" class="btn btn-primary">送出</button>
				<button type="reset" id="reset" class="btn btn-primary">清除</button>
			</fieldset>
			<hr>
			
		</form>


		<div></div>
	</div>
	<script>
		$(document).ready(function() {
			//更新資料
			$(".editbutton").on("click",function(){
				console.log($(this).id);
				console.log($(this).parent().siblings().eq(0));
				console.log($(this).parent().siblings().eq(0).find("input:first").val());
				let memberId = $(this).parent().siblings().eq(0).find("input:first").val();
				console.log("memberId: "+memberId);
				$("#memberId").val(memberId);
				$("#action").val("edit");
				$("#RegisterForm").submit();
			})

			//更新資料
			$(".deletebutton").on("click",function(){
				console.log($(this).id);
				console.log($(this).parent().siblings().eq(0));
				console.log($(this).parent().siblings().eq(0).find("input:first").val());
				let memberId = $(this).parent().siblings().eq(0).find("input:first").val();
				console.log("memberId: "+memberId);
				$("#memberId").val(memberId);
				$("#action").val("delete");
				$("#RegisterForm").submit();
			})
		});
	</script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter</title>
</head>
<body>
<form action="VerifyCompanyServlet" method="post">	
<table style="border:1px solid 	#64A600;border-radius:10px;padding:20px">
<tr>
	<td style="border-bottom:1px solid gray;padding-bottom:10px">
<span style="font-size:30px">企業登入</span> <input type="button" value="註冊" onclick="javascript:location.href='CompanyLogin.jsp'"/>
	</td>
</tr>
<tr>
	<td style="border-bottom:1px solid gray;padding-bottom:10px;padding-top:10px">
	帳號:<input type="text" name="account" autocomplete="off"/><br/>
	密碼:<input type="password" name="password" autocomplete="off"/>
	</td>
</tr>
<tr>
	<td style="text-align:center;padding-top:10px">
	<input type="submit" value="send"/>
	<input type="reset" value="delete"/>
	</td>
</tr>
</table>
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Company</title>
</head>
<body>
<h1>企業後台頁面</h1>
<div style="float:left;border:1px solid #64A600;padding:10px;border-radius:10px;margin-right:10px">
<!-- 	<input type="button" value="企業資訊" onclick="javascript:location.href='CompanyUpdate.jsp'"/><br><br> -->
	<form action="companyUpdateServlet" method="post">
	<input type="hidden" name="account" value="${compJB.account}" autocomplete="off"/>
	<input type="hidden" name="password"  value="${compJB.password}" autocomplete="off"/>
	
	<input type="submit" value="企業資訊" /><br><br>
	
</form>
	<div style="padding-bottom:20px">
	<input type="button" value="會員管理" onclick="javascript:location.href='../account/Register.jsp'"/><br>
	</div>
	<div style="padding-bottom:20px">
	<input type="button" value="活動" onclick="javascript:location.href='../campaign/CampaignWelcomePage.jsp'"/><br>
	</div>
	<div style="padding-bottom:20px">
	<input type="button" value="商品" onclick="javascript:location.href='../layout/_Productindex.html'"/><br>
	</div>
	<div style="padding-bottom:20px">
	<input type="button" value="票卷" onclick="javascript:location.href='../ticket/startPage.jsp'"/><br>
	</div>
	<div style="padding-bottom:10px">
	<input type="button" value="報表" onclick="javascript:location.href='../report/Report.jsp'"/><br>
	</div>
</div>


<table style="border:1px solid #64A600;border-radius:10px;padding:10px">
<tr>
	<td style="border:1px solid #64A600;border-radius:10px;padding:10px;width:380px">
	<!-- 企業資訊按鈕(查詢 秀出來用COMPANYLOGIN頁面 修(新增修改按鈕))(超連結) -->
	門市查詢:<input type="text" name="storeId"><input type="submit" value="查詢">
	<!-- 門市查詢依照(ID 之後做地區 街名)(submit ) -->
<!-- 	顯示(點進去看細項資料) (用JQUERY做 insert 關店資料)刪除button<br> -->
	</td>
	
</tr>
<tr>
<!-- 門市查詢 -->
	<td style="padding:0">
	
	<table style="border-collapse:collapse">
	<tr>
		<td style="background-color:#C4E1FF;height:30px;width:100px;text-align:center">
		編號
		</td>
		<td style="background-color:#84C1FF;height:30px;width:100px;text-align:center">
		門市名稱
		</td>
		<td style="background-color:#C4E1FF;height:30px;width:100px;text-align:center">
		地區
		</td>
		<td style="background-color:#84C1FF;height:30px;width:100px;text-align:center">
		<input type="button" value="修改" onclick="javascript:location.href='CompanyUpdate.jsp'"/><br>
		</td>
		
	</tr>
	</table>
	
	</td>
<!-- 門市查詢 -->
</tr>



</table>





</body>
</html>
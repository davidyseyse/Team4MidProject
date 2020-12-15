<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>企業登入</title>

</head>
<body>
<!-- 新增完跳轉JSP顯示新增成功資訊(查詢)過5秒跳到企業後台 -->
<!-- JSP網頁還沒完善 寫驗證 判斷 做檔案上傳  -->
<h1>企業登入資料</h1>
<table style="border:1px solid #64A600;border-radius:10px;padding:10px">
	<tr>
		<td style="border:1px solid #64A600;border-radius:10px;padding:10px">
		<form action="companyInf" method="post">
<!-- 			企業編號:<input type="text" name="companyId" /><br/> -->
<!-- 			<!-- 	設流水號 -->
			<div style="padding:5px">
			企業名稱:<input type="text" name="companyName"  autocomplete="off"/><br/>
			</div>
			<!-- 	驗證 -->
			<div style="padding:5px">
			統一編號:<input type="text" name="uniformNumbers" /><br/>
			</div>
			<!-- 	驗證 -->
			<div style="padding:5px">
			行業類別:<input type="text" name="categories"  autocomplete="off"/><br/>
			</div>
			<!-- 	radio用選的 -->
			<div style="padding:5px">
			&emsp;&emsp;帳號:<input type="text" name="account" autocomplete="off"/><br/>
			</div>
			<!-- 	驗證 -->
			<div style="padding:5px">
			&emsp;&emsp;密碼:<input type="password" name="password" autocomplete="off"/><br/>
			</div>
			<!-- 	驗證 -->
			<div style="padding:5px">
			&emsp;&emsp;信箱:<input type="text" name="email" autocomplete="off"/><br/>
			</div>
			<!-- 	驗證 -->
			<div style="padding:5px">
			公司電話:<input type="text" name="phone" /><br/>
			</div>
			<!-- 	驗證 -->
			<div style="padding:5px">
			合作銀行:<input type="text" name="bankId"  autocomplete="off"/><br/>
			</div>
			<!-- 	選單 -->
				<hr/>
			<input type="submit" value="send"/>
			<input type="reset" value="delete"/>
	
			</form>
		</td>
		<td style="border:1px solid #64A600;border-radius:10px;padding:10px">
		<form action="companyFileServlet" method="post" enctype="multipart/form-data">
			品牌圖示:	<input type="file" name="logo" /><br>
			<!-- 	上傳檔案 -->
			營業登記證:<input type="file" name="busRC" /><br>
			<!-- 	上傳檔案 -->
			<hr/>
				
				<input type="submit" value="send"/>
				<input type="reset" value="delete"/>
		</form>
		</td>
	</tr>
	

</table>















	
	




</body>
</html>
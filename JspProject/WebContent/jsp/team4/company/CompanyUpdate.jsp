<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>企業資料</h1>
<table style="border:1px solid #64A600;border-radius:10px;padding:10px">
	<tr>
		<td style="border:1px solid #64A600;border-radius:10px;padding:10px">
		<form action="CompanyUpdateServlet2" method="post">
<!-- 			企業編號:<input type="text" name="companyId" /><br/> -->
<!-- 			<!-- 	設流水號 -->
			<div style="padding:5px">
			企業名稱:<input type="text" name="companyName" value="${compJB.companyName}" autocomplete="off"/><br/>
			</div>
			<!-- 	驗證 -->
			<div style="padding:5px">
			統一編號:<input type="text" name="uniformNumbers" value="${compJB.uniformNumbers}" autocomplete="off"/><br/>
			</div>
			<!-- 	驗證 -->
			<div style="padding:5px">
			行業類別:<input type="text" name="categories" value="${compJB.categories}" autocomplete="off"/><br/>
			</div>
			<!-- 	radio用選的 -->
			<div style="padding:5px">
			&emsp;&emsp;帳號:<input type="text" name="account" value="${compJB.account}" autocomplete="off"/><br/>
			</div>
			<div style="padding:5px">
			&emsp;&emsp;密碼:<input type="password" name="password" value="${compJB.password}" autocomplete="off"/><br/>
			</div>
			<!-- 	驗證 -->
			<div style="padding:5px">
			&emsp;&emsp;信箱:<input type="text" name="email" value="${compJB.email}" autocomplete="off"/><br/>
			</div>
			<!-- 	驗證 -->
			<div style="padding:5px">
			公司電話:<input type="text" name="phone"  value="${compJB.phone}" autocomplete="off"/><br/>
			</div>
			<!-- 	驗證 -->
			<div style="padding:5px">
			合作銀行:<input type="text" name="bankId"  value="${compJB.bankId}" autocomplete="off"/><br/>
			</div>
			<!-- 	選單 -->
				<hr/>
			<input type="submit" value="update"/>
			<input type="reset" value="delete"/>
<!-- 			做功能把value重新設為空 -->
	
			</form>
		</td>
		<td style="border:1px solid #64A600;border-radius:10px;padding:10px">
		<form action="companyFileServlet" method="post" enctype="multipart/form-data">
			品牌圖示:	<input type="file" name="logo" /><br>
			<!-- 	上傳檔案 -->
			營業登記證:<input type="file" name="busRC" /><br>
			<!-- 	上傳檔案 -->
			<hr/>
				
				<input type="submit" value="update"/>
				<input type="reset" value="delete"/>
		</form>
		</td>
	</tr>
	

</table>
	<form action="companyDeleteServlet" method="post">
		<input type="hidden" name="companyName" value="${compJB.companyName}"/>
<%-- 		<input type="hidden" name="uniformNumbers" value="${compJB.uniformNumbers}"/> --%>
<%-- 		<input type="hidden" name="categories" value="${compJB.categories}"/> --%>
<%-- 		<input type="hidden" name="account" value="${compJB.account}" autocomplete="off"/> --%>
<%-- 		<input type="hidden" name="password" value="${compJB.password}" autocomplete="off"/> --%>
<%-- 		<input type="hidden" name="email" value="${compJB.email}" autocomplete="off"/> --%>
<%-- 		<input type="hidden" name="phone"  value="${compJB.phone}"/> --%>
<%-- 		<input type="hidden" name="bankId"  value="${compJB.bankId}"/> --%>
		<input type="submit" value="刪除企業檔案"/>

	</form>
<%-- 企業名稱:${compJB.companyName} --%>

</body>
</html>
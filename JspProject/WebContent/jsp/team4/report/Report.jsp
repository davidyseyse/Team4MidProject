<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="Ting">
<title>Sales Report</title>
<!-- jquery CDN -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<!-- jquery UI -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- jquery color -->
<script src="https://code.jquery.com/color/jquery.color-2.2.0.js"></script>
<!-- 外掛css Button Styles -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- 外掛css -->
<link rel="stylesheet" href="/JspProject/jsp/css/Reportcss.css">

<script>
	
</script>
<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>
</head>

<body>

	<!--左邊選項區-->
	<div class="rep_divleft">
		<div class="rep_logophoto">logo</div>
		<div class="rep_optionplace">
			<form action="#" method="POST" enctype="multipart/form-data">
				<p class="rep_optionplace_text">單項報表項目選取</p>
				<span>年份</span> <select>
					<option>2019</option>
					<option>2020</option>
				</select><br /> <span>月份</span> <select>
					<option>01</option>
					<option>02</option>
					<option>03</option>
					<option>04</option>
					<option>05</option>
					<option>06</option>
					<option>07</option>
					<option>08</option>
					<option>09</option>
					<option>10</option>
					<option>11</option>
					<option>12</option>
				</select>
				<p>
					<input type="radio" name="radio" id="radio-1" value="StoreSalesAll">全部門市銷售
				</p>
				<p>
					<input type="radio" name="radio" id="radio-2"
						value="StoreProfitAll">全部門市毛利
				</p>
				<p>
					<input type="radio" name="radio" id="radio-3"
						value="StoreSalesMonth">每月銷售金額
				</p>
				<p>
					<input type="radio" name="radio" id="radio-4"
						value="StoreSalesAmount">每月銷售數量
				</p>
				<p>
					<input type="radio" name="radio" id="radio-4" value="CalssSalesAll">類別銷售金額
				</p>
				<p>
					<input type="radio" name="radio" id="radio-4"
						value="CalssSalesAmountAll">類別銷售數量
				</p>
				<p>
					<input type="radio" name="radio" id="radio-4"
						value="ActiveSalesAll">活動銷售金額
				</p>
				<p>
					<input type="radio" name="radio" id="radio-4" value="ClassStock">類別庫存數量
				</p>
				<p>
					<input type="radio" name="radio" id="radio-4" value="Payment">付款方式
				</p>
				<p>
					<input type="radio" name="radio" id="radio-4" value="">待想
				</p>
				<p style="padding: 5px 0px 0px 18px;">
					<input type="submit" value="送出" style="width: 50px; height: 30px;">
					<span style="padding: 5px 0px 0px 5px;"><input type="reset"
						value="清除" style="width: 50px; height: 30px"></span>
				</p>
			</form>
		</div>
	</div>

	<!-- 中間報表區 -->
	<div class="rep_reportarea">
		<div>
			<div class="rep_tabsitem" id="tabs">
				<ul>
					<li><button type="button" class="btn btn-outline-primary"
							name="button1" id="button1">
							<a href="#tabs-1">單項項目報表</a>
						</button></li>
					<li><button type="button" class="btn btn-outline-secondary"
							name="button2" id="button2">
							<a href="#tabs-2">年度各店業績排名</a>
						</button></li>
					<li><button type="button" class="btn btn-outline-success"
							name="button3" id="button3">
							<a href="#tabs-3">年度商品銷售排名</a>
						</button></li>
					<li><button type="button" class="btn btn-outline-warning"
							name="button4" id="button4">
							<a href="#tabs-4">上月各店業績排名</a>
						</button></li>
					<li><button type="button" class="btn btn-outline-danger"
							name="button5" id="button5">
							<a href="#tabs-5">自訂報表</a>
						</button></li>
				</ul>
				<fieldset class="rep_tabs_photo">
					<div id="tabs-1">
						<p>長條圖1</p>
					</div>
					<div id="tabs-2">
						<p>長條圖2</p>
					</div>
					<div id="tabs-3">
						<p>長條圖3</p>
					</div>
					<div id="tabs-4">
						<p>長條圖4</p>
					</div>
					<div id="tabs-5">
						<p>長條圖5</p>
					</div>
				</fieldset>
			</div>
			<div>
				<fieldset class="rep_tabs_db">
					<legend>資料表</legend>
					<div id="tabs-1">
						<table class="table table-striped">
							<thead class="rep_table_font">
								<tr>
									<th>報表id</th>
									<th>公司id</th>
									<th>門市id</th>
									<th>門市地區</th>
									<th>門市名稱</th>
									<th>商品類別</th>
									<th>商品名稱</th>
									<th>銷售日期</th>
									<th>商品單價</th>
									<th>商品銷售數量</th>
									<th>付款方式</th>
									<th>活動項目</th>
								</tr>
							</thead>

							<tbody class="rep_table_font">
								<c:forEach var="lista" items="${list}">
									<tr>
										<td>${lista.reportid}</td>
										<td>${lista.companyid}</td>
										<td>${lista.storeid}</td>
										<td>${lista.storearea}</td>
										<td>${lista.storename}</td>
										<td>${lista.productclass}</td>
										<td>${lista.productname}</td>
										<td>${lista.salesdate}</td>
										<td>${lista.salesamount}</td>
										<td>${lista.productprice}</td>
										<td>${lista.payment}</td>
										<td>${lista.activeitem}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</fieldset>
			</div>
			<div class="rep_downloadbutton">
				<input type="button" value="xml" style="width: 50px; height: 30px">
				<input type="button" value="Json" style="width: 50px; height: 30px">
				<input type="button" value="csv" style="width: 50px; height: 30px">
			</div>
		</div>
	</div>

	<!-- 要排序功能喔! -->

	<div class="rep_crud">
		<form action="../../../ReportServlet.do" method="post">
			<fieldset>
				<legend>期中專題使用</legend>
				<Span>公司ID:</Span> <select name="Companyid">
					<option>A001</option>
					<option>B002</option>
					<option>C003</option>
					<option>D004</option>
					<option>E005</option>
				</select> <Span>門市ID:</Span> <input type="text" size="8" value="12"
					name="Storeid"> <Span>門市地區:</Span> <select name="Storearea">
					<option>北區</option>
					<option>中區</option>
					<option>南區</option>
				</select> <Span>門市名稱:</Span> 
					<input type="text" size="8" value="小巨蛋店" name="Storename"> 
					<Span>商品類別:</Span> 
					<select	name="Productclass">
					<option>飲料</option>
					<option>熟食</option>
					<option>冰品</option>
					<option>生活用品</option>
					<option>報章雜誌</option>
					</select> 
				<Span>商品名稱:</Span> 
					<input type="text" size="8" value="冰鎮紅茶" name="Productname"><br> 
				<Span>銷售日期:</Span> 
					<input type="text" size="8" value="2020/12/13" name="Salesdate"> 
				<Span>銷售數量:</Span>
					<input type="text" size="8" value="5" name="Salesamount"> 
				<Span>銷售單價:</Span>
					<input type="text" size="8" value="25" name="Productprice">
				<Span>付款方式:</Span> <select name="Payment">
					<option>信用卡</option>
					<option>滿幣</option>
				</select> 
				<Span>活動項目:</Span> 
					<input type="text" size="8" value="無" name="Activeitem"><br>
			</fieldset>
			<br> <input type="submit" value="送出" 	name="submitdata" class="repform">
		</form>
		<form action="../../../ReportServletShow.do" method="post" class="repform">
			<input type="submit" value="查詢" name="quiredata">
		</form>
		<form action="../../../ReportServletUpdate.do" method="post" class="repform">
			<input type="submit" value="修改" name="revisedata"> 
			<span>報表ID:</span>
			<input type="text" value="1" name="Reportid" size="2">
					<Span>商品類別:</Span> 
					<select	name="Productclass">
					<option>飲料</option>
					<option>熟食</option>
					<option>冰品</option>
					<option>生活用品</option>
					<option>報章雜誌</option>
					</select> 
				<Span>商品名稱:</Span> 
					<input type="text" size="8" value="日月潭紅茶" name="Productname"> 
				<Span>銷售數量:</Span>
					<input type="text" size="8" value="35" name="Salesamount"> 
				<Span>銷售單價:</Span>
					<input type="text" size="8" value="30" name="Productprice">
		</form>
	</div>
</body>

</html>
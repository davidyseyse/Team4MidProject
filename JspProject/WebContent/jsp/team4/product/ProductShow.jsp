<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顯示商品資訊</title>
<style type="text/css">
#content {
	width: 820px;
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
<body style="background: #EBFFEB;">
	<!-- 下列敘述設定變數funcName的值為SHO，top.jsp 會用到此變數 -->
	
	<!-- 引入共同的頁首 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


	<div id='content'>
		<form action="http://localhost:8080/JspProject/src/tw/midproject/product/jdbc/MidJdbcServlet.java" method="POST" target="">
		<TABLE style="width: 820; border: 2px solid black;">
			<!--   購物車的標題   -->
			<TR>
				<TD colspan='4'>
					<TABLE
						style="background: #FFE4C4; border: 1px solid black; width: 820px">
						<TR height='2'>
						
							<TH width="270">&nbsp;</TH>
							<TH width="280">&nbsp;</TH>
							<TH width="270">&nbsp;</TH>
						</TR>
						<TR height='10'>
							<TD width="240">&nbsp;</TD>
							<TD width="320" align='center'><FONT color='#8000FA'
								size='+2' style="font-weight: 900;"> ${AppName} </FONT></TD>
							<!-- <TD width="270" align='right'>
                      <FONT  color='red' size='-1'>
                         ${cartContent}
                      </FONT>
                   </TD> -->
						</TR>
	
						<TR height='2'>
							<TD width="270"><A
								href="<c:url value='../_04_ShoppingCart/ShowCartContent.jsp?pageNo=${pageNo}' />">
									購物清單 </A></TD>
							<TD width="280">&nbsp;</TD>
					
						</TR>
					</TABLE>
				</TD>
			</TR>

			<TR bgColor=#BBFFEE height='25'>
				<TD rowspan='3' width='64'>
					<!-- 
                       getImage所對應的Servlet會到資料庫讀取圖片並傳送給前端的瀏覽器
                    --> <img height='100' width='80'
					src=''>
				</TD>
				<TD height='32' width='560'>
					<TABLE border='1'>
						<TR height='30'>
							<TD width='560'>商品名：${MidProductJavaBean.ProductName}</TD>
						</TR>
					</TABLE>
				</TD>
				<TD rowspan='3' width='180' align='center'>
					<!-- <FORM  action='BuyBook.do' method="POST">  --> <!-- 
                FORM表單的資料會送後端的 _03_listBooks.controller.BuyBookServlet.java
                               來處理 
             -->
					<FORM action="<c:url value='InsertProduct.do' />" method="POST">
						購買數量: <select name='qty'>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
						</select>
						<!-- 這些隱藏欄位都會送到後端 -->
						<Input type='hidden' name='ProductId' value='${MidProductJavaBean.ProductId}'>
						<Input type='hidden' name='ProductName' value='${MidProductJavaBean.ProductName}'>
						<Input type='hidden' name='StoreID' value='${MidProductJavaBean.StoreID}'>
						<Input type='hidden' name='StoreID'
							value='${MidProductJavaBean.StoreID}'> <Input type='hidden'
							name='ProductPrice' value='${MidProductJavaBean.ProductPrice}'> <Input
							type='hidden' name='Discount' value='${MidProductJavaBean.Discount}'>
						
						<Input type='submit' value='加入購物車'>
					</FORM>
				</TD>
			</TR>
			<TR height='32' bgColor=#BBFFEE>
				<TD width='560'>
					<TABLE border='1'>
						<TR height='31'>
							<TD width='420'>店家：${MidProductJavaBean.StoreID}</TD>
							<TD width='140'>門市：${MidProductJavaBean.StoreID}</TD>
						</TR>
					</TABLE>
				</TD>
			</TR>
			<TR height='32' bgColor=#BBFFEE>
				<TD width='560'>
					<TABLE border='1'>
						<TR height='31'>
							<TD width='100'>商品Id：${MidProductJavaBean.StoreID}</TD>
							<TD width='100'>商品類別：${MidProductJavaBean.ProductType}</TD>
							<TD width='360'>訂價：${MidProductJavaBean.ProductPrice}  元<br />
								實售:${MidProductJavaBean.ProductPrice*MidProductJavaBean.Discount}元

							</TD>

						</TR>
						</form>
					</TABLE>
				</TD>
			</TR>
			
		</TABLE>
		
		
		
		
	</div>
	
	<div id='content'>
		<TABLE style="width: 820; border: 2px solid black;">
			<!--   購物車的標題   -->
			<TR>
				<TD colspan='4'>
					<TABLE
						style="background: #FFE4C4; border: 1px solid black; width: 820px">
						<TR height='2'>
						
							<TH width="270">&nbsp;</TH>
							<TH width="280">&nbsp;</TH>
							<TH width="270">&nbsp;</TH>
						</TR>
						<TR height='10'>
							<TD width="240">&nbsp;</TD>
							<TD width="320" align='center'><FONT color='#8000FA'
								size='+2' style="font-weight: 900;"> ${AppName} </FONT></TD>
							<!-- <TD width="270" align='right'>
                      <FONT  color='red' size='-1'>
                         ${cartContent}
                      </FONT>
                   </TD> -->
						</TR>
	
						<TR height='2'>
							<TD width="270"><A
								href="<c:url value='../_04_ShoppingCart/ShowCartContent.jsp?pageNo=${pageNo}' />">
									購物清單 </A></TD>
							<TD width="280">&nbsp;</TD>
					
						</TR>
					</TABLE>
				</TD>
			</TR>

			<TR bgColor=#BBFFEE height='25'>
				<TD rowspan='3' width='64'>
					<!-- 
                       getImage所對應的Servlet會到資料庫讀取圖片並傳送給前端的瀏覽器
                    --> <img height='100' width='80'
					src=''>
				</TD>
				<TD height='32' width='560'>
					<TABLE border='1'>
						<TR height='30'>
							<TD width='560'>商品名：${MidProductJavaBean.ProductName}</TD>
						</TR>
					</TABLE>
				</TD>
				<TD rowspan='3' width='180' align='center'>
					<!-- <FORM  action='BuyBook.do' method="POST">  --> <!-- 
                FORM表單的資料會送後端的 _03_listBooks.controller.BuyBookServlet.java
                               來處理 
             -->
					<FORM action="<c:url value='BuyProduct.do' />" method="POST">
						購買數量: <select name='qty'>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
						</select>
						<!-- 這些隱藏欄位都會送到後端 -->
						<Input type='hidden' name='ProductId' value='${MidProductJavaBean.ProductId}'>
						<Input type='hidden' name='ProductName' value='${MidProductJavaBean.ProductName}'>
						<Input type='hidden' name='StoreID' value='${MidProductJavaBean.StoreID}'>
						<Input type='hidden' name='StoreID'
							value='${MidProductJavaBean.StoreID}'> <Input type='hidden'
							name='ProductPrice' value='${MidProductJavaBean.ProductPrice}'> <Input
							type='hidden' name='Discount' value='${MidProductJavaBean.Discount}'>
						
						<Input type='submit' value='加入商品清單'>
					</FORM>
				</TD>
			</TR>
			<TR height='32' bgColor=#BBFFEE>
				<TD width='560'>
					<TABLE border='1'>
						<TR height='31'>
							<TD width='420'>店家：${MidProductJavaBean.StoreID}</TD>
							<TD width='140'>門市：${MidProductJavaBean.StoreID}</TD>
						</TR>
					</TABLE>
				</TD>
			</TR>
			<TR height='32' bgColor=#BBFFEE>
				<TD width='560'>
					<TABLE border='1'>
						<TR height='31'>
							<TD width='100'>商品Id：${MidProductJavaBean.StoreID}</TD>
							<TD width='100'>商品類別：${MidProductJavaBean.ProductType}</TD>
							<TD width='360'>訂價：${MidProductJavaBean.ProductPrice}  元<br />
								實售:${MidProductJavaBean.ProductPrice*MidProductJavaBean.Discount}元
								
							</TD>

						</TR>
					</TABLE>
				</TD>
			</TR>
			
		</TABLE>
		
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event Input Page</title>
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
<h3>Event Input Page-展覽</h3>
<form name="myForm" action="EventInputSystemProcessServlet1.do" method="post">
	<a href="eventInputPage1.jsp">展覽</a>
	<a href="eventInputPage2.jsp">樂園與景點</a>
	<a href="eventInputPage3.jsp">運動賽事</a>
	<a href="eventInputPage4.jsp">台灣高鐵</a>
	<a href="eventInputPage5.jsp">演唱會與戲劇</a>
	<hr/>
		<input type="hidden" name="typeId" value="1"/>
		<input type="hidden" name="companyId" value="1"/>
	
		<label class="t1" for="">展覽名稱:</label>
			<input type="text" name="eventName" required="required"><br><br>
		<label class="t1" for="">展覽地點:</label>
			<input type="text" name="eventLocation" required="required"><br><br>		
		<label class="t1" for="">售票系統:</label>
			<select name="organizationId" required>
				<option value="1">寬宏</option>
				<option value="2">兩廳院</option>
				<option value="3">中信兄弟</option>
				<option value="4">統一獅</option>
				<option value="5">UDN</option>
				<option value="6">博客來</option>
			</select><br><br>
		<input type="hidden" name="companyId" value="1"/>
		
		<label class="t1" for="">展覽宣傳圖片:</label>
			<input type="text" name="eventImage"><br><br>
			
		
		<%-- 以上為eventBean 以下為exhibitionBean --%>
		
		<label class="t1" for="" >起始售票時間:</label>
			<input type="date" name="onSaleD" required="required">
			<input type="time" name="onSaleT" required="required"><br><br>
		<label class="t1" for="">結束售票時間:</label>
			<input type="date" name="offSaleD" required="required">
			<input type="time" name="offSaleT" required="required"><br><br>
		<label class="t1" for="">展覽起始日:</label>
			<input type="date" name="commDate" required="required"><br><br>
		<label class="t1" for="">展覽終止日:</label>
			<input type="date" name="dueDate"><br><br>
		<label class="t1" for="">描述:</label>
			<textarea style="resize:none;width:600px;height:200px;" name="description"></textarea><br><br>
		
		<label class="t1" for="" >優惠信用卡:</label>	
			<select name="cardId" required="required">
				<option value="" selected>請選擇</option>
				<option value="1">LINE PAY信用卡</option>
				<option value="2">中油聯名卡</option>
				<option value="3">中信兄弟聯名卡</option>
				<option value="4">酷玩卡</option>
				<option value="5">統一時代悠遊聯名卡</option>
				<option value="6">臺北南山廣場聯名卡</option>
				</select><br><br>
				
		<!-- 
		<label class="t1" for="" >優惠銀行:</label>	
			<select name="bankId" onChange="renew(this.selectedIndex)" required>
				<option value="" selected>請選擇</option>
				<option value="1">中國信託商業銀行</option>
				<option value="2">玉山商業銀行</option>
				<option value="3">台北富邦商業銀行</option>
				<option value="4">國泰世華商業銀行</option>
				<option value="5">花旗（台灣）商業銀行</option>
				<option value="6">台新國際商業銀行</option>
				</select><br><br>
		<label class="t1" for="">優惠信用卡:</label>
			<select name="cardName" required>
				</select><br><br>
	<script>
	
	bankId=new Array();
	bankId[1]=["LINE PAY信用卡","中油聯名卡","中信兄弟聯名卡","酷玩卡"]; //中信
	bankId[2]=["統一時代悠遊聯名卡","臺北南山廣場聯名卡","玉山 Pi 拍錢包信用卡"]; //玉山
	bankId[3]=["富邦數位生活卡","momo卡","富邦悍將悠遊聯名卡","富邦J卡"]; //富邦
	bankId[4]=["KOKO COMBO icash聯名卡","長榮航空聯名卡","Costco聯名卡"]; //國泰
	bankId[5]=["花旗的卡1"]
	bankId[6]=["@GOGO卡","FlyGo卡","玫瑰卡","街口聯名卡"]; //台新
	
	function renew(index){
		for(var i=0;i<bankId[index].length;i++)
			document.myForm.cardId.options[i]=new Option(bankId[index][i], bankId[index][i]);	// 設定新選項
			document.myForm.cardId.length=bankId[index].length;	// 刪除多餘的選項
	}	
	</script> -->
	
	<%-- 以上為exhibitionBean 以下為priceBean --%>
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
		
//			function addPrice() { //綁定按鈕的按一下事件
//				
//				document.querySelector("#price").innerHTML += '<div>'+
//				'<label class="t1" for="">票券名稱:</label>'+
//				'<input type="text" name="priceName" required="required"><br>'+
//				'<label class="t1" for="">票券價格:</label>'+
//				'<input type="text" name="priceCost" required="required">'+
//				'<a href="#" class="btn btn-danger">刪除</a><br><br></div>';
//			}
			$("#price").on("click",".btn-danger",function(){
                $(this).closest("div").remove(); 
            })
		</script>
	<input type="submit" name="sumbmit" id="s1">
	<a href="serviceShowEventServlet.do" class="btn btn-success" role="button">查詢所有票券</a>	
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<title>쇼핑몰</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<link rel="stylesheet" href="../home.css" />
</head>
<body>
	<div id="divPage">
		<div id="divMenu"><jsp:include page="../menu.jsp" /></div>
		<div id="divHeader">
			<h2>상 품 목 록</h2>
		</div>
		<div id="divCondition">
			<div id="divSearch">
				<select id="selKey">
					<option value="prod_id">상품코드</option>
					<option value="prod_name">상품명</option>
					<option value="mall_name">업체명</option>
					<option value="company">제조사</option>
				</select> <input type="text" id="txtWord"> <select id="selPerPage">
					<option value="5">선택하세요.</option>
					<option value="3">3행</option>
					<option value="5">5행</option>
					<option value="10">10행</option>
				</select> <input type="button" id="btnSearch" value="검색"> <span
					style="font-size: 12px;">검색수: <b id="count"></b>건
				</span>
			</div>
			<div id="divSort">
				<select id="selOrder">
					<option value="prod_id">상품코드</option>
					<option value="prod_name">상품명</option>
					<option value="mall_name">업체명</option>
					<option value="company">제조사</option>
					<option value="price1">일반가</option>
					<option value="price2">판매가</option>
				</select>
				 <select id="selDesc">
					<option value="">오름차순</option>
					<option value="desc" selected>내림차순</option>
				</select>
			</div>
		</div>
		<table id="tbl"></table>
	<script id="temp" type="text/x-handlebars-template">   
    	<tr class="title">      
			<td width=50>이미지</td>  
   			<td width=40>상품코드</td>       
     		<td width=220>상품명</td>      
     		<td width=120>업체명</td>     
      		<td width=110>제조사</td>    
        	<td width=60>판매가</td>   
			<td width=60>일반가</td>   
			<td width=75>장바구니</td>
			<td width=75>상품정보</td>
   		</tr>     
   		{{#each array}}  
      	<tr class="row">    
			<td><img src=/img/product/{{image}} width=50></td> 
      		<td class="prod_id">{{prod_id}}</td>  
          	<td class="prod_name">{{prod_name}}</td>    
        	<td>{{mall_name}}</td>        
    		<td>{{company}}</td>       
     		<td>{{price1}}</td>   
			<td>{{price2}}</td>
			<td><button class="btnCart">장바구니</button></td>
			<td><button class="btnInfo">상품정보</button></td>
     	</tr>      
  		{{/each}}  
  </script>
	<div id="pagination">
		<button id="btnPre">◀</button>
		<button id="btnNext">▶</button>
		[<span id="curPage"></span>/<span id="totPage"></span>]
	</div>
	</div>
</body>
<script>
	var url = "/shop/product/list";
	
	//상품정보 버튼을 눌렀을때
	$("#tbl").on("click", ".row .btnInfo", function(){
		var prod_id=$(this).parent().parent().find(".prod_id").html();
		location.href="read?prod_id=" + prod_id;
	});
	
	//장바구니 버튼을 눌렀을때
	$("#tbl").on("click", ".row .btnCart", function(){
		var id=$(this).parent().parent().find(".prod_id").html();
		var name=$(this).parent().parent().find(".prod_name").html();
		
		if(!confirm(name+" 상품을 장바구니에 담겠습니까?")) return;
		
		$.ajax({
			type:"post",
			url:"/shop/cart/insert",
			data:{"prod_id":id},
			success:function(){
				alert("장바구니에 " + name + " 이 담겼습니다.");
			}
		});
	});
	
	$("#selPerPage, #selOrder, #selDesc").change(function(){
		   page=1;
		   getList();
		});
</script>
<script src="../home.js"></script>
</html>

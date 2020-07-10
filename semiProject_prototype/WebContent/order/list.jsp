<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>SHOPPING MALL</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<jsp:include page="../top.jsp"></jsp:include>
	<div id="divPage">
		<h1>발주현황 </h1>
		<div id="divCondition">
			
		</div> 
		<table id="tbl" border=1></table>
		<script id="temp" type="text/x-handlebars-template">
 			<tr class="title">
				<td>주문 번호</td>
				<td>발주 지점</td>
				<td>상품명</td>
 				<td>상품 카테고리</td>
				<td>발주수량</td>
				<td>단가</td>
				<td>총 합계</td>
				<td>주문 날짜</td>
 			</tr>
 			{{#each array}}
 			<tr class="row">
 				<td>{{order_id}}</td>
				<td>{{cvs_name}}<br>[{{cvs_code}}]</td>
				<td>{{product_name}}<br>[{{category_code}}{{product_code}}]</td>
 				<td>{{category_name}}</td>
 				<td>{{order_quantity}}</td>
 				<td>{{product_price}}원</td>
				<td>{{total}}원</td>
				<td>{{order_date}}</td>
 			</tr>
			{{/each}}
 		</script>
		<div id="pagination">
			<button id="btnPre">◀</button>
			<button id="btnNext">▶</button>
			[<span id="curPage"></span>/<span id="totPage"></span>]
		</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
<script>
	url="list"
</script>
<script src="../home.js"></script>
</html>
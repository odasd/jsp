<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>한빛 미디어</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<div id="page">
		<div id="center">
			<div id="content">
				<h2>[장바구니]</h2>
				
				<table id="tbl" border=1>
					<tr class="title">
						<td width=20><input type="checkbox" id="chkAll"></td>
						<td>카테고리</td>
						<td>상품번호</td>
						<td>상품명</td>
						<td>가격</td>
						<td>제조사</td>
						<td>수량</td>
						<td>합계</td>
						<td>수정</td>
						<td>삭제</td>
					</tr>
					<c:forEach items="${listCart}" var="vo"> 
						<tr class="row">
							<td><input type="checkbox" class="chk"></td>
							<td class="category_name">${vo.category_name}</td>
							<td class="product_code">${vo.category_code}${vo.product_code}</td>
							<td class="product_name">${vo.product_name}</td>
							<td class="product_price">${vo.product_price}</td>
							<td class="company">${vo.company}</td>
							<td>
								<input type="text" value="${vo.order_quantity}" size=1 class="order_quantity">
							</td>
							<td class="sum">${vo.product_price*vo.order_quantity}</td>
							<td><button class="btnUpdate">수정</button></td>
							<td><button class="btnDelete">삭제</button></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="pagination">
					<button id="btnAll">전체상품주문</button>
					<button id="btnSel">선택상품주문</button>
			</div>
			<!-- 주문정보쓰 -->
		<div id="divOrderInfo">
			<div id="divHeader">
				<h2>[주문하기]</h2>
				<table id="tblOrder"></table>
				<script id="tempOrder" type="text/x-handlebars-template">
 				<tr class="title">
 					<td>카테고리</td>
 					<td>상품코드</td>
 					<td>상품명</td>
					<td>제조사</td>
					<td>상품가격</td>
 					<td>상품수량</td>
 					<td>합계</td>
 				</tr>
 				{{#each .}}
				<tr class="row">
 					<td class="category_name">{{category_name}}</td>
					<td class="product_code">{{category_code}}{{product_code}}</td>
					<td class="product_name">{{product_name}}</td>
					<td class="company">{{company}}</td>
 					<td class="product_price">{{product_price}}</td>
 					<td class="order_quantity">{{order_quantity}}</td>
 					<td class="sum">{{sum}}</td>
 					</tr>
 				{{/each}}
 				<tr class="title">
 					<td colspan=6>합계</td><td id="totSum" class="sum"></td>
				</tr>
				</script>
				<form name="frm">
					<table id="tblPurchase">
						<tr>
							<td class="title" with=100>지점 코드</td>
							<td><input type="text" name="cvs_code" size=10 value="C01"></td>
						</tr>
						<tr>
							<td class="title" with=100>주문 지점</td>
							<td><input type="text" name="cvs_name" size=10></td>
						</tr>
						<tr>
							<td class="title" with=100>배송지 주소</td>
							<td><input type="text" name="address" size=80></td>
						</tr>
						<tr>
							<td class="title" width=100>점주</td>
							<td><input type="text" name="ceo_name" size=40></td>
						</tr>
						<tr>
							<td class="title" width=100>전화 번호</td>
							<td><input type="text" name="tel" size=40></td>
						</tr>
					</table>
					<input type="hidden" name="order_id">
				<div id="pagination">
					<input type="submit" value="주문하기">
				</div>
				</form>
			</div>
		</div>
		</div>
	</div>
</body>
<script>

$(frm).submit(function(e){
	e.preventDefault();
	if (!confirm("상품을 주문하시겠습니까??")) return;
	
	var cvs_code = $(frm.cvs_code).val();
	
	$("#tblOrder .row").each(function() {
		var category_code = $(this).find(".product_code").html().substring(0, 1);
		var product_code = $(this).find(".product_code").html().substring(1);
		var order_quantity =$(this).find(".order_quantity").html();
		$.ajax({
			type : "post",
			url : "/semi/order/insert",
			data : {
				"cvs_code":cvs_code,
				"product_code" : product_code,
				"category_code" : category_code,
				"order_quantity" : order_quantity
			},
			dataType:"json",
			success : function(data) {
				alert(data.order_id);
			}
		});
	});
	alert("발주되었습니다");
});

	$("#tbl").on("click", ".row .btnUpdate", function() {
		var row = $(this).parent().parent();
		var category_code = row.find(".product_code").html().substring(0, 1);
		var product_code = row.find(".product_code").html().substring(1);
		var order_quantity = row.find(".order_quantity").val();
		if (!confirm("선택하신 상품의 수량을 변경하시겠습니까?"))
			return;
		$.ajax({
			type : "post",
			url : "/semi/cart/update",
			data : {
				"product_code" : product_code,
				"category_code" : category_code,
				"order_quantity" : order_quantity
			},
			success : function() {
				alert("변경되었습니다.");
				location.href = "/semi/cart/cart.jsp";
			}
		});
	});
	$("#tbl").on("click", ".row .btnDelete", function() {
		var row = $(this).parent().parent();
		var category_code = row.find(".product_code").html().substring(0, 1);
		var product_code = row.find(".product_code").html().substring(1);
		if (!confirm("선택하신 상품을 장바구니에서 삭제하시겠습니까?"))
			return;
		$.ajax({
			type : "post",
			url : "/semi/cart/delete",
			data : {
				"product_code" : product_code,
				"category_code" : category_code
			},
			success : function() {
				alert("삭제되었습니다.");
				location.href = "/semi/cart/cart.jsp";
			}
		});
	});

	$("#divOrderInfo").hide();
	//맨위에 체크누르면 체크다하기
	$("#tbl").on("click", ".title #chkAll", function() {
		if ($(this).is(":checked")) {
			$(".row .chk").each(function() {
				$(this).prop("checked", true);
			});
		} else {
			$(".row .chk").each(function() {
				$(this).prop("checked", false);
			});
		}
	});
	//각 행에 잇는 체크 버ㅡㅌㄴ 눌럿을 떄 ㄹㅇㅇㅇㅇㅇㅇ
	$("#tbl").on("click", ".row .chk", function() {
		var isChkAll = true;
		$("#tbl .row .chk").each(function() {
			if (!$(this).is(":checked"))
				isChkAll = false;
		});

		if (isChkAll) {
			$("#tbl #chkAll").prop("checked", true);
		} else {
			$("#tbl #chkAll").prop("checked", false);
		}
	});

	$("#btnAll").on("click", function() {
		showOrder($("#tbl .row"));
	});

	$("#btnSel").on("click", function() {
		var array = [];
		if ($("#tbl .row .chk:checked").length > 0) {
			$("#tbl .row .chk:checked").each(function() {
				var row = $(this).parent().parent();
				array.push(row);
			});
			showOrder(array);
		} else {
			alert("선택한 상품이 없습니다.");
		}

	});

	function showOrder(row) {
		$("#divCart").hide();
		$("#divOrderInfo").show();
		var totSum = 0;
		var array = [];
		$(row).each(
				function() {
					var category_code = $(this).find(".product_code").html()
							.substring(0, 1);
					var product_code = $(this).find(".product_code").html()
							.substring(1);
					var category_name = $(this).find(".category_name").html();
					var product_name = $(this).find(".product_name").html();
					var product_price = $(this).find(".product_price").html();
					var company = $(this).find(".company").html();
					var order_quantity = $(this).find(".order_quantity").val();
					var sum = $(this).find(".sum").html();
					totSum = totSum + parseInt(sum);
					var data = {
						"category_code" : category_code,
						"product_code" : product_code,
						"category_name" : category_name,
						"product_name" : product_name,
						"product_price" : product_price,
						"company" : company,
						"order_quantity" : order_quantity,
						"sum" : sum
					};
					array.push(data);
				});
		var template = Handlebars.compile($("#tempOrder").html());
		$("#tblOrder").html(template(array));
		$("#totSum").html(totSum);
	}
</script>
</html>
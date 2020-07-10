<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>한빛 미디어</title>
	<link rel="stylesheet" href="../home.css">
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
	<div id="page">
		<div id="header"><jsp:include page="../header.jsp"></jsp:include></div>
		<div id="center">
			<div id="menu"><jsp:include page="../menu.jsp"/></div>
			<div id="content">
				<h2>[장바구니]</h2>
				<div class="something">
					<button id="delete">삭제</button>&nbsp;
					<span id="totCnt">전체 상품 갯수 : ${cnt}개&nbsp;</span>
					<span id="totPri">상품총 금액 : <fmt:formatNumber value="${tot}" pattern="#,###원"/></span>
				</div>
				<table width=700 id="tbl" border=1>
					<tr class="title">
						<td><input type="checkbox" id="chkAll"></td>
						<td width=100>코드</td>
						<td width=300>제목</td>
						<td width=100>단가</td>
						<td width=50>수량</td>
						<td width=100>금액</td>
						<td width=50>수정</td>
					</tr>
					<c:forEach items="${listCart}" var="vo" varStatus="i"> 
						<tr class="row">
							<td><input type="checkbox" class="chk" id="${i.index}" value="${vo.code}"></td>
							<td class="code">${vo.code}</td>
							<td>${vo.title}</td>
							<td class="price"><fmt:formatNumber value="${vo.price}" pattern="#,###원"/></td>
							<td>
								<input type="text" value="${vo.number}" size=1 class="number">
							</td>
							<td class="sum"><fmt:formatNumber value="${vo.sum}" pattern="#,###원"/></td>
							<td><button>수정</button></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div id="footer"><jsp:include page="../footer.jsp"></jsp:include></div>
	</div>
</body>
<script>
	//수정버튼
	$("#tbl").on("click",".row button" ,function(){
		var row=$(this).parent().parent();
		var code=row.find(".code").html();
		var number=row.find(".number").val();
		if(!confirm(code+" 을(를) " + number + " 로 수정하시겠습니까?")) return;
		$.ajax({
			type:"post",
			url:"/book/cartUpdate",
			data:{"code":code, "number":number},
			success:function(){
				location.href="/book/cart";
				alert("수정되었습니다.");
				
			}
		});
	});

	//전체 선택
		$("#chkAll").on("click", function(){
			if($("#tbl .title #chkAll").prop("checked")==false) {
				$("#tbl .row .chk").prop("checked", false);
			} if($("#tbl .title #chkAll").prop("checked")==true) {
				$("#tbl .row .chk").prop("checked", true);
			}
		});
	
	//삭제
	
	var array=new Array();
	var tlist=${cnt};

		$(".something").on("click", "button", function(){
			for(var i=0; i<tlist; i++) {
				if($(".row #"+i).prop("checked")==true) {
					var code=$(".row #"+i).val();
					array[i]=code;
				}	
			}
			$.ajax({
				type:"post",
				url:"/cart/delete",
				traditional : true,
				data:{"array":array},
				success:function(){
					location.href="/book/cart";
					alert("삭제되었습니다.");
				}
			});
		});
	
	
</script>
</html>
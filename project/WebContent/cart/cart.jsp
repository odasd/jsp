<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>한빛 미디어</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
	<div id="page">
		<div id="center">
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
						<td width=50>수량</td>
						<td width=50>수량</td>
						<td width=100>금액</td>
						<td width=50>수정</td>
					</tr>
					<c:forEach items="${listCart}" var="vo"> 
						<tr class="row">
							<td><input type="checkbox" class="chk"></td>
							<td class="cvs_code">${vo.cvs_code}</td>
							<td>${vo.category_code}</td>
							<td>${vo.product_code}</td>
							<td>${vo.product_name}</td>
							<td class="price"><fmt:formatNumber value="${vo.product_price}" pattern="#,###원"/></td>
							<td>
								<input type="text" value="${vo.Order_quantity}" size=1 class="number">
							</td>
							<td class="sum"><fmt:formatNumber value="" pattern="#,###원"/></td>
							<td><button>수정</button></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
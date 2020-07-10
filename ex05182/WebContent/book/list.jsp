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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<div id="page">
		<div id="header"><jsp:include page="../header.jsp"></jsp:include></div>
		<div id="center">
			<div id="menu"><jsp:include page="../menu.jsp"/></div>
			<div id="content">
				<h2>책 정보</h2>
				<div id="search">
					<form action="list" name="frm">
						<select name="key">
							<option value="code" <c:out value="${key=='code'? 'selected':''}"/>>책 코드</option>
							<option value="title" <c:out value="${key=='title'? 'selected':''}"/>>책 제목</option>
							<option value="writer" <c:out value="${key=='writer'? 'selected':''}"/>>책 저자</option>
						</select>
						<input type="text" name="word" value="${word}">
						<input type="submit" value="검색" id="btnSearch">
						<input type="hidden" name="page" value="${page}">
						전체 검색수 : "${count}"
					</form>
				</div>
				<table id="tbl"	width=600 border=1>
					<tr class="title">
						<th width=100>책 코드</th>
						<th width=400>책 제목</th>
						<th width=100>저자</th>
						<th width=100>가격</th>
					</tr>
					<c:forEach items="${list}" var="vo">
					<tr class="row">
						<td width=100 class="center">${vo.code}</td>
						<td width=400 class="left">${vo.title}</td>
						<td width=100 class="center">${vo.writer}</td>
						<td width=100 class="number"><fmt:formatNumber value="${vo.price}" pattern="#,###원"></fmt:formatNumber></td>
					</tr>
					</c:forEach>
				</table>
				<div id="pagenation">
					<c:if test="${page==totpage && totpage!=1}">
						<button id="btnPre">◀이전</button>
						<button id="btnNext" disabled>다음▶</button>
					</c:if>
					
					<c:if test="${page==1}">
					<button id="btnPre" disabled>◀이전</button>
					<button id="btnNext">다음▶</button>
					</c:if>
					
					<c:if test="${page>1 && page<totpage}">
						<button id="btnPre">◀이전</button>
						<button id="btnNext">다음▶</button>
					</c:if>
					{${page}/${totpage}}
				</div>
			</div>
		</div>
		<div id="footer"><jsp:include page="../footer.jsp"></jsp:include></div>
	</div>
</body>
<script>
	//이전버튼 눌렀을때
	$("#btnPre").on("click", function(){
		
		var page=$(frm.page).val();
		
		page--;
		$(frm.page).val(page);
		$(frm).submit();
		
	});
	
	//다음버튼 눌렀을때
	$("#btnNext").on("click", function(){
		
		var page=$(frm.page).val();
		page++;
		$(frm.page).val(page);
		$(frm).submit();

	});
</script>
</html>
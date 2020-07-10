<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				<h2>[게시판 글쓰기]</h2>
				<form action="insert" method="post" name="bfrm">
				<c:if test="${id == null}">
				<input type="hidden" value="guest" name="writer">
				</c:if>
				<c:if test="${id != null}">
				<input type="hidden" value="${id}" name="writer">
				</c:if>
				<table width=500 border=1 id="tbl">
					<tr class="row">
						<td class="title">제목</td>
						<td><input type="text" size=50 name="title"></td>
					</tr>
					<tr class="row">
						<td colspan=2>
						<textarea rows="15" cols="70" name="content"></textarea>
						</td>
					</tr>
				</table>
				<input type="submit" value="저장">
				<input type="reset" value="취소">
				</form>
			</div>
		</div>
		<div id="footer"><jsp:include page="../footer.jsp"></jsp:include></div>
	</div>
</body>
<script>
	$(bfrm).submit(function(e){
		e.preventDefault();
		if(!confirm("저장하시겠습니까?")) return;
		
		var title=$(bfrm.title).val();
		var content=$(bfrm.content).val();
		
		if(title=="") {
			alert("제목을 입력하세요.");
			$(bfrm.title).focus();
		} else if(content=="") {
			alert("내용을 입력하세요.");
			$(bfrm.content).focus();
		} else {
			bfrm.submit();
		}
	});
</script>
</html>
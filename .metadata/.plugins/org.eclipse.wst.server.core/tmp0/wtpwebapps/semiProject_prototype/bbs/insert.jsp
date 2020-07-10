<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<title>24/7</title>
	<link rel="stylesheet" href="../home.css">
</head>
<body>
	<div id=divPage>
	<div id="divTop"><jsp:include page="../top.jsp" /></div>
		<div id=header></div>
		<div id=center>
			<div id=menu><jsp:include page="../menu.jsp"/></div>
			<div id=content>
				<!-- 여기부터 출력할 내용 -->
				<h2>칭찬해요</h2>
				<form action="insert" method="post" name="frm">
					<c:if test="${id==null}">
						<input type="hidden" value="guest" name="writer">
					</c:if>
					<c:if test="${id!=null}">
						<input type="hidden" value="${id}" name="writer">
					</c:if>
					<table width=500 id=tbl>
					<tr class=row>
						<td class=title>제목</td>
						<td><input type="text" size=50 name="title"></td>
					</tr>
					<tr class=row>
						<td colspan=2>
							<textarea rows="10" cols="65" name="content"></textarea>
						</td>
					</tr>
					</table>
					<input type="submit" value="저장">
					<input type="reset" value="취소">
				</form>
				<!-- 작성 종료 -->
			</div>
		</div>
		<div id="divFoot" style="text-align: center"><jsp:include page="../footer.jsp" /></div>
	</div>
</body>
<script>
	$(frm).submit(function(event){
		event.preventDefault();
		var title=$(frm.title).val();
		var content=$(frm.content).val();
		if(!confirm("저장하시겠습니까?")) return;
		if(title==""){
			alert("제목을 입력하세요!");
			$(frm.title).focus();
		}else if(content==""){
			alert("내용을 입력하세요!");
			$(frm.content).focus();
		}else{
			frm.submit();
		}
	});
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="user.*, java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>교수 목록</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
   	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
   	<style>
   		.row:hover{background:gray;color:white;cursor:pointer;}
   	</style>
</head>
<body>
	<h1>[교수 목록]</h1>
	<a href="insert">교수 등록</a>
	<table id="tbl" border=1 width=700>
		<tr class=title>
			<td>교수번호</td>
			<td>교수이름</td>
			<td>학과</td>
			<td>직급</td>
			<td>급여</td>
			<td>임용일</td>
		</tr>
		<c:forEach items="${list}" var="vo">
		<tr class=row>
			<td class=pcode>${vo.pcode}</td>
			<td>${vo.pname}</td>
			<td>${vo.dept}</td>
			<td>${vo.title}</td>
			<td><fmt:formatNumber value="${vo.salary}" pattern="#,###"/></td>
			<td><fmt:formatDate value="${vo.hiredate}" pattern="yyyy년MM월dd일"/></td>
		</tr>	
		</c:forEach>
	</table>
</body>
<script>
	//수정화면이동
	$("#tbl").on("click", ".row", function(){
		var pcode=$(this).find(".pcode").html();
		location.href="read?pcode="+pcode;
	});
</script>
</html>
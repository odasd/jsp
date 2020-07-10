<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>학생목록</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
	<div><%@ include file="../menu.jsp" %></div>
	<h1>[학생목록]</h1>
	<a href="insert">학생등록</a>
	<table border=1 width=700 id=tbl>
		<tr class=title>
			<td>학생번호</td>
			<td>학생이름</td>
			<td>학생학과</td>
			<td>학생학년</td>
			<td>학생생일</td>
			<td>담당교수</td>
		</tr>
		<c:forEach items="${array}" var="vo">
			<tr class=row>
				<td class=scode>${vo.scode}</td>
				<td>${vo.sname}</td>
				<td>${vo.dept}</td>
				<td>${vo.year}</td>
				<td>${vo.birthday}</td>
				<td>${vo.pname}</td>
			</tr>
		</c:forEach>
	</table>
	<div><%@ include file="../bottom.jsp" %></div>
</body>
<script>
	//학생정보 보기
	$("#tbl").on("click",".row", function(){
		var scode=$(this).find(".scode").html();
		location.href="read?scode=" + scode;
	});
</script>
</html>
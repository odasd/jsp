<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<div><%@ include file="../menu.jsp" %></div>
	<h1>[교수 목록]</h1>
	<a href="insert">교수등록</a>
	<table id="tbl" border=1 width=600>
		<tr class=title>
			<td>교수번호</td>
			<td>교수이름</td>
			<td>학과</td>
			<td>직급</td>
			<td>급여</td>
			<td>임용일</td>
			<td>담당과목</td>
    	    <td>지도학생</td>
		</tr>
		<c:forEach items="${list}" var="vo">
		<!-- request에 어트리뷰트값 가져올땐 달러중괄호형식을 사용한다. -->
		<!-- 겟어트리뷰트list랑 같다.   -->
		<!-- 이것이 JSTL 태그라이브러리이다. -->
		<tr class=row>
			<td class=pcode>${vo.pcode}</td>
			<td>${vo.pname}</td>
			<td>${vo.dept}</td>
			<td>${vo.title}</td>
			<td><fmt:formatNumber value="${vo.salary}" pattern="#,###"/></td>
			<td><fmt:formatDate value="${vo.hiredate}" pattern="yyyy년MM월dd일"/></td>
			<td><input type="button" value="담당과목 " id="btnCo"></td>
     		<td><input type="button" value="지도학생" id="btnSt"></td>
		</tr>
		</c:forEach>
	</table>
	<div><%@ include file="../bottom.jsp" %></div>
</body>
<script>
	
	//수정화면이동
	$("#tbl").on("click", ".row", function(){
		var pcode=$(this).find(".pcode").html();
		location.href="read?pcode="+pcode;
	});
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사용자 목록</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<div id="page">
	<div><%@include file="../menu.jsp" %></div>
	<h1>[사용자 목록]</h1>
	<div id="tt"><a href="insert">사용자등록</a></div>
	<table id="tbl" border=1 width=700>
		<tr class=title>
			<td>아이디</td>
			<td>패스워드</td>
			<td>성명</td>
			<td>삭제</td>
			<td>수정</td>
		</tr>
		<c:forEach items="${list}" var="vo">
		<!-- request에 어트리뷰트값을 가져올 땐 달러중괄호형식을 사용한다. -->
		<!-- 겟어트리뷰트list랑 같다.   -->
		<!-- 이것이 JSTL 자바스크립트 태그 라이브러리이다. -->
		<tr class=row>
			<td class=id>${vo.id}</td>
			<td>${vo.pass}</td>
			<td><input type=text class=uname value="${vo.uname}" pre="${vo.uname}"></td>
			<td><button class=del>삭제</button></td>
			<td><button class=update>수정</button></td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
<script>
	$("#tbl").on("click", ".row .del", function(){
		var row=$(this).parent().parent();
		var id=row.find(".id").html(); //val() 입력받은 값을 가져오는것, html()은 입력되있는 값을 가져오는것
		if(!confirm(id + "을(를) 삭제하시겠습니까?"))return;
		location.href="delete?id=" + id;
	});
	
	$("#tbl").on("click", ".row .update", function(){
		var row=$(this).parent().parent();
		var id=row.find(".id").html();
		var pre=row.find(".uname").attr("pre"); //prop 기초값이 변할수 있는걸 사용, attr 초기값 그대로 변하지 않음
		var uname=row.find(".uname").val();
		if(!confirm(pre + "을(를)  " + uname + "으로 수정하시겠습니까?"))return;
		location.href="update?id=" + id + "&uname=" + uname;
	});
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사용자 등록</title>
</head>
<body>
<div id="page">
	<div><%@include file="../menu.jsp" %></div>
	<h1>[사용자 등록]</h1>
	<form action="insert" method="post">
	<table border=1 id="tbl">
		<tr>
			<td>아이디:</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>비밀번호:</td>
			<td><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td>성명:</td>
			<td><input type="text" name="uname"></td>
		</tr>
	</table>
	<div id="but">
	<input type="submit" value="저장">
	<input type="reset" value="취소">
	</div>
	</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
</head>
<body>
	<form action="login" method="post">
	<table border=1 width=300>
	<tr>
		<td colspan=2><h2 style="text-align:center">로그인</h2></td>
	</tr>
	<tr>
		<td>아이디:</td>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td>비밀번호:</td>
		<td><input type="password" name="pass"></td>
	</tr>	
	<tr>
		<td colspan=3><input type="submit" value="로그인"></td>
	</tr>
	</table>
	</form>
</body>
</html>
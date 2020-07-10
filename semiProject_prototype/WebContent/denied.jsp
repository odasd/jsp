<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인후 이용해주세요.</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
	<h1>로그인후 이용해주세요.</h1><br>
	<input type="button" id="cvs_login" value="점주로그인">
	<input type="button" id="company_login" value="관리자로그인">
</body>
<script>

	$("#cvs_login").on("click", function(){
		alert("점주 로그인");
		location.href="/semi_project/user/cvs_login.jsp";
	});
	
	$("#company_login").on("click", function(){
		alert("관리자 로그인");
		location.href="/semi_project/user/company_login.jsp";
	});
</script>
</html>
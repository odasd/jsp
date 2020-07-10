<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<div id="page">
	<div><%@include file="../menu.jsp" %></div>
	<form action="login" method="post" name="frm">
		<table border=1 width=800 id="tbl3">
			<tr>
				<td colspan=2><h2>로그인</h2></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan=2><input type="submit" value="로그인"><a href="/user/insert">회원가입</a></td>
				
			</tr>
		</table>
	</form>
	</div>
</body>
<script>
	$(frm).submit(function(e){
		e.preventDefault();
		var id=$(frm.id).val();
		var pass=$(frm.pass).val();
		$.ajax({
			type:"post",
			url:"/login",
			dataType:"json",
			data:{"id":id,"pass":pass},
			success:function(data){
				if(data.id==null) {
					alert("아이디/비밀번호가 일치하지 않습니다.");
					$(frm.id).focus();
				} else {
					alert(data.name + "님이 입장하셨습니다.")
					location.href="/stu/list";
				}
			}
		});
	});
</script>
</html>
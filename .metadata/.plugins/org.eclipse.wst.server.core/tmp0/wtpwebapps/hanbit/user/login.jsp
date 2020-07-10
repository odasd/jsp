<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>

<form name="frm">
	<div id="id">아이디  :  <input type="text" name="id" size=10></div>
	<div id="pass">비밀번호 : <input type="password" name="password" size=9></div><br>
		<input type="submit" value="로그인">
		<a href="/user/insert" style="font-size:12px; text-decoration:none;">회원가입</a>
</form>
<script>
	$(frm).submit(function(e) {
		e.preventDefault();
		
		var id=$(frm.id).val();
		var password=$(frm.password).val();

		if(id=="" || password=="") {
			alert("아이디/비밀번호를 입력하세요.")
		} else {
			$.ajax({
				type:"post",
				url:"/user/login",
				data:{"id":id , "password":password},
				dataType:"json",
				success:function(data){
					if(data.id==null) {
						alert("아이디와 비밀번호가 일치하지 않습니다.")
					} else {
						location.href="/index.jsp";
					}
				}
			});
		}
	});
</script>
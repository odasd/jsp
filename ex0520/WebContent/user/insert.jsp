<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>한빛 미디어</title>
	<link rel="stylesheet" href="../home.css">
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
	<div id="page">
		<div id="header"><jsp:include page="../header.jsp"></jsp:include></div>
		<div id="center">
			<div id="menu"><jsp:include page="../menu.jsp"/></div>
			<div id="content">
				<h2>[회원가입]</h2>
				<form name="ufrm">
					<table width=500 border=1>
						<tr class="row">
							<td class="title">아이디</td>
							<td><input type="text" name="id"></td>
						</tr>
						<tr class="row">
							<td  class="title">비밀번호</td>
							<td><input type="password" name="pass"></td>
						</tr>
						<tr class="row">
							<td  class="title">이름</td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr class="row">
							<td  class="title">직업</td>
							<td><input type="text" name="job"></td>
						</tr>
						<tr class="row">
							<td  class="title">연락처</td>
							<td><input type="text" name="tel"></td>
						</tr>
					</table>
					<input type="submit" value="저장">
					<input type="reset" value="취소">
				</form>
			</div>
		</div>
		<div id="footer"><jsp:include page="../footer.jsp"></jsp:include></div>
	</div>
</body>
<script>
	$(ufrm).submit(function(e){
		e.preventDefault();
		if(!confirm("저장하시겠습니까?")) return;
		
		var id=$(ufrm.id).val();
		var pass=$(ufrm.pass).val();
		var name=$(ufrm.name).val();
		var job=$(ufrm.job).val();
		var tel=$(ufrm.tel).val();
		if(id=="" || pass=="" || job=="" || tel=="") {
			alert("모든 데이터를 입력하세요.");
		} else {
			$.ajax({
				type:"post",
				url:"/user/insert",
				data:{"id":id, "pass":pass, "name":name, "job":job ,"tel":tel},
				dataType:"json",
				success:function(data){
					if(data.count==0) {
						alert("등록 완료되었습니다.")
						location.href="/user/list";
					} else {
						alert("이미 등록된 회원입니다.");
						$(ufrm.id).focus();
					}
				}
			});
		}
			
			
	});
</script>
</html>
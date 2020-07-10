<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
		<div id="header"><jsp:include page="../header.jsp"/></div>
		<div id="center">
			<div id="menu"><jsp:include page="../menu.jsp"/></div>
			
			<div id="content">
				<h2>[회원 목록]</h2>
				
				<form action="update" method="post" name="form">
				
				<table id="tbl" width=500>
				
					<tr class=row>
						<td>회원이름</td>
						<td><input type="text"  value="${vo.name}" name="name" readonly></td>
					</tr>
					
					<tr>
						<td>회원계정</td>
						<td><input type="text" value="${vo.id}" name="id"></td>
					</tr>
					
					<tr>
						<td>직업</td>
						<td><input type="text"  value="${vo.job}" name="job"></td>
					</tr>
					
					<tr>
						<td>연락처</td>
						<td><input type="text" value="${vo.tel}" name="tel"></td>
					</tr>
					
				</table>
				
				<input type="submit" value="수정">
				<input type="button" id="btnDel" value="삭제">
				<input type="button" value="목록" onClick="location.href='/user/list'">
				
				</form>
			</div>
		</div>
		<div id="footer"><jsp:include page="../footer.jsp"></jsp:include></div>
	</div>
</body>
<script>

$("#btnDel").on("click", function(){
    if(!confirm("회원을 삭제하시겠습니까?")) return;
    form.action="delete"; 
    form.method="post"; 
    form.submit(); 
 });

$(form).submit(function(e){
    e.preventDefault();
    if(!confirm("수정하시겠습니까?")){
       return;
    }else{
       form.submit();
    }
 });

</script>
</html>
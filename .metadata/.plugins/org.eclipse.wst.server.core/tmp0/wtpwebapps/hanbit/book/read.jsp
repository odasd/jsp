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
				<h2>[도서 목록]</h2>
				
				<form action="update" method="post" name="form">
				
				<table id="tbl" width=500>
				
					<tr class=row>
						<td>책코드</td>
						<td><input type="text"  value="${vo.code}" name="code" readonly></td>
					</tr>
					
					<tr>
						<td>책제목</td>
						<td><input type="text" value="${vo.title}" name="title"></td>
					</tr>
					
					<tr>
						<td>책저자</td>
						<td><input type="text"  value="${vo.writer}" name="writer"></td>
					</tr>
					
					<tr>
						<td>가격</td>
						<td><input type="number" value="${vo.price}" name="price"></td>
					</tr>
					
				</table>
				
				<input type="submit" value="수정">
				<input type="button" id="btnDel" value="삭제">
				<input type="button" value="목록" onClick="location.href='/book/list'">
				
				</form>
			</div>
		</div>
		<div id="footer"><jsp:include page="../footer.jsp"></jsp:include></div>
	</div>
</body>
<script>

$("#btnDel").on("click", function(){
    if(!confirm("도서를 삭제하시겠습니까?")) return;
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
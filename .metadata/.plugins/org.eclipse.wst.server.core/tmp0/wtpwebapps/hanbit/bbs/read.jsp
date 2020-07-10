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
				<h2>[게시글 읽기]</h2>
				<div>[제목]: ${vo.title}</div>
				<div>[작성일자]: ${vo.wdate}</div>
				<div>[작성자]: ${vo.writer}</div>
				-------------------------------------<br>
				${vo.content}
			</div>
		</div>
		<div id="footer"><jsp:include page="../footer.jsp"></jsp:include></div>
	</div>
</body>
<script>
	
</script>
</html>
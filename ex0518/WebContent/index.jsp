<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>한빛 미디어</title>
	<link rel="stylesheet" href="home.css">
</head>
<body>
	<div id="page">
		<div id="header"><jsp:include page="header.jsp"></jsp:include></div>
		<div id="center">
			<div id="menu"><jsp:include page="menu.jsp"/></div>
			<div id="content">
				<h2>[회사소개]</h2>
				<div>
					한빛미디어(주)는 지난 15년동안 국내 컴퓨터/정보통신 분야의 성장과 더불어 IT 전문가들의 
					풍부한실무경험과 현장 노하우를 책으로 출간하면서 해당 분야의 IT개발자들과 함께 발전해왔습니다.
				</div>
			</div>
		</div>
		<div id="footer"><jsp:include page="footer.jsp"></jsp:include></div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>블로그 검색</title>
	<meta name="viewport" content="user-scalable=no, width=device-width" charset="euc-kr"/>
    <link href="home_mobile.css" rel="stylesheet" type="text/css" media="screen and (max-width:799px)">
    <link href="home.css" rel="stylesheet" type="text/css" media="screen and (min-width:800px)">
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
<div id="divPage">
	<div id="divMenu"><jsp:include page="menu.jsp" /></div>
	<div id="divHeader">
			<h2>블로그 검색</h2>
		</div>
	<div id="divCondition">
		<input type="text" id="query" value="자바">
		<input type="button" value="검색" id="btnSearch">
		<select id="display">
			<option value="5">5행</option>
			<option value="10">10행</option>
			<option value="15">15행</option>
		</select>
		<span id="total"></span>
		<table id="tbl" border=1></table>
		<script id="temp" type="text/x-handlebars-template"> 
			<tr class="title">
				<td>제목</td>	
			</tr>
			{{#each items}}
			<tr class="row">
				<td><a href="{{link}}">{{{title}}}</a></td>
			</tr>
			{{/each}}
		</script>
		<div id="pagination">
			<button id="btnPre">◀</button>
			<button id="btnNext">▶</button>
			[<span id="curPage"></span>/<span id="totPage"></span>]
		</div>
	</div>
</div>
</body>
<script>

var url="/API/naver/blog";

</script>
<script src="home.js"></script>
</html>
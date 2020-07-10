<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<title>편의점 관리시스템</title>
	<link rel="stylesheet" href="../home.css">
</head>
<body>
	<div id="divPage">
		<div id="divCenter">
			<div id="divMenu"><jsp:include page="../menu.jsp"/></div>
 			<div id="divContent">
			<!-- 여기에 내용 등록 시작--------------------------------------------->
				<div id="divHeader">
					<h2>게 시 글 목 록</h2>
				</div>
				<div id="divCondition">
					<div id="divSearch">
						<select id="selKey">
							<option value="bno">게시번호</option>
							<option value="title">제목</option>
							<option value="date">작성일</option>
						</select>
						<input type="text" id="txtWord">
						<select id="selPerPage">
							<option value="3">3행</option>
							<option value="5" selected>5행</option>
							<option value="10">10행</option>
						</select>
	 					<input type="button" id="btnSearch" value="검색">
	 					<span style="font-size:12px;">검색수: <b id="count"></b>건</span>
					</div>
					<div id="divSort">
						<select id="selOrder">
							<option value="bno">게시번호</option>
							<option value="title">제목</option>
							<option value="date">작성일</option>
						</select>
						<select id="selDesc">
							<option value="">오름차순</option>
							<option value="desc">내림차순</option>
						</select>
					</div>
				</div>
				<table id="tbl"></table>
				<script id="temp" type="text/x-handlebars-template">
 				<tr class="title">
 					<td width=120>게시번호</td>
 					<td width=120>제목</td>
 					<td width=120>내용</td>
					<td width=120>좋아요</td>
					<td width=120>싫어요</td>
					<td width=120>작성일자</td>
 				</tr>
 				{{#each array}}
				<tr class="row">
 					<td class="bno">{{bno}}</td>
 					<td class="title">{{title}}</td>
 					<td class="contents">{{contents}}</td>
					<td class="ulike">{{ulike}}</td>
					<td class="dislike">{{dislike}}</td>
					<td class="date">{{date}}</td>
 				</tr>
 				{{/each}}
 				</script>
 				<div id="pagination">
 					<button id="btnPre">◀</button> <button id="btnNext">▶</button>
 					[<span id="curPage"></span>/<span id="totPage"></span>]
 				</div>
			<!-- 여기에 내용 등록 종료--------------------------------------------->
			</div>
		</div>
	</div>
</body>
<script>
	var url = "/semi_project/bbs/list";
</script>
<script src="../home.js"></script>
</html>
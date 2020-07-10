<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>한빛 미디어</title>
	<link rel="stylesheet" href="../home.css">
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<div id="page">
		<div id="header"><jsp:include page="../header.jsp"/></div>
		<div id="center">
			<div id="menu"><jsp:include page="../menu.jsp"/></div>
			<div id="content">
				<h2>[게시판 목록]</h2>
				<div id="search">
                  <select id="key">
                      <option value="title" >글제목</option>
                      <option value="writer" >작성자</option>
                      <option value="wdate" >작성일</option>
                      <option value="content" >글내용</option>
                  </select>
                  <input type="text" id="word">
                  <select id="perPage">
                  	<option value="5">5번까지 출력</option>
                  	<option value="10" selected>10번까지 출력</option>
                  	<option value="15">15번까지 출력</option>
                  	<option value="20">20번까지 출력</option>
                  </select>
                  <input type="button" value="검색" id="btnSearch">
                 	 검색수 : <span id="count"></span> <!-- span은 html로 받는듯? --><br>
                 	 
            </div>
            <div id="sort">
                 	 <select id="order">
                  		<option value="seqno">번호</option>
                  		<option value="title">제목</option>
                  		<option value="writer">작성자</option>
                  		<option value="wdate">작성일</option>
                  	</select>
                 	 
                 	 <select id="desc">
                  		<option value="">오름차순</option>
                  		<option value="desc" selected>내림차순</option>
                  	</select>
                  	<input type="button" value="정렬" id="btnSet">
                  	</div>
				<table id="tbl" width=700 border=1></table>
					<script id="temp" type="text/x-handlebars-template">
							<tr class=title>
								<td width=100>NO.</td>
								<td width=250>제목</td>
								<td width=100>작성자</td>
								<td width=200>작성일</td>
								<td width=50>삭제</td>
							</td>
						{{#each list}}
							<tr class=row>
								<td class="no">{{seqno}}</td>
								<td class="atitle">{{title}}</td>
								<td>{{writer}}</td>
								<td>{{wdate}}</td>
								<td><button>삭제</button></td>
							</tr>
						{{/each}}
					</script>
					<div id="pagenation">
						<button id="btnPre">◀이전</button>
						<button id="btnFir">처음</button>
						<button id="btnNext">다음▶</button>
						[<span id="spage"></span>/
						<span id="stotPage"></span>]
					</div>
			</div>
		</div>
		<div id="footer"><jsp:include page="../footer.jsp"></jsp:include></div>
	</div>
</body>
<script>


var key;
var word;
var page=1;
var perPage;
var totPage;
var order;
var desc;

getList();

	$("#tbl").on("click", ".row button", function(){
		var row=$(this).parent().parent();
		var no=row.find(".no").html();
		$.ajax({
			type:"post",
			url:"/bbs/delete",
			data:{"no":no},
			success:function(){
				if(!confirm("삭제하시겠습니까?")) return;
				location.href="/bbs/list.jsp";
			}
		})
		
	});

	$("#perPage").change(function(){ //change 선택한 갯수만큼 바로바로 출력됨
		page=1;
		getList();
	});
	
	$("#btnFir").on("click", function(){
		page=1;
		getList();
	});
	
	//글읽기
	$("#tbl").on("click", ".row .atitle", function(){
		var row=$(this).parent();
		var no=row.find(".no").html();
		location.href="read?no=" + no;
	});
	
	$("#btnSet").on("click", function(){
		page=1;
		getList();
	});
	
	if(page==1){
		$("#btnPre").attr("disabled", true);
	} 
	if(page==totPage){
		$("#btnNext").attr("disabled", true);
	} 
	
	$("#btnPre").on("click", function(){
		page--;
		getList();
	});
	
	$("#btnNext").on("click", function(){
		page++;
		getList();
	});
	
	function getList(){
		key=$("#key").val();
		word=$("#word").val();
		perPage=$("#perPage").val();
		order=$("#order").val();
		desc=$("#desc").val();
		
		$.ajax({
			type:"get",
			url:"/bbs/list.json",
			data:{"key":key, "word":word, "page":page, "perPage":perPage, "order":order, "desc":desc},
			dataType:"json",
			success:function(data){
				var temp=Handlebars.compile($("#temp").html());
				$("#tbl").html(temp(data));
				$("#count").html(data.count);
				
				if(data.count==0) {
					$("#pagenation").hide();
				} else {
					$("#pagenation").show();
				}
				if(page==1) {
					$("#btnPre").attr("disabled", true)
				} else {
					$("#btnPre").attr("disabled", false)
				}
				if(page==data.totPage) {
					$("#btnNext").attr("disabled", true)
				} else {
					$("#btnNext").attr("disabled", false)
				}
				$("#spage").html(page);
				$("#stotPage").html(data.totPage);
			}
		});
	}
	
	$("#btnSearch").on("click", function(){
		page=1;
		getList();
	});
	
	$("#word").keydown(function(key){
		if(key.keyCode==13) {
			page=1;
		getList();
		}
	});
</script>
</html>
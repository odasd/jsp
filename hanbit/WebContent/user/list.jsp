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
				<h2>[회원 목록]</h2>
				<div id="search">
                  <select id="key">
                      <option value="name" >회원 이름</option>
                      <option value="id" >회원 아이디</option>
                      <option value="job" >직업</option>
                      <option value="tel" >전화번호</option>
                  </select>
                  <input type="text" id="word">
                  <select id="perPage">
                  	<option value="10">선택하세요</option>
                  	<option value="5">5번까지 출력</option>
                  	<option value="10">10번까지 출력</option>
                  	<option value="15">15번까지 출력</option>
                  	<option value="20">20번까지 출력</option>
                  </select>
                  <input type="button" value="검색" id="btnSearch">
                 	 검색수 : <span id="count"></span> <br><!-- span은 html로 받는듯? -->

            </div>
             <div id="sort">
                 	 <select id="order">
                  		<option value="name">이름</option>
                  		<option value="id">아이디</option>
                  		<option value="job">직장</option>
                  		<option value="tel">연락처</option>
                  	</select>
                 	 
                 	 <select id="desc">
                  		<option value="">오름차순</option>
                  		<option value="desc">내림차순</option>
                  	</select>
                  	<input type="button" value="정렬" id="btnSet">
                  	</div>
				<table id="tbl" width=600 border=1></table>
					<script id="temp" type="text/x-handlebars-template">
							<tr class=title>
								<td width=100>회원 이름</td>
								<td width=100>회원 아이디</td>
								<td width=100>직업</td>
								<td width=100>전화번호</td>
							</td>
						{{#each list}}
							<tr class=row>
								<td class=name>{{name}}</td>
								<td class=id>{{id}}</td>
								<td>{{job}}</td>
								<td>{{tel}}</td>
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

$("#btnFir").on("click", function(){
	page=1;
	getList();
});

//유저 목록
$("#tbl").on("click", ".row", function(){
	var row=$(this);
	var id=row.find(".id").html();
	
	location.href="/user/read?id=" + id;
	
});


	$("#btnSet").on("click", function(){
		page=1;
		getList();
	})

	/*
	if(page==1){
		$("#btnPre").attr("disabled", true);
	} 
	if(page==totPage){
		$("#btnNext").attr("disabled", true);
	} 
	*/
	$("#perPage").change(function(){ //change 선택한 갯수만큼 바로바로 출력됨
		page=1;
		getList();
	});
	
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
			url:"/user/list.json",
			data:{"key":key, "word":word, "page":page, "perPage":perPage, "order":order, "desc": desc},
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
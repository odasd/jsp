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
				<h2>[도서 목록]</h2>
				<div id="search">
                  <select id="key">
                      <option value="code" >책 코드</option>
                      <option value="title" >책 제목</option>
                      <option value="writer" >책 저자</option>
                      <option value="price" >가격</option>
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
                 	 검색수 : <span id="count"></span><br><!-- span은 html로 받는듯? -->
            </div>
            <div id="sort">
                 	 <select id="order">
                  		<option value="code">코드</option>
                  		<option value="title">제목</option>
                  		<option value="writer">저자</option>
                  		<option value="price">가격</option>
                  	</select>
                 	 
                 	 <select id="desc">
                  		<option value="">오름차순</option>
                  		<option value="desc" selected>내림차순</option>
                  	</select>
                  	<input type="button" value="정렬" id="btnSet">
                  	</div>
				<table id="tbl" width=600 border=1></table>
					<script id="temp" type="text/x-handlebars-template">
							<tr class=title>
								<td width=50>코드</td>
								<td width=300>제목</td>
								<td width=100>저자</td>
								<td width=100>가격</td>
								<td width=50>카트</td>
							</td>
						{{#each list}}
							<tr class=row>
								<td class="code">{{code}}</td>
								<td class="btitle">{{title}}</td>
								<td class="writer">{{writer}}</td>
								<td class="number">{{price}}</td>
								<td><button>카트</button></td>
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

$("#perPage").change(function(){ //change 선택한 갯수만큼 바로바로 출력됨
	page=1;
	getList();
});

$("#btnFir").on("click", function(){
	page=1;
	getList();
});

//book read로 이동
$("#tbl").on("click", ".row .btitle", function(){
	var row=$(this).parent();
	var code=row.find(".code").html();
	location.href="/book/read?code=" + code;
});

//카트 담기버튼을 눌렀을때

$("#tbl").on("click", ".row button", function(){
	
	var row=$(this).parent().parent();
	var code=row.find(".code").html();
	var title=row.find(".btitle").html();
	var price=row.find(".number").html();
	
	if(!confirm(code + "상품을 저장하시겠습니까?")) return;
	$.ajax({
		type:"post",
		url:"/book/cart",
		data:{"code":code, "title":title, "price":price},
		success:function(){
			alert("장바구니에 1개 상품을 저장하였습니다.");
		}
	});
});

$("#btnSet").on("click", function(){
	page=1;
	getList();
});
	/*
	if(page==1){
		$("#btnPre").attr("disabled", true);
	} 
	if(page==totPage){
		$("#btnNext").attr("disabled", true);
	} 
	*/
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
			url:"/book/list.json",
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
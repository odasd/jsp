<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
		<div id="header"><jsp:include page="../header.jsp"></jsp:include></div>
		<div id="center">
			<div id="menu"><jsp:include page="../menu.jsp"/></div>
			<div id="content">
				<h2>회원 정보</h2>
				<div id="search">
					<form action="list" name="frm">
						<select name="key">
							<option value="id" <c:out value="${key=='id'? 'selected':''}"/>>아이디</option>
							<option value="name" <c:out value="${key=='name'? 'selected':''}"/>>이름</option>
							<option value="job" <c:out value="${key=='job'? 'selected':''}"/>>직업</option>
						</select>
						<input type="text" name="word" value="${word}">
						<input type="submit" value="검색" id="btnSearch">
						<input type="hidden" name="page" value="${page}">
						전체 검색수 : ${count} 건
					</form>
				</div>
				<table id="tbl"	width=600 border=1>
					<tr class="title">
						<th width=100>아이디</th>
						<th width=100>이름</th>
						<th width=100>직업</th>
						<th width=400>전화번호</th>
					</tr>
					<c:forEach items="${list}" var="vo">
					<tr class="row">
						<td width=100 class="center">${vo.id}</td>
						<td width=100 class="left">${vo.name}</td>
						<td width=100 class="center">${vo.job}</td>
						<td width=400 class="center">${vo.tel}</td>
					</tr>
					</c:forEach>
				</table>
				<div id="pagenation">
					<c:if test="${page==totpage && totpage!=1}">
						<button id="btnPre">◀이전</button>
						<button id="btnNext" disabled>다음▶</button>
					</c:if>
					
					<c:if test="${page==1}">
						<c:if test="${page==totpage}">
							<button id="btnPre" disabled>◀이전</button>
							<button id="btnNext" disabled>다음▶</button>
						</c:if>
						<c:if test="${page<totpage}">
							<button id="btnPre" disabled>◀이전</button>
							<button id="btnNext" >다음▶</button>
						</c:if>
					</c:if>
					
					<c:if test="${page>1 && page<totpage}">
						<button id="btnPre">◀이전</button>
						<button id="btnNext">다음▶</button>
					</c:if>
				
					<!-- 이친구도 가능하다
					<c:if test="${page==totPage && totPage>1}">
                        <button id="btnPre">◀</button>
                        <button id="btnNext" disabled>▶</button>
                     </c:if>
                     <c:if test="${page==1 && totPage>1}">
                        <button id="btnPre" disabled>◀</button>
                        <button id="btnNext">▶</button>
                     </c:if>
                     <c:if test="${page==1 && page==totPage}">
                        <button id="btnPre" disabled>◀</button>
                        <button id="btnNext" disabled>▶</button>
                     </c:if>
                     <c:if test="${page>1 && page<totPage}">
                        <button id="btnPre">◀</button>
                        <button id="btnNext">▶</button>
                     </c:if> -->
					<div id="page2">${page}/${totpage}</div>
					
				</div>
			</div>
		</div>
		<div id="footer"><jsp:include page="../footer.jsp"></jsp:include></div>
	</div>
</body>
<script>
	
	var totpage="${totpage}";
	var count="${count}";
	var page="${page}";
		
	if(count==0) {
		$("#page2").html("0/${totpage}");
	}
	
	/*
	//검색값이 없으면 가리기
	if(count==0) {
	$("#pagenation").hide();
	}
	 
	var page="${page}";
	var totpage="${totpage}";
	
	//연지씨 스타일
	 if(page==1){
        $("#btnPre").attr('disabled','true');
  }else{
     $("#btnPre").on("click",function(){
        page--;
        $(frm.page).val(page);
        $(frm).submit();
     });
  }
	
  if(page==totpage){
        $("#btnNext").attr('disabled','true');
  }else{
     $("#btnNext").on("click",function(){
        page++;
        $(frm.page).val(page);
        $(frm).submit();   
     });
  }
	//검색버튼 눌렀을때 페이지 값 1로 고정
	$("#btnSearch").on("click", function(){
		$(frm.page).val(1);
		$(frm).submit();
	});
	
	//엔터키 눌렀을때 페이지값 1로 고정
	$(frm.word).keydown(function(key){
		if(key.keycode==13) {
			$(frm.page).val(1);
			$(frm).submit();
		}
	});
	
	//disabled 대신에 이거로도 사용할수 있다.
	$("#btnPre").on("click", function(){
		var page=$(frm.page).val();
		if(page==1) {
			alert("시작페이지 입니다.")
		} else {
			page--;
			$(frm.page).val(page);
			$(frm).submit();
		}	
	});
	
		$("#btnNext").on("click", function(){
			var page=$(frm.page).val();
			if(page==totpage) {
				alert("마지막페이지 입니다.")
			} else {
				page++;
				$(frm.page).val(page);
				$(frm).submit();
			}	
		});
		
		if(page==1) {
			$("#btnPre").attr("disabled", true);
		}
		
		if(page==totpage) {
			$("#btnNext").attr("disabled", true);
		}
	*/
	
	//이전버튼 눌렀을때
	$("#btnPre").on("click", function(){
		
		var page=$(frm.page).val();
		page--;
		$(frm.page).val(page);
		$(frm).submit();
		
	});
	
	//다음버튼 눌렀을때
	$("#btnNext").on("click", function(){
		
		var page=$(frm.page).val();
		page++;
		$(frm.page).val(page);
		$(frm).submit();

	});
	

	$("#btnSearch").on("click", function(){
		$(frm.page).val(1);
		$(frm).submit();
	});
	
	$(frm.word).keydown(function(key){ //굳이 안해도 라이브러리에 있는거같다
		if(key.keycode==13) {
			$(frm.page).val(1);
			$(frm).submit();
		}
	});
</script>
</html>
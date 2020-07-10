<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<title>한빛 미디어</title>
	<link rel="stylesheet" href="../home.css">
</head>
<body>
	<div id=page>
		<div id=header></div>
		<div id=center>
			<div id=menu><jsp:include page="../menu.jsp"/></div>
			<div id=content>
				<!-- 여기부터 출력할 내용 -->
				<h2>[게시글 정보]</h2>
				<table id=tbl style="margin:0px 0px 5px 0px">
				<tr class=row>
					<td>글번호</td>
					<td id="seqno">${vo.seqno}</td>
				</tr>
				<tr class=row>
					<td>작성자</td>
					<td id="writer">${vo.writer}</td>
				</tr>
				<tr class=row>
					<td>날짜</td>
					<td id="wdate">${vo.wdate}</td>
				</tr>
				<tr class=row>
					<td>제목</td>
					<td><input type="text" id="txtTitle" value="${vo.title}" size=40></td>
				</tr>
				<tr class=row>
					<td colspan=2>
						<textarea id="txtContent" rows="10" cols="60">${vo.content}</textarea>
					</td>
				</tr>
				</table>
				<input type="button" id="btnUpdate" value="수정">
				<input type="button" id="btnDelete" value="삭제">
				<input type="button" value="목록" onClick="location.href='list.jsp'">
				<!-- 작성 종료 -->
			</div>
		</div>
		<div id=footer><jsp:include page="../footer.jsp"/></div>
	</div>
</body>
<script>
	//수정
	$("#btnUpdate").on("click",function(){
		var seqno=$("#seqno").html();
		var title=$("#txtTitle").val();
		var content=$("#txtContent").val();
		if(!confirm("수정하시겠습니까?")) return;
		if(title==""||content==""){
			alert("모든 값을 입력하세요!");
		}else{
			$.ajax({
				type:"post",
				url:"/bbs/update",
				data:{"seqno":seqno,"title":title,"content":content},
				success:function(){
					alert("수정되었습니다!");
				}	
			});
		}
	});
	
	//삭제
	$("#btnDelete").on("click",function(){
		var seqno="${vo.seqno}";
		var title="${vo.title}";
		if(!confirm("삭제하시겠습니까?")) return;
		$.ajax({
			type:"post",
			url:"/bbs/delete",
			data:{"seqno":seqno},
			success:function(){
				alert("삭제되었습니다!");
				location.href="list.jsp";
			}	
		});
	});
</script>
</html>
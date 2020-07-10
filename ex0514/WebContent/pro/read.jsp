<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>교수정보</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
	<h1>[교수정보]</h1>
	<form name="frm" action="update" method="post">
		<table border=1 width=500>
			<tr>
				<td>교수번호:</td>
				<td><input type="text" name="pcode" maxlength=3 value="${vo.pcode}" readonly></td>
			</tr>
			<tr>
				<td>교수이름:</td>
				<td><input type="text" name="pname" value="${vo.pname}"></td>
			</tr>
			<tr>
				<td>교수학과</td>
				<td>
					<select name="dept">
						<option <c:out value="${vo.dept.equals('전산')?'selected':''}"/>>전산</option>
						<option <c:out value="${vo.dept.equals('전자')?'selected':''}"/>>전자</option>
						<option <c:out value="${vo.dept.equals('건축')?'selected':''}"/>>건축</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>교수직급</td>
				<td>
					<input type="radio" name="title" value="정교수" <c:out value="${vo.title.equals('정교수')?'checked':''}"/>>정교수
					<input type="radio" name="title" value="부교수" <c:out value="${vo.title.equals('부교수')?'checked':''}"/>>부교수
					<input type="radio" name="title" value="조교수" <c:out value="${vo.title.equals('조교수')?'checked':''}"/>>조교수
				</td>
			</tr>
			<tr>
				<td>임용일자:</td>
				<td><input type="date" name="hiredate" value="${vo.hiredate}"></td>
			</tr>
			<tr>
				<td>급여:</td>
				<td><input type="number" name="salary" value="${vo.salary}"></td>
			</tr>
		</table>
		<input type="submit" value="수정">
		<input type="button" value="삭제" id="btnDelete">
		<input type="reset" value="취소">
		<input type="button" value="목록" onClick="location.href='list'">
	</form>
</body>
<script>

	$("#btnDelete").on("click", function(){
		var pcode=${vo.pcode};
		if(!confirm(pcode + "을(를) 삭제하시겠습니까?"))return;
		location.href='delete?pcode='+pcode;
	});

	$(frm).submit(function(e){	//name을 가져올 땐 더블쿼트가 없다.
		e.preventDefault();	//기본 이벤트 방지
		if(!confirm("수정하시겠습니까?"))return;
		
		var pcode=$(frm.pcode).val();
		var salary=$(frm.salary).val();
		var pname=$(frm.pname).val();
		
		if(pcode.length!=3){
			alert("교수코드를 다시 입력하세요!");
			$(frm.pcode).focus();
		}else if(pname==""){
			alert("교수이름을 입력하세요!");
			$(frm.pname).focue();
		}else if(salary==""){
			alert("급여를 입력하세요!");
			$(frm.salary).focus();
		}else{
			frm.submit();
		}
	});
</script>
</html>
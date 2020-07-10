<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>강좌등록</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<style>
		select{height:23px;}
	</style>
</head>
<body>
	<h1>[강좌등록]</h1>
	<form action="insert" method="post" name="frm">
	<table border=1 width=500>
		<tr>
			<td>강좌번호:</td>
			<td><input type="text" name="lcode" maxlength=4></td>
		</tr>
		<tr>
			<td>강좌이름:</td>
			<td><input type="text" name="lname"></td>
		</tr>
		<tr>
			<td>강의실:</td>
			<td><input type="text" name="room"></td>
		</tr>
		<tr>
			<td>강의시수:</td>
			<td><input type="text" name="hours"></td>
		</tr>		
		<tr>
			<td>지도교수:</td>
			<td>
				<select name="instructor">
				<c:forEach items="${plist}" var="v">
					<option value="${v.pcode}" <c:out value="${vo.instructor==v.pcode?'selected':''}"/> >${v.pcode}:${v.pname}:${v.dept}</option>
				</c:forEach>
				</select>
			</td>
		</tr>		
	</table>
	<input type="submit" value="저장">
	<input type="reset" value="취소">
	<input type="button" value="목록" onClick="location.href='list'">
	</form>
</body>
<script>
	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("저장하시겠습니까?")){
			return;
		}else{
			frm.submit();
		}
	});
</script>
</html>





<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="user.*, java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>교수 목록</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
   	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
   	<style>
   		.row:hover{background:gray;color:white;cursor:pointer;}
   	</style>
</head>
<body>
	<div><%@include file="../menu.jsp" %></div>
	<h1>[교수 목록]</h1>
	<a href="insert">교수 등록</a>
	<table id="tbl" border=1 width=700>
		<tr class=title>
			<td>교수번호</td>
			<td>교수이름</td>
			<td>학과</td>
			<td>직급</td>
			<td>급여</td>
			<td>임용일</td>
			<td>담당과목</td>
			<td>지도학생</td>
		</tr>
		<c:forEach items="${list}" var="vo">
		<tr class=row>
			<td class=pcode>${vo.pcode}</td>
			<td class=pname>${vo.pname}</td>
			<td>${vo.dept}</td>
			<td>${vo.title}</td>
			<td><fmt:formatNumber value="${vo.salary}" pattern="#,###"/></td>
			<td><fmt:formatDate value="${vo.hiredate}" pattern="yyyy년MM월dd일"/></td>
			<td><button class="btnCourses">담당과목</button>
			<td><button class="btnStudents">지도학생</button>
		</tr>	
		</c:forEach>
	</table>
	<div id=courses>
		<div>
			<h1>[담당과목:<span id="pname"></span>]</h1>
		</div>
		<table id="ctbl" border=1 width=700></table>
		<script id="ctemp" type="text/x-handlebars-template">
		{{#each .}}
			<tr class=row>
				<td class=lcode>{{lcode}}</td>
				<td>{{lname}}</td>
				<td>{{room}}</td>
				<td>{{hours}}</td>
			</tr>
		{{/each}}
		</script>
	</div>
</body>
<script>
	$("#courses").hide();
	var pcode;
	$("#tbl").on("click", ".row .btnCourses", function(){
		var row=$(this).parent().parent();
		pcode=row.find(".pcode").html();
		pname=row.find(".pname").html()
		$("#pname").html(pname);
		$("#courses").show();
		getClist();
	});
	
	$("#ctbl").on("click", ".row", function(){
		var row=$(this).parent().parent();
		var lcode=row.find(".lcode").html();
		location.href="/cou/read?lcode=" + lcode;
	});
	
	getClist();
	function getClist(){
		$.ajax({
			type:"get",
			url:"/pro/courses",
			data:{"pcode":pcode},
			dataType:"json",
			success:function(data){
				var temp=Handlebars.compile($("#ctemp").html());
		        $("#ctbl").html(temp(data));
			}
		});
	}
	//수정화면이동
	$("#tbl").on("click", ".row .pcode", function(){
		var pcode=$(this).html();
		location.href="read?pcode="+pcode;
	});
</script>
</html>
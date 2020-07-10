<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>강좌목록</title>
   <style>
         .row:hover{background:gray;color:white;cursor:pointer;}
      </style>
      <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
   <div><%@include file="../menu.jsp" %></div>
   <h1>[강좌목록]</h1>
   <a href="insert">강좌등록</a>
   <table id=tbl border=1 width=700>
   <tr class=title>
      <td>강좌번호</td>
      <td>강좌이름</td>
      <td>강의실</td>
      <td>강의시수</td>
      <td>담당교수</td>
   </tr>
   <c:forEach items="${array}" var="vo">
   <tr class=row>
      <td class=lcode>${vo.lcode}</td>
      <td>${vo.lname}</td>
      <td>${vo.room}</td>
      <td>${vo.hours}</td>
      <td>${vo.pname}</td>
   </tr>
   </c:forEach>
   </table>
   <div><%@include file="../bottom.jsp" %></div>
</body>
<script>
   //강좌정보 보기
   $("#tbl").on("click", ".row", function(){
      var lcode=$(this).find(".lcode").html();
      location.href="read?lcode=" + lcode;
   });
</script>
</html>
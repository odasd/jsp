<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>강좌정보</title>
   <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
   <style>
      select{height:23px;}
   </style>
</head>
<body>
   <h1>[강좌정보]</h1>
   <form action="update" method="post" name="frm">
   <table border=1 width=500 id="tbl">
      <tr class=row>
         <td>강좌번호:</td>
         <td><input type="text" name="lcode" maxlength=4 value="${vo.lcode}" readonly></td>
      </tr>
      <tr>
         <td>강좌이름:</td>
         <td><input type="text" name="lname" value="${vo.lname}"></td>
      </tr>
      <tr>
         <td>강의실:</td>
         <td><input type="text" name="room" value="${vo.room}"></td>
      </tr>
      <tr>
         <td>강의시수:</td>
         <td><input type="text" name="hours" value="${vo.hours}"></td>
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
   <input type="submit" value="수정">
   <input type="button" value="삭제" id="btnDel">
   <input type="reset" value="취소">
   <input type="button" value="목록" onClick="location.href='list'">
   </form>
</body>
<script>
   //삭제버튼을 클릭했을때
   $("#btnDel").on("click", function(){
      if(!confirm("강좌를 삭제하시겠습니까?")) return;
      frm.action="delete"; //location.href=delete?lcode= + lcode
      frm.method="post"; //var lcode=frm.tbl.(lcode).val();
      frm.submit(); 
   });
   
   /* 
	$(frm).on("click","#btnDel",function(){
	var lcode=(this).row.find(lcode).html();
	if(!confirm(lcode+"를 삭제하겠습니까?"))return;
	location.href="read?lcode=" + lcode;
	 });*/
   
   
   $(frm).submit(function(e){
      e.preventDefault();
      if(!confirm("수정하시겠습니까?")){
         return;
      }else{
         frm.submit();
      }
   });
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>강좌정보</title>
   <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
   <style>
      select{height:23px;}
   </style>
</head>
<body>
<div id="page">
	<div><%@include file="../menu.jsp" %></div>
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
   <div id="but">
   <input type="submit" value="수정">
   <input type="button" value="삭제" id="btnDel">
   <input type="reset" value="취소">
   <input type="button" value="목록" onClick="location.href='list'">
   </div>
   </form>
   <div id="enroll">
		<h1>[수강신청]</h1>	
   </div>
	<div>
		<table id ="tbl2" border=1 width=700></table>
		<script id="temp2" type="text/x-handlebars-template">
         {{#each .}}
         <tr class=row>
            <td class=scode>{{scode}}</td>
            <td class=sname>{{sname}}</td>
		    <td>{{edate}}</td>
 			<td><input class="grade" type="text" value="{{grade}}" size=2 maxlength=3></td>
			<td><button>수정</button></td>
         </tr>
         {{/each}}
      </script>
	</div>
	</div>
</body>
<script>
	var lcode="${vo.lcode}";

	getList();
	//수강신청목록 출력
	function getList() {
	$.ajax({
	    type:"get",
	    url:"/cou/enroll",
	    dataType:"json",
	    data:{"lcode":lcode},
	    success:function(data){
	    	
	       var temp=Handlebars.compile($("#temp2").html());
	       $("#tbl2").html(temp(data));
	    }
	 });
	}	
	
	//점수 수정버튼을 클릭했을때
	$("#tbl2").on("click", ".row button", function(){
		var row=$(this).parent().parent();
		var scode=row.find(".scode").html();
		var grade=row.find(".grade").val();
		
		if(!confirm(scode + "의 점수를 수정하시겠습니까?")) return;
		
		if(grade<0 || grade>100) {
			alert("점수를 다시입력하세요.");
			row.find(".grade").focus();
			row.find(".grade").val();
		} else {
		$.ajax({
		    type:"post",
		    url:"/enroll/update",
		    dataType:"json",
		    data:{"lcode":lcode, "scode":scode, "grade":grade},
		    success:function(){
		    	alert("수정완료되었습니다.");
		    	getList();
		    }
		 });
		}
	});
	
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
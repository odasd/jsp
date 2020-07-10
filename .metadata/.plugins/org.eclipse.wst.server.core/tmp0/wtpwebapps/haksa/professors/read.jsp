<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>학사관리시스템</title>
	<link rel="stylesheet" href="../home2.css">
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<div id="divPage">
		<div id="divTop"><jsp:include page="../header.jsp"/></div>
		<div id="divCenter">
		<div id="divMenu"><jsp:include page="../menu.jsp"/></div>
		<div id="divContent">
		<!---------------------여기에 내용출력 시작----------------------- -->
			<div id="divHeader"><h2>교수정보</h2></div>
		<form name="frm" action="update" method="post">    
			<table>      
				<tr>      
					<td width=100 class="title" width=150>교수번호</td> 
					<td width=100><input type="text" name="pcode" size=10 value="${vo.pcode}" readonly></td>    
					<td width=100 class="title" width=150>교수학과</td>    
					<td width=100>      
						<select name="dept">       
							<option value="전산" <c:out value="${vo.dept=='전산'?'selected':''}"/>>전산학과</option> 
							<option value="전자" <c:out value="${vo.dept=='전자'?'selected':''}"/>>전자학과 </option>
							<option value="건축" <c:out value="${vo.dept=='건축'?'selected':''}"/>>건축학과</option>
						</select>  
					</td>    
					<td width=100 class="title" width=150>임용일자</td>      
					<td>
						<input type="text" name="yy" size=2 maxlength=4 value="${fn:substring(vo.hirdate,0,4)}">년
						<input type="text" name="mm" size=2 maxlength=2 value="${fn:substring(vo.hirdate,5,7)}">월
						<input type="text" name="dd" size=2 maxlength=2 value="${fn:substring(vo.hirdate,8,10)}">일
					</td>    
				</tr>      
				<tr>      
					<td width=100 class="title" width=150>교수이름</td>      
					<td width=100><input type="text" name="pname" size=5 value="${vo.pname}"></td>
					<td width=100 class="title" width=150 >교수급여</td>     
					<td>
						<input type="text" name="salary" size=9 value="${vo.salary}">원
					</td>       
					<td width=100 class="title" width=150>교수직급</td>      
					<td>
						<input type="radio" name="title" value="정교수" <c:out value="${vo.title=='정교수'?'checked':''}"/>>정교수
						<input type="radio" name="title" value="부교수" <c:out value="${vo.title=='부교수'?'checked':''}"/>>부교수
						<input type="radio" name="title" value="조교수" <c:out value="${vo.title=='조교수'?'checked':''}"/>>조교수
					</td>   
				</tr> 
			</table>
			<div id="pagination">
				<input type="submit" value="수정">
				<input type="reset" value="취소">
				<input type="button" value="삭제" id="btnDelete">
			</div>
		</form>
		<div id="divHeader"><h2>담당강좌</h2></div>
		<table id="tbl" border=1></table>    
			<script id="temp" type="text/x-handlebars-template">      
  			<tr class="title">        
  				<td width=70>강좌번호</td>    
       			<td width=200>강좌이름</td>     
       			<td width=70>강의실</td>       
     			<td width=100>최대수강인원</td>        
    			<td width=70>강의시수</td>         
   				<td width=100>수강인원</td>  
				<td width=65>강좌정보</td>   
 			</tr>       
			{{#each cArray}}       
 				<tr class="row">       
    				<td class="lcode">{{lcode}}</td>   
        			<td class="lname">{{lname}}</td>    
        			<td class="room">{{room}}</td>        
    				<td class="capacity">{{capacity}}</td>          
  					<td class="hours">{{hours}}</td>    
					<td class="persons">{{persons}}</td>  
					<td><button>강좌정보</button></td>    
  				</tr>      
  			{{/each}}
		     </script>
		     <div id="divHeader"><h2>담당학생</h2></div>
		<table id="tbl2" border=1></table>    
			<script id="temp2" type="text/x-handlebars-template">      
  			<tr class="title">        
  				<td width=150>학생번호</td>    
       			<td width=150>학생이름</td>     
       			<td width=70>학생학과</td>       
     			<td width=100>학년</td>        
    			<td width=150>생년월일</td>         
				<td width=65>학생정보</td>   
 			</tr>       
			{{#each sArray}}       
 				<tr class="row">       
    				<td class="scode">{{scode}}</td>   
        			<td class="sname">{{sname}}</td>    
        			<td class="dept">{{dept}}</td>        
    				<td class="year">{{year}}</td>          
  					<td class="birthday">{{birthday}}</td>      
					<td><button>학생정보</button></td>    
  				</tr>      
  			{{/each}}
		     </script>
		<!---------------------여기에 내용출력 종료----------------------- -->
		</div>
		</div>
		<div id="divBottom"><jsp:include page="../footer.jsp"/></div>
	</div>
</body>
<script>

	var pcode="${vo.pcode}";
	var pname="${vo.pname}";
	
	$.ajax({           
		type:"get",       
		url:"/haksa/professors/cslist",       
		data:{"pcode":pcode},     
		dataType:"json",   
		success:function(data){             
			var template = Handlebars.compile($("#temp").html());        
			$("#tbl").html(template(data));
			
			var template = Handlebars.compile($("#temp2").html());        
			$("#tbl2").html(template(data));
		
	        }     
		}); 
	
	$("#tbl").on("click", ".row button", function(){
		var lcode=$(this).parent().parent().find(".lcode").html();
		location.href="/haksa/courses/read?lcode=" + lcode;
	});
	
	$("#tbl2").on("click", ".row button", function(){
		var scode=$(this).parent().parent().find(".scode").html();
		location.href="/haksa/students/read?scode=" + scode;
	});
	
	
	$("#btnDelete").on("click",function(){
		if(!confirm(pname + " 교수를 삭제하시겠습니까?")) return;
		$.ajax({
			type:"get",
			url:"delete",
			data:{"pcode":pcode},
			dataType:"json",
			success:function(data){
				if(data.scount==0 && data.ccount==0) {
					alert("삭제되었습니다.");
					location.href="list.jsp";
				} else {
					alert("지도학생 : " + data.scount+ " 담당과목 : " + data.ccount);
				}
			}
		});
	});

$(frm).submit(function(e){
	e.preventDefault();
	if(!confirm(pname + " 교수를 수정하시겠습니까?")) return;
	alert(pname+" 교수정보가 수정되었습니다.");
	frm.submit();
});

</script>
</html>




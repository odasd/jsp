<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


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
		<div id="divHeader"><h2>교수목록</h2></div>
		<div id="divCondition">
			<div id="divSearch">
				<select id="selKey">
					<option value="pcode">교수번호</option>
					<option value="pname">교수이름</option>
					<option value="dept">학과</option>
				</select>
				<input type="text" id="txtWord">
					<select id="selPerPage">               
						<option value="5" selected>선택하세요</option>  
						<option value="3">3행</option>       
					    <option value="5">5행</option>  
					    <option value="10">10행</option>   
					</select>
				 <input type="button" id="btnSearch" value="검색">            
				 <span style="font-size:12px;">검색수: <b id="count"></b>건</span> 
			</div>
			<div id="divSort">
				 <select id="selOrder">              
				   <option value="pcode">번호</option>            
				   <option value="pname">이름</option>            
				   <option value="dept">학과</option>          
			 	 </select>            
				  <select id="selDesc">          
				  	<option value="">오름차순</option>       
				    <option value="desc">내림차순</option>     
		          </select> 
			</div>
		</div>
		 <table id="tbl" border=1></table>    
		 <script id="temp" type="text/x-handlebars-template">      
  			<tr class="title">          
  				<td width=110>교수번호</td>    
       			<td width=130>교수이름</td>     
       			<td width=130>교수학과</td>       
     			<td width=130>교수직급</td>        
    			<td width=130>임용일자</td>         
   				<td width=95>급여</td>   
				<td width=65>교수정보</td>    
 			</tr>       
			{{#each array}}       
 				<tr class="row">       
    				<td class="pcode">{{pcode}}</td>   
        			<td class="pname">{{pname}}</td>    
        			<td class="dept">{{dept}}</td>        
    				<td class="ptitle">{{title}}</td>          
  					<td class="hiredate">{{hiredate}}</td>        
    				<td class="salary">{{salary}}</td>     
					<td><button>교수정보</button></td> 
  				</tr>      
  			{{/each}}
		     </script>
		      <div id="pagination">      
		         <button id="btnPre">◀</button>    
		         [<span id="curPage"></span>/<span id="totPage"></span>]  
		         <button id="btnNext">▶</button>   
		      </div> 
		<!---------------------여기에 내용출력 종료----------------------- -->
		</div>
		</div>
		<div id="divBottom"><jsp:include page="../footer.jsp"/></div>
	</div>
</body>
<script>
	var url="/haksa2/professors/list";
	
	
	$("#tbl").on("click", ".row button", function(){
		var pcode=$(this).parent().parent().find(".pcode").html();
		location.href="read?pcode=" + pcode;
	});
</script>
<script src="../home.js"></script>
</html>
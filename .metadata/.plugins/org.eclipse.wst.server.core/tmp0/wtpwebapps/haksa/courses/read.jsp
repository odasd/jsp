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
			<div id="divHeader"><h2>강좌정보</h2></div>
				<form name="frm" action="update" method="post">   
					<table>        
						<tr>            
							<td class="title">강좌번호</td>
							<td>
								<input type="text" size=10 name="lcode" value="${vo.lcode}" readonly>
							</td>    
							<td class="title" width=150>강의실</td>
							<td>
								<input type="text" size=5 name="room" value="${vo.room}">
							</td>           
							<td class="title" width=150>강의시수</td>
							<td>
								<input type="text" size=5 name="hours" value="${vo.hours}">
							</td>     
						</tr>     
						<tr>      
							<td class="title">강좌이름</td>
							<td colspan=3>
								<input type="text" size=60 name="lname" value="${vo.lname}">
							</td>            
							<td class="title">최대수강인원</td>
							<td>
								<input type="text" size=5 name="capacity" value="${vo.capacity}">
							</td>       
						</tr>      
						<tr>        
							<td width=90 class="title">담당교수</td>      
							<td width=400 colspan=3>          
								<input type="text" size=5 name="pcode" value="${vo.instructor}">         
								<input type="text" size=10 name="pname" value="${vo.pname}">      
							</td>         
							<td class="title">수강신청인원</td><td><input type="text" size=5 name="persons" value="${vo.persons}"></td>  
						</tr>  
					</table>   
					<div id="pagination">       
						<input type="submit" value="수정" id="btnInsert">   
						<input type="reset" value="취소"> 
						<input type="button" value="삭제" id="btnDelete">     
					</div> 
				</form>
				<div id="divHeader"><h2>성 적 입 력</h2></div>
				<div id="divCondition" style="width:740px;">
					 <button id="btnUpdate" style="margin-bottom:5px;">선택저장</button> 
					 <button onClick="location.href='/haksa/courses/list.jsp'">강좌목록</button>
				</div>
				<table id="tbl" border=1></table>    
			<script id="temp" type="text/x-handlebars-template">      
  			<tr class="title">      
				<td><input type="checkbox" id="chkAll">    
  				<td width=70>학생번호</td>    
       			<td width=140>학생이름</td>     
       			<td width=70>학과</td>       
     			<td width=100>지도교수</td>        
    			<td width=70>학년</td>         
   				<td width=100>수강신청일</td>  
				<td width=100>점수</td>   
 			</tr>       
			{{#each array}}       
 				<tr class="row">       
					<td><input type="checkbox" class="chk">
    				<td class="scode">{{scode}}</td>   
        			<td class="sname">{{sname}}</td>    
        			<td class="dept">{{dept}}</td>        
    				<td class="pname">{{pname}}</td>          
  					<td class="year">{{year}}</td>    
					<td class="edate">{{edate}}</td>      
    				<td>
						<input type="text" class="grade" value="{{grade}}"  maxlength="3" size=2 style="text-align:center;">&nbsp;
						<button>수정</button>
					</td>    
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
var lcode="${vo.lcode}";
var lname="${vo.lname}";

	
	getList();
	//점수 수정버튼을 클릭한 경우
	$("#tbl").on("click", ".row button", function(){
		var scode=$(this).parent().parent().find(".scode").html();
		var grade=$(this).parent().find(".grade").val();
		if(grade>100 || grade<0){
			alert(scode+ "의" +grade+ " 의 올바른 점수를 입력하세요.");
		} else{
		if(!confirm(scode + " 의 점수를 " + grade + "로 수정하시겠습니까?")) return;
		$.ajax({
			type:"post",
			url:"/haksa/enroll/update",
			data:{"scode":scode, "lcode":lcode, "grade":grade},
			success:function(){
				alert("점수가 수정되었습니다.");
				getList();
			}
		});
		}
	});
	//선택저장버튼을 클릭한경우
	$("#btnUpdate").on("click", function(){
		if(!confirm("선택한 학생들의 점수를 수정하시겠습니까?")) return;
		$("#tbl .row .chk:checked").each(function(){
			var row=$(this).parent().parent();
			var scode=row.find(".scode").html();
			var grade=row.find(".grade").val();
			if(grade>100 || grade<=0){
				alert(scode+ "의" +grade+ " 의 올바른 점수를 입력하세요.");
			} else {
			$.ajax({
				type:"post",
				url:"/haksa/enroll/update",
				data:{"scode":scode, "lcode":lcode, "grade":grade},
				success:function(){
					alert("점수가 수정되었습니다.");
					getList();
				}
			});
			}
		});
		
	});
	
	//전체 체크버튼을 눌렀을때
	$("#tbl").on("click", "#chkAll",function(){
		if($(this).is(":checked")) {
			$("#tbl .row .chk").each(function(){
				$(this).prop("checked", true);
			});
		} else {
			$("#tbl .row .chk").each(function(){
				$(this).prop("checked", false);
			});
		}
	});
	
	//각행의 체크버튼을 누른 경우3(전체선택버튼으로 만들기)
	/*
	 $("#tbl").on("click", "#chkAll", function(){
      if($(this).is(":checked")){
         $("#tbl .row .chk").each(function(){ 
            $(this).prop("checked",true);
            $("#tbl").on("click", ".row .chk", function(){
               if($(this).is(":checked")==false){
                  $("#tbl #chkAll").prop("checked", false);
               }
            });   
         });
      }else{
         $("#tbl .row .chk").each(function(){ 
            $(this).prop("checked",false); 
         });
      }
   });
	*/
	/*
	//각행의 체크버튼을 누른 경우2(눈물의 똥꼬쇼)
	$("#tbl").on("click", ".row .chk", function(){
		if($(this).is(":checked")==false) {
			$("#chkAll").prop("checked", false)
		} else {
			if((".chk")==true){
			$("#chkAll").prop("checked", true)
			}
		}
	});
	*/
	/*
	  //점수를 잘못 입력했을 때 alert출력 후 원래값으로 돌려놓기   
	  var preGrade;    
	$("#tbl").on("focus", ".row .grade", function(){       
		preGrade=$(this).val();   
		});  
	$("#tbl").on("change",".row .grade", function(e){     
		var row=$(this).parent().parent();   
		var grade=row.find(".grade").val();      
		if(grade<0 || grade>100){        
			alert("점수를 0~100 사이의 값을 입력하세요.");       
			$(this).val(preGrade);     
			$(this).focus();      
			}   
		});
	*/
	//각 행의 체크버튼을 클릭한 경우
	
	$("#tbl").on("click", ".row .chk", function(){
		var isChkAll=true;
		$("#tbl .row .chk").each(function(){
			if(!$(this).is(":checked")) isChkAll=false;
		});
		if(isChkAll) {
			 $("#tbl #chkAll").prop("checked", true);
		} else {
			 $("#tbl #chkAll").prop("checked", false);
		}
	});
	
	
	function getList(){
$.ajax({           
	type:"get",       
	url:"/haksa/es",       
	data:{"lcode":lcode},     
	dataType:"json",   
	success:function(data){             
		var template = Handlebars.compile($("#temp").html());        
		$("#tbl").html(template(data));
	
        }     
	}); 
}
	
	
	$("#btnDelete").on("click", function(){
		if(!confirm(lname + " 을(를) 삭제하시겠습니까?")) return;
		$.ajax({
			type:"get",
			url:"delete",
			data:{"lcode":lcode},
			dataType:"json",
			success:function(data) {
				if(data.count==0) {
					alert(lname+ " 이 삭제되었습니다.");
					location.href="list.jsp";
				} else {
					alert(data.count + "명이 수강중에있습니다. 삭제할수 없습니다.");
				}
			}
		})
	});
	
	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("강좌를 수정하시겠습니까?")) return;
		alert("강좌가 수정되었습니다.");
		frm.submit();		
});


	$(frm.pcode).on("click", function(){
		window.open("/haksa/professors/listAll.jsp", "advisor", "width=320, height=300, top=200, left=900");
	});
	

	$("#btnInsert").on("click", function(){
		
	});
</script>
</html>




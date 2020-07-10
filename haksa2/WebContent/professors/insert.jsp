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
		<div id="divHeader"><h2>교수등록</h2></div>
		<form name="frm" action="insert" method="post">    
			<table>      
				<tr>      
					<td width=100 class="title" width=150>교수번호</td> 
					<td width=100><input type="text" name="pcode" size=10 value="100"></td>    
					<td width=100 class="title" width=150>교수학과</td>    
					<td width=100>      
						<select name="dept">       
							<option selected>전산</option> 
							<option>전자</option>
							<option>건축</option>     
						</select>  
					</td>    
					<td width=100 class="title" width=150>임용일자</td>      
					<td>
						<input type="text" name="yy"  maxlength=4 size=2 value="1996">년
						<input type="text" name="mm"  maxlength=2 size=2 value="11">월
						<input type="text" name="dd"  maxlength=2 size=2 value="05">일
					</td>    
				</tr>      
				<tr>      
					<td width=100 class="title" width=150>교수이름</td>      
					<td width=100><input type="text" name="pname" size=5 value="홍길동"></td>
					<td width=100 class="title" width=150 >교수급여</td>     
					<td>
						<input type="text" name="salary"  size=9 value="1200000">원
					</td>       
					<td width=100 class="title" width=150>교수직급</td>      
					<td>
						<input type="radio" name="title" value="정교수" checked>정교수
						<input type="radio" name="title" value="부교수">부교수
						<input type="radio" name="title" value="조교수">조교수
					</td>   
				</tr> 
			</table>
			<div id="pagination">
				<input type="submit" value="저장">
				<input type="reset" value="취소">
			</div>
		</form>
		<!---------------------여기에 내용출력 종료----------------------- -->
		</div>
		</div>
		<div id="divBottom"><jsp:include page="../footer.jsp"/></div>
	</div>
</body>
<script>
	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("새로운 교수를 등록하시겠습니까?")) return;
		var pcode=$(frm.pcode).val();
		$.ajax({
			type:"get",
			url:"ck",
			data:{"pcode":pcode},
			dataType:"json",
			success:function(data){
				if(data.count==1) {
					alert("이미 사용한 코드입니다.");
				} else {
					frm.submit();
				}
			}
		});
	});
</script>
</html>


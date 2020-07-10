<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
   <title>24/7</title>
   <link rel="stylesheet" href="../home.css">
   <style>
      #divContent{height:300px;}
      #divContent table{margin-top:100px;}
   </style>
</head>
<body>
   <div id="divPage">
      <div id="divCenter">
         <div id="divMenu"><jsp:include page="../menu.jsp"/></div>
         <div id="divContent">
         <!--여기에 내용출력 시작---------------------------- -->
         <form name="frm" action="company_login" method="post">
	         <table>
	            <tr>
	               <td class="title" width=300 colspan=2>
	                  <h1>관리자 로그인</h1>
	               </td>
	            </tr>
	            <tr>
	               <td class="title" width=150>아이디</td>
	               <td><input type="text" name="company_id"></td>
	            </tr>
	            <tr>
	               <td class="title" width=150>비밀번호</td>
	               <td><input type="password" name="pass"></td>
	            </tr>
	            <tr>
	               <td colspan=2 style="text-align:center;height:40px;">
					<input type="submit" value="로그인">
	               </td>
	            </tr>            
	         </table>
         </form>
         <!--여기에 내용출력 종료---------------------------- -->
         </div>
      </div>
   </div>
</body>
<script>
	$(frm).submit(function(e){
		var company_id=$(frm.company_id).val();
		var pass=$(frm.pass).val();
		
		e.preventDefault();
		$.ajax({
			type:"post",
			url:"company_login",
			dataType:"json",
			data:{"company_id":company_id,"pass":pass},
			success:function(data){
				if(data.check==0){
					alert("id가 존재하지 않습니다!");
				}else if(data.check==1){
					alert("id와 비밀번호가 일치하지 않습니다!");
				}else{
					location.href="/semiProject/index.jsp";
				}
			}
		});
	});
</script>
</html>
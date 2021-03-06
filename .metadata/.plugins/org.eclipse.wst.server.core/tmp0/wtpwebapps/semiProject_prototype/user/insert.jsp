<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>24/7 TFS</title>
   <link rel="stylesheet" href="../home.css">
   <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
   <div id="page">
      <div id="center">

         <div id="content">
            <h2>점주 가입</h2>
            <form name="ufrm">
               <table width=500 border=1>
                  <tr class="row">
                     <td class="title">아이디</td>
                     <td><input type="text" name="cvs_id"></td>
                  </tr>
                  <tr class="row">
                     <td  class="title">비밀번호</td>
                     <td><input type="password" name="pass"></td>
                  </tr>
                  <tr class="row">
                     <td  class="title">이름</td>
                     <td><input type="text" name="name"></td>
                  </tr>
                  <tr class="row">
                     <td  class="title">이메일</td>
                     <td><input type="text" name="email"></td>
                  </tr>
                  <tr class="row">
                     <td  class="title">연락처</td>
                     <td><input type="text" name="tel"></td>
                  </tr>
               </table>
               <input type="submit" value="저장">
               <input type="reset" value="취소">
            </form>
         </div>
      </div>
      <div id="footer"><jsp:include page="../footer.jsp"></jsp:include></div>
   </div>
</body>
<script>
   $(ufrm).submit(function(e){
      e.preventDefault();
      if(!confirm("저장하시겠습니까?")) return;
      
      var cvs_id=$(ufrm.cvs_id).val();
      var pass=$(ufrm.pass).val();
      var name=$(ufrm.name).val();
      var email=$(ufrm.email).val();
      var tel=$(ufrm.tel).val();
      if(cvs_id=="" || pass=="" || email=="" || tel=="") {
         alert("모든 데이터를 입력하세요.");
      } else {
         $.ajax({
            type:"post",
            url:"/semiProject/user/cvs_insert",
            data:{"cvs_id":cvs_id, "pass":pass, "name":name, "email":email ,"tel":tel},
            dataType:"json",
            success:function(data){
               if(data.count==0) {
                  alert("등록 완료되었습니다.")
                  location.href="/semiProject/index.jsp";
               } else {
                  alert("이미 등록된 회원입니다.");
                  $(ufrm.cvs_id).focus();
               }
            }
         });
      }
         
         
   });
</script>
</html>
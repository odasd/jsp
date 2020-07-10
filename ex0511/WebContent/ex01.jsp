<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jsp와 서블릿 교육 start-->
<!-- 수업시작전 저장위치 변경, 서버 재설정, charset 설정 -->
<!-- 저장위치 변경은 이클립스 킬때 변경 가능, 서버는 하단 서버로가서 클릭하면 가능 
    charset은 window의 preferences에서 web에서 css html jsp file 전부 utf 8로 변경-->
<title>1부터 100까지의 합계</title>
<body>
<%//java 서버 명령어
   //1~100까지의 합
   int tot=0;
   for(int i=1;i<=100;i++){
      tot = tot+i;
   }
   //1~100까지 짝수의 합
   int etot=0;
   for(int i=2;i<=100;i+=2){
	   etot=etot+i;
   }
   //1~100까지 홀수의 합
   int otot=0;
   for(int i=1;i<100;i+=2){
	   otot=otot+i;
   }
%>
   <!-- 출력은 html에서 -->
   <h1>1~100까지의 합=<%out.print(tot);%></h1><!-- "out.print()"랑 "=" 는 같다 -->
   <h1>1~100까지의 짝수의 합=<%=etot%></h1>
   <h1>1~100까지의 홀수의 합=<%=otot%></h1>
</body>
</html>
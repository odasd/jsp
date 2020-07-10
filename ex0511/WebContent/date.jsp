<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.text.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>날짜와 시간</title>
</head>
<body>
	<%
		//GregorianCalendar now=new GregorianCalendar();
		//String date=String.format("%TF",now);
		//String titme=String.format("%TT",now);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy년MM월dd일");
		SimpleDateFormat sdf1=new SimpleDateFormat("hh시mm분ss초");
		//날짜를 내가 원하는 타입으로 바꾸어줌
		String date=sdf.format(now);
		String time=sdf1.format(now);
		//format안에는 date타입만 들어갈 수있고 format()메소드를 사용하면 String타입으로 바뀐다.
		
		double num=0.456;
		DecimalFormat df=new DecimalFormat("#,##0.0000");
		String strNum=df.format(num);
	%>
	<h1>오늘의 날짜:<%=date%></h1>
	<h1>오늘의 시간:<%=time%></h1>
	<h1>num:<%=strNum%></h1>
</body>
</html>
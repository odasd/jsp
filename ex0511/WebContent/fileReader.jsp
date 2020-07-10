<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>파일읽기</title>
</head>
<body>
<%
	BufferedReader reader=null;
	try{
		String filePath=application.getRealPath("/WEB-INF/input.txt");
		reader=new BufferedReader(new FileReader(filePath));	
		//filePath는 input.txt가 있는 위치
		//text파일읽을때 BufferedReader를 사용한다.
		while(true){
			String str=reader.readLine();
			if(str==null){
				break;
			}
			out.println("<h1>"+str+"</h1>");
		}
	}catch (Exception e){
		
	}
%>
</body>
</html>
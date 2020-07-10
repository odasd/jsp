<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="menuItem"><a href="/haksa2/index.jsp">Home</a></div> 


	<c:if test="${id!=null}">
		<div class="menuItem"><a href="/haksa2/professors/list.jsp">교수목록</a></div> 
		<div class="menuItem"><a href="/haksa2/professors/insert.jsp">교수등록</a></div> 
		<div class="menuItem"><a href="/haksa2/students/list.jsp">학생목록</a></div> 
		<div class="menuItem"><a href="/haksa2/students/insert.jsp">학생등록</a></div> 
		<div class="menuItem"><a href="/haksa2/courses/list.jsp">강좌목록</a></div> 
		<div class="menuItem"><a href="/haksa2/courses/insert.jsp">강좌등록</a></div>
		
		<div class="menulogin" Style="float:right;">
			<span style="font-size=12px;">안녕하세요! ${name}님</span>
			<a href="/haksa2/user/logout">로그아웃</a>
		</div>
	</c:if>
	
	<c:if test="${id==null}">
		<div class="menuItem"><a href="/haksa2/user/login.jsp">교수목록</a></div> 
		<div class="menuItem"><a href="/haksa2/user/login.jsp">교수등록</a></div> 
		<div class="menuItem"><a href="/haksa2/user/login.jsp">학생목록</a></div> 
		<div class="menuItem"><a href="/haksa2/user/login.jsp">학생등록</a></div> 
		<div class="menuItem"><a href="/haksa2/user/login.jsp">강좌목록</a></div> 
		<div class="menuItem"><a href="/haksa2/user/login.jsp">강좌등록</a></div>
		
		<div class="menulogin" Style="float:right;">
			<a href="/haksa2/user/login.jsp">로그인</a>
		</div>
	</c:if>	
	
	
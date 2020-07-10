<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#menu {background:gray; color:white;
		   padding:10px;
		   width:680px; overflow:hidden;}
	a {text-decoration:none; color:white;padding:5px;}	
	.item{width:100px; float:left;} 
	a:hover{background:black;}
	.login{float:right;}
</style>    
<div id="menu">   
	<div class="item"><a href="/pro/list">교수관리</a></div>
	<div class="item"><a href="/stu/list">학생관리</a></div>
	<div class="item"><a href="/cou/list">강좌관리</a></div>
	<div class="login"><a href="">로그인</a></div>
</div> 
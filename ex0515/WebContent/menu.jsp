<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	#menu{background:gray; color:white; width:780px; padding:10px; overflow:hidden; margin:auto;}
	#menu a{text-decoration:none; color:white;}
	#menu a:hover{background:black; padding:5px;}
	.item{float:left; width:100px; margin:1px;}
	.login{float:right;}
	#page{width:1000px; margin:auto; background:#FFFFCC; border:5px solid black; border-radius:10px; box-shadow:10px 10px 10px black; padding-top:100px; padding-bottom:100px; margin-top:100px; margin-bottom:100px;}
	#id{margin:auto; text-align:center; float:center;}
	#tbl, #ctbl, #stbl, #tbl2, #srtbl, #tbl3{margin:auto;}
	h1{text-align:center;}
	#tt{padding-left:160px;}
	#but{margin:auto; text-align:center; float:center; padding:20px;}
	#apply{padding-left:160px;}
	body{background:#339966;}
	.info{float:center;}
</style>

<div id="menu">
	<c:if test="${id == null}">
		<div class="item"><a href="/login">교수관리</a></div>
		<div class="item"><a href="/login">학생관리</a></div>
		<div class="item"><a href="/login">강좌관리</a></div>
		<div class="login"><a href="/login">로그인</a></div>
	</c:if>
	
	<c:if test="${id != null}">
		<div class="item"><a href="/pro/list">교수관리</a></div>
		<div class="item"><a href="/stu/list">학생관리</a></div>
		<div class="item"><a href="/cou/list">강좌관리</a></div>
		<div class="login"><a href="/logout">로그아웃</a></div>
		<div class="info">안녕하세요!  ${name} 님</div>
	</c:if>
</div>
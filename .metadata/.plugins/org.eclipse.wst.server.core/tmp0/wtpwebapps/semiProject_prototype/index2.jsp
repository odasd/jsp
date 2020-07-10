<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>24/7 TFS</title>
<link rel="stylesheet" href="home.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<div id="divPage">
		<div id="divCenter">
		<c:if test="${id!=null}">
			<div id="divTop"><jsp:include page="top2.jsp" /></div>
			<div class="dropmenu">
				<ul id="dm_ul">
					<li><a id=plist href="../product/list.jsp">상품리스트</a></li>&nbsp;&nbsp;&nbsp;
					
					<li>현황관리
						<ul>
							<li><a class=alist href="../stock/list.jsp">재고현황</a></li>
							<li><a class=alist href="../sell_status/list.jsp">판매현황</a></li>
							<li><a class=alist href="../order/list.jsp">발주현황</a></li>
						</ul>
					</li>&nbsp;&nbsp;&nbsp;
					<li>등록관리
						<ul>
							<li><a class=alist href="../order/insert.jsp">발주등록</a></li>
							<li><a class=alist href="../product/insert.jsp">상품등록</a></li>
						</ul>
					</li>&nbsp;&nbsp;&nbsp;
					<li>이건어때
						<ul>
							<li><a class=alist href="../bbs/insert.jsp">칭찬해요</a></li>
							<li><a class=alist href="../bbs/binsert.jsp">제안해요</a></li>
						</ul>
					</li>
					</ul>
					</div>
					<img id="logo" src=../images/tfs_logo.JPG>
					</c:if>
			<div id="main">
				
				<div id="divContent" style="width: 100%; margin: auto">

					<!--여기에 내용출력 시작---------------------------- -->
					<div id="content">
						<div id="banners">
							<div id="slide" style="float: left; margin-left: 71px;">
								<input type="radio" name="pos" id="pos1" checked> <input
									type="radio" name="pos" id="pos2"> <input type="radio"
									name="pos" id="pos3"> <input type="radio" name="pos"
									id="pos4">
								<ul>
									<li><img class=banners src=../images/mainbanner.jpg></li>
									<li><img class=banners src=../images/night.jpg></li>
									<li><img class=banners src=../images/fresh.jpg></li>
									<li><img class=banners src=../images/yagan.jpg></li>
								</ul>
								<p class="pos">
									<label for="pos1"></label> <label for="pos2"></label> <label
										for="pos3"></label> <label for="pos4"></label>
								</p>
							</div>
							<img id="sideBanner" style="float: left; position: relative;"
								src=../images/sideBanner.jpg>
						</div>
					</div>
					<div id="bannerDiv">
						<table id="midMenu">
							<tr>
								<td><a class=aTag href="">공지사항</a></td>
								<td><a class=aTag href="">사회공헌</a></td>
								<td><a class=aTag href="">보도자료</a></td>
								<td><a class=aTag href="">이벤트</a></td>
								<td style="width: 55%"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div id="container">
				<img id="leftBro" src=../images/leftbro.jpg><img id="rightSis"
					src=../images/rightsis.jpg>
				<table id="menuContainer">
					<tr style="height: 70px">
						<td id=menu1><a href="/semiProject/user/company_login.jsp"><img src=../images/login1.jpg></a></td>
						<td id=menu2><a href="/semiProject/user/cvs_login.jsp"><img src=../images/login2.jpg></a></td>
						<td id=menu3><a href=""><img src=../images/ceosay.jpg></a></td>
						<td id=menu4><a href=""><img src=../images/newdel.jpg></a></td>
					</tr>
					<tr style="height: 180px">
						<td id=menu1-1><img src=../images/log1.jpg></td>
						<td id=menu1-2><img src=../images/log2.jpg></td>
						<td id=menu1-3><img style="margin-bottom: 130px;"
							src=../images/ceo.jpg><img style="margin-left: 22px;"
							src=../images/button.jpg></td>
						<td id=menu1-4><img style="margin-bottom: 130px;"
							src=../images/del.jpg><img style="margin-left: 22px;"
							src=../images/button.jpg></td>
					</tr>
				</table>
			</div>
			<!--여기까지가 내용입니다.---------------------------- -->
			<div id="divFoot" style="text-align: center;"><jsp:include page="footer.jsp" /></div>
		</div>
	</div>
</body>
<script>
	$(".dropmenu ul li").hover(function(){
		$(this).find("ul").stop().fadeToggle(300);
	})
</script>
</html>
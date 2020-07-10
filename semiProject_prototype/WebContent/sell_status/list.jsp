<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>상품</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<link rel="stylesheet" href="../home.css" />
</head>
<body>
	<div id="divPage">
		<div id="divTop"><jsp:include page="../top.jsp" /></div>
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
		<div id="divMenu"></div>
		<div id="divHeader">
			<h2>판 매 현 황</h2>
		</div>
		<div id="divCondition">
			<div id="divSearch">
				<select id="selKey">
					<option value="cvs_code">판매코드</option>
					<option value="product_code">상품코드</option>


				</select> <input type="text" id="txtWord"> <select id="selPerpage">
					<option value="3">3행</option>
					<option value="5">5행</option>
					<option value="10">10행</option>
				</select> <input type="button" id="btnSearch" value="검색"> <span
					style="font-size: 12px;">검색수: <b id="count"></b>건
				
				</span>
				<div id="divSort">
					<select id="selOrder">
						<option value="cvs_code">판매코드</option>
						<option value="product_code">상품코드</option>

					</select> <select id="selDesc">
						<option value="">오름차순</option>
						<option value="desc">내림차순</option>
					</select>
				</div>
			</div>

		</div>
		<table id="tbl"></table>
		<script id="temp" type="text/x-handlebars-template">  
           <tr class="title">          
          	<td width=130>재고</td>    
           	<td width=130>편의점코드</td>
			<td width=130>상품_코드</td> 
			<td width=130>카테고리_코드</td> 
          </tr>       
         {{#each array}}       
          <tr class="row">       
             <td class="stock">{{stock}}</td>   
             <td class="cvs_code">{{cvs_code}}</td>
			 <td class="product_code">{{product_code}}</td>   
			 <td class="category_code">{{category_code}}</td>     
           </tr>      
           {{/each}}
		</script>
		<div id="pagination">

			<button id="btnPre">◀</button>
			<button id="btnNext">▶</button>
			<div>
				[<span id="curPage"></span>/<span id="totPage"></span>]
			</div>

		</div>
		<div id="divFoot" style="text-align: center"><jsp:include
				page="../footer.jsp" /></div>
	</div>
</body>
<script>
	var url = "/Sell_Status/list";
</script>
<script src="../home.js"></script>
</html>
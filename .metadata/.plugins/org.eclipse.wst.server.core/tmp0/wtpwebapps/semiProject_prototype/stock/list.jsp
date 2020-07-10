<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>재고</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<link rel="stylesheet" href="../home.css" />
</head>
<body>
   <div id="divPage" style="background:#F2F2F2;">
   <div id="divTop"><jsp:include page="../top.jsp" /></div>
   <div class="dropmenu">
				<ul id="dm_ul" style="background:#F2F2F2">
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
         <h2>재 고 현 황</h2>
      </div>
      <div id="divCondition">
         
      </div>
       <table id="tbl"></table>    
         <script id="temp" type="text/x-handlebars-template">  
           <tr class="title">          
          	<td width=100>StoreNumber</td>    
			<td width=100>CategoryCode</td>
			<td width=100>상품코드</td>
			<td width=250>상품명</td>
			<td width=100>제조일자</td>
			<td width=100>유통기한</td>
			<td width=100>수량</td>
	
          </tr>       
         {{#each array}}       
          <tr class="row">       
             <td class="cvs_code">{{cvs_code}}</td>   
 
			 <td class="category_code">{{category_code}}</td>
			 <td class="cvs_code">{{product_code}}</td>     
			 <td class="cvs_code">{{product_name}}</td>
			 <td class="cvs_code">{{product_date}}</td>	
			 <td class="cvs_code">{{product_exp}}</td>
			 <td class="cvs_code">{{stock}}</td>
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
		   <div id="divFoot" style="text-align: center"><jsp:include page="../footer.jsp" /></div>   
   </div>
</body>
<script>
var url="/stock/list";

$(".dropmenu ul li").hover(function(){
	$(this).find("ul").stop().fadeToggle(300);
})
</script>
<script src="../home.js"></script>
</html>
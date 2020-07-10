<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>상품</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<link rel="stylesheet" href="../home.css" />
</head>
<body>
	<div id="divPage">
	<div id="divTop"><jsp:include page="../top.jsp" /></div>
      <div id="divMenu"></div>
      <div id="divHeader">
         <h2>상 품 목 록</h2>
      </div>
      <div id="divCondition">
         <div id="divSearch">
            <select id="selKey">
               <option value="product_code">상품코드</option>
               <option value="product_name">상품명</option>
               <option value="company">제조사</option>

            </select> <input type="text" id="txtWord"> <select id="selPerpage">
               <option value="3">3행</option>
               <option value="5">5행</option>
               <option value="10">10행</option>
            </select> <input type="button" id="btnSearch" value="검색"> <span
               style="font-size: 12px;">검색수: <b id="count"></b>건
            </span>
         <div id="divSort">
            <select id="selOrder">
               <option value="product_code">상품코드</option>
               <option value="product_name">상품명</option>
               <option value="company">제조사</option>
            </select> <select id="selDesc">
               <option value="">오름차순</option>
               <option value="desc">내림차순</option>
            </select>
         </div>
         </div>
         
      </div>
      <div id="tbl"></div>
            <script id="temp" type="text/x-handlebars-template">
         {{#each array}}
            <div class="box">
               <div class="image"><img src="{{printImage img}}" width=300></div>
               <div class="product_name">{{product_name}}</div>
               <div class="product_price">{{product_price}}</div>
            </div>
            {{/each}}
            </script>   
      <div id="pagination">
         <button id="btnPre">◀</button>
         <button id="btnNext">▶</button>
         [<span id="curPage"></span>/<span id="totPage"></span>]
      </div>
      <div id="divFoot" style="text-align: center"><jsp:include page="../footer.jsp" /></div>
   </div>         
	</div>
</body>
<script>
	var url = "/product/list";
	   
	   //핸들바에서의 이미지 조건문
	      Handlebars.registerHelper("printImage",function(img){
	         var src;
	         if(img==null) src="http://placehold.it/300x200";   
	         else src="/img/product/"+img;
	         return src;
	      });
	      /*
	      //핸들바에서의 prod_del 조건문
	      Handlebars.registerHelper("printDel",function(del){
	         var src;
	         if(del==1) src="판매중지";   
	         else src="🛒";   
	         return src;
	      });
	      */
</script>
<script src="../home.js"></script>
</html>
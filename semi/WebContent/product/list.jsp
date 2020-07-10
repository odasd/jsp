<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>상품</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
   <div id="divPage">
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
               
            </select> <input type="text" id="txtWord">
            <select id="selPerpage">
               <option value="3">3행</option>
               <option value="5">5행</option>
               <option value="10">10행</option>
            </select> <input type="button" id="btnSearch" value="검색"> <span
               style="font-size: 12px;">검색수: <b id="count"></b>건
            </span>
         </div>
         <div id="divSort">
            <select id="selOrder">
               <option value="product_code">상품코드</option>
               <option value="product_name">상품명</option>
               <option value="company">제조사</option>
            </select>
            <select id="selDesc">
               <option value="">오름차순</option>
               <option value="desc">내림차순</option>
            </select>
         </div>
      </div>
       <table id="tbl"></table>    
         <script id="temp" type="text/x-handlebars-template">  
          <tr class="title"> 
			<td><input type="checkbox" id="chkAll"></td>
			<td>상품코드</td>     
			<td width=130>카테고리</td>      
            <td width=130>상품명</td> 
            <td width=130>가격:</td>
			<td width=130>제조사</td>
			<td width=130>제조일</td>
			<td width=130>폐기일</td>
			<td width=130>이미지</td>
		  	<td>버튼</td>
          </tr>       
         {{#each array}}       
          <tr class="row">
			<td><input type="checkbox" class="chk"></td>
			<td class="product_code">{{category_code}}{{product_code}}</td>
			<td class="category_name">{{category_name}}</td>                
            <td class="product_name">{{product_name}}</td>   
            <td class="product_price">{{product_price}}</td> 
 			<td class="company">{{company}}</td> 
 			<td class="product_date">{{product_date}}</td> 
 			<td class="product_exp">{{product_exp}}</td>  
			<td class="img"><img src=/img/product/{{img}} width=50></td>  
			<td><button>발주하기</button></td>  
           </tr>      
           {{/each}}
      </script>
      		<input type="button" id="btnSelect" value="선택발주">
            <div id="pagination">
         <button id="btnPre">◀</button>
         <button id="btnNext">▶</button>
         [<span id="curPage"></span>/<span id="totPage"></span>]
      </div>
   </div>
</body>

<script>
	var url="/semi/product/list";
	
	//선택발주 버튼을 눌렀을때
	$("#btnSelect").on("click", function(){
		if(!confirm("발주하시겠습니까?")) return;
		if($("#tbl .row .chk:checked").length > 0) {
			$("#tbl .row .chk:checked").each(function(){
				var row=$(this).parent().parent();
				var category_code=row.find(".product_code").html().substring(0,1);
				var product_code=row.find(".product_code").html().substring(1);
				var category_name=row.find(".category_name").html();
				var product_name=row.find(".product_name").html();
				var product_price=row.find(".product_price").html();
				var company=row.find(".company").html()
				$.ajax({
					type:"post",
					url:"/semi/cart/insert",
					data:{"category_code":category_code, "product_code":product_code, "product_name":product_name,
						"product_price":product_price, "company":company, "category_name":category_name},
					success:function(){
						alert("발주되었습니다.");
					}
				});
			});
		} else {
			alert("unable");
		}
	});
	
	//발주버튼 눌렀을떄
	$("#tbl").on("click",".row button",function(){
		if(!confirm("발주ㄱ?")) return;
		var row=$(this).parent().parent();
		var category_code=row.find(".product_code").html().substring(0,1);
		var product_code=row.find(".product_code").html().substring(1);
		var category_name=row.find(".category_name").html();
		var product_name=row.find(".product_name").html();
		var product_price=row.find(".product_price").html();
		var company=row.find(".company").html()
		$.ajax({
			type:"post",
			url:"/semi/cart/insert",
			data:{"category_code":category_code, "product_code":product_code, "product_name":product_name,
				"product_price":product_price, "company":company, "category_name":category_name},
			success:function(){
				alert("발주되었습니다.");
			}
		});
	});
	
	//전체체크버튼을 눌렀을때
	$("#tbl").on("click", "#chkAll", function() {
		if ($(this).is(":checked")) {
			$("#tbl .row .chk").each(function() {
				$(this).prop("checked", true);
			});
		} else {
			$("#tbl .row .chk").each(function() {
				$(this).prop("checked", false);
			});
		}
	});

	//각행의 체크버튼을 클릭한 경우
	$("#tbl").on("click", ".row .chk", function() {
		var isChkAll = true;
		$("#tbl .row .chk").each(function() {
			if (!$(this).is(":checked"))
				isChkAll = false;
		});

		if (isChkAll) {
			$("#tbl #chkAll").prop("checked", true);
		} else {
			$("#tbl #chkAll").prop("checked", false);
		}
	});
</script>
<script src="../home.js"></script>
</html>
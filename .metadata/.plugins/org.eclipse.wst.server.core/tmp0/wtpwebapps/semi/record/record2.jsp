<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>히히호호</title>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
   <div id="divPage">
      <div id="divMenu"></div>
      <div id="divHeader">
         <h2>상 품 목 록</h2>
      </div>
       <h2>1월 인기상품</h2>
       <table id="tbl1" border=1></table>    
         <script id="temp1" type="text/x-handlebars-template">  
          <tr class="title">   
			<td width=130>이미지</td> 
            <td width=130>상품명</td> 
            <td width=130>판매수량</td>
          </tr>       
         {{#each array}}       
          <tr class="row">
			<td><img src="{{printImage image}}"></td>
			<td class="product">{{product_name}}</td>                
            <td class="quantity">{{sold_quantity}}</td>    
           </tr>      
           {{/each}}
      </script>
       <h2>2월 인기상품</h2>
      <table id="tbl2" border=1></table>    
         <script id="temp2" type="text/x-handlebars-template">  
          <tr class="title">    
			<td width=130>이미지</td>
            <td width=130>상품명</td> 
            <td width=130>판매수량</td>
          </tr>       
         {{#each array}}       
          <tr class="row">
			<td><img src="{{printImage image}}"></td>
			<td class="product">{{product_name}}</td>                
            <td class="quantity">{{sold_quantity}}</td>    
           </tr>      
           {{/each}}
      </script>
      
      <h2>3월 인기상품</h2>
      <table id="tbl3" border=1></table>    
         <script id="temp3" type="text/x-handlebars-template">  
          <tr class="title">    
			<td width=130>이미지</td>
            <td width=130>상품명</td> 
            <td width=130>판매수량</td>
          </tr>       
         {{#each array}}       
          <tr class="row">
			<td><img src="{{printImage image}}"></td>
			<td class="product">{{product_name}}</td>                
            <td class="quantity">{{sold_quantity}}</td>    
           </tr>      
           {{/each}}
      </script>
   </div>
</body>
<script>
	var selMonth;
	
	getList(1);
	getList(2);
	getList(3);
	
	
	function getList(selMonth){     
	
    $.ajax({           
       type:"get",       
       url:"/semi/record/topTen",    
       data:{"selMonth":selMonth},     
       dataType:"json",   
       success:function(data){  
     	  
          var template = Handlebars.compile($("#temp"+selMonth).html());        
          $("#tbl"+selMonth).html(template(data));
       }
       }); 
    } 
	
	 Handlebars.registerHelper("printImage", function(image){         
		 var src;      
		 if(!image) src="http://placehold.it/100x60"; else src="/img/product/" + image; return src;  
		 });
</script>
</html>
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
      <div id="divCondition">        
         <select id="selMonth">
               <option value="1">1월</option>
               <option value="2">2월</option>
               <option value="3">3월</option>
               <option value="4">4월</option>
               <option value="5">5월</option>
               <option value="6">6월</option>
               <option value="7">7월</option>
               <option value="8">8월</option>
               <option value="9">9월</option>
               <option value="10">10월</option>
               <option value="11">11월</option>
               <option value="12">12월</option>
            </select> 
            <input type="button" id="btnSearch" value="검색">
      </div>
       <table id="tbl" border=1></table>    
         <script id="temp" type="text/x-handlebars-template">  
          <tr class="title"> 
			<td>이미지</td>   
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
	getList();
	
	$("#btnSearch").on("click", function(){
	       page=1; getList(); 
	       });   
	
	function getList(){      
		selMonth=$("#selMonth").val();    
		
    $.ajax({           
       type:"get",       
       url:"/semi/record/topTen",    
       data:{"selMonth":selMonth},     
       dataType:"json",   
       success:function(data){  
     	  
          var template = Handlebars.compile($("#temp").html());        
          $("#tbl").html(template(data));
       }
       }); 
    } 
</script>
</html>
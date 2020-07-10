var page=1, display, query, total, totpage;
	
	
	getList();
	
	$("#btnNext").click(function() {
		page++;
		getList();
	});
	$("#btnPre").click(function() {
		page--;
		getList();
	});

	
	
	$("#display, #query").change(function(){
		page=1;
		getList();
	});
	/*
	$("#display, #query").on("change",function(){
		page=1;
		getList();
	});
	*/
	
	$("#query").keydown(function(key) {
		  if(key.keycode==13) {
			  page=1;
			  getList();
			  }
		  });
	
	
	$("#btnSearch").on("click", function(){
		page=1;
		getList();
	});

	 function getList(){
	      query=$("#query").val();
	      display=$("#display").val();
	      var start=(page-1)*display + 1;
	      
	      $.ajax({
	         type:"get",
	         url:url,
	         data:{"query":query,"display":display,"start":start},
	         dataType:"json",
	         success:function(data){
	            var template = Handlebars.compile($("#temp").html());
	             $("#tbl").html(template(data));
	             
	             total=data.total;
	             if(total%display==0){
	                totPage=total/display;
	             }else{
	                totPage=parseInt(total/display)+1;
	             }
	             
	             if (page == 1)
	 				$("#btnPre").attr("disabled", true);// 현재 페이지가 1페이지인 경우
	 			else
	 				$("#btnPre").attr("disabled", false);
	 			if (page == totPage) // 현재 페이지가 마지막 페이지인 경우
	 				$("#btnNext").attr("disabled", true);
	 			else
	 				$("#btnNext").attr("disabled", false);
	             
	             $("#curPage").html(page);
	             $("#totPage").html(totPage);
	             $("#total").html(total);
	         }
	      });
	   }
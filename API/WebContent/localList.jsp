<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>장소 검색</title>
	<link rel="stylesheet" href="home.css">
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2d06e7f6c04a5b6cff4d94cebfef1694"></script>
</head>
<body>
<div id="divPage">
	<div id="divMenu"><jsp:include page="menu.jsp" /></div>
	<div id="divHeader">
			<h2>장소 검색</h2>
		</div>
	<div id="divCondition">
		<input type="text" id="query" value="자바">
		<input type="button" value="검색" id="btnSearch">
		<select id="size">
			<option value="5">5행</option>
			<option value="10">10행</option>
			<option value="15">15행</option>
		</select>
		<span id="total"></span>건
		<table id="tbl" border=1></table>
		<script id="temp" type="text/x-handlebars-template"> 
			<tr class="title">
				<td width=200>장소이름</td>	
				<td width=300>도로명주소</td>
				<td width=130>전화번호</td>
				<td	width=70>지도보기</td>
			</tr>
			{{#each documents}}
			<tr class="row">
				<td><a href="{{place_url}}">{{place_name}}</a></td>
				<td>{{road_address_name}}</td>
				<td>{{phone}}</td>
				<td><button x="{{x}}" y="{{y}}" place="{{place_name}}" phone="{{phone}}" address="{{road_address_name}}">지도보기</button></td>
			</tr>
			{{/each}}
		</script>
		
	</div>
	<div id="pagination">
		<button id="btnPre">◀</button>
		<button id="btnNext">▶</button>
		[<span id="curPage"></span>/<span id="totPage"></span>]
	</div>
	<div id="map" style="width:800px;height:400px;float:center;margin:auto;"></div><br>
	<div id="btnClose" style="float:center;margin:auto;text-align:center;"><input type="button" value="지도끄기" id="button"></div>
	
	
</div>
</body>

<script>

	var page=1, size, query, total, totpage,x,y;

	$("#map").hide();
	$("#btnClose").hide();
	getList();
	
	$("#btnClose #button").on("click", function(){
		$("#map").hide();
		$("#btnClose").hide();
	});
	
	$("#tbl").on("click", ".row button", function(){
		x=$(this).attr("x");
		y=$(this).attr("y");
		var place=$(this).attr("place");
		var phone=$(this).attr("phone");
		var address=$(this).attr("address");
		
		
		$("#map").show();
		$("#btnClose").show();
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(y, x),
			level: 3
		};
		var marker=new kakao.maps.Marker({position:new kakao.maps.LatLng(y,x)});
		var map = new kakao.maps.Map(container, options);
		marker.setMap(map);
		
		var str="<div style='background:white; color:black; box-shadow:10px 10px 10px black;border:5px solid black; border-radius:5px;'>" + place + "<br>" + phone + "<br>"+ address +"</div>";
	       var info=new kakao.maps.InfoWindow({content:str});
	       kakao.maps.event.addListener(marker, "mouseover", function(){ info.open(map, marker); });
	       kakao.maps.event.addListener(marker, "mouseout", function(){ info.close(map, marker); });      
		
	});
	
	$("#btnNext").click(function() {
		page++;
		getList();
	});
	$("#btnPre").click(function() {
		page--;
		getList();
	});

	
	
	$("#size, #query").change(function(){
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
		size=$("#size").val();
		
	$.ajax({
		type:"get",
		url:"https://dapi.kakao.com/v2/local/search/keyword.json",
		headers:{"Authorization":"KakaoAK 2d06e7f6c04a5b6cff4d94cebfef1694"},
		dataType:"json",
		data:{"query": query, "page": page, "size":size},
		success:function(data){
			var template = Handlebars.compile($("#temp").html());
            $("#tbl").html(template(data));
            
            total=data.meta.pageable_count;
            if(total%size==0){
               totPage=total/size;
            }else{
               totPage=parseInt(total/size)+1;
            }
            
            if (page == 1)
				$("#btnPre").attr("disabled", true);// 현재 페이지가 1페이지인 경우
			else
				$("#btnPre").attr("disabled", false);
			if (data.meta.is_end) // 현재 페이지가 마지막 페이지인 경우
				$("#btnNext").attr("disabled", true);
			else
				$("#btnNext").attr("disabled", false);
			
            total=data.meta.pageable_count;
            $("#curPage").html(page);
            $("#totPage").html(totPage);
            $("#total").html(total);
		}
	});
}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>
<link rel="stylesheet" href="../home.css">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<div id="divPage">
		<div id="divMenu"><jsp:include page="../menu.jsp" /></div>
		<div id="divHeader">
			<h2>상 품 정 보</h2>
		</div>
		<form name="frm" action="update" method="post"
			enctype="multipart/form-data">
			<!-- 이미지를 저장할수있게해주는거 -->
			<table id="tbl">
				<tr>
					<td class="title" width=100>상품코드</td>
					<td width=100><input type="text" name="prod_id" size=10
						value="${vo.prod_id}"></td>
					<td class="title" width=100>제조원/수입원</td>
					<td width=200><input type="text" name="company" size=27
						value="${vo.company}"></td>
					<td class="title" width=100>판매가격</td>
					<td width=100><input type="text" name="price1" size=10
						value="${vo.price1}"></td>
				</tr>
				<tr>
					<td class="title">업체코드</td>
					<td colspan=3><input type="text" name="mall_id" size=10
						value="${vo.mall_id}"><input type="text" name="mall_name"
						size=47 value="${vo.mall_name}"></td>
					<td class="title">일반가격</td>
					<td><input type="text" name="price2" size=10
						value="${vo.price2}"></td>
				</tr>
				<tr>
					<td class="title">상품이름</td>
					<td colspan=3><input type="text" name="prod_name" size=60 value="${vo.prod_name}"></td>
					<td class="title">판매상태</td>
					<td colspan=2><input type="checkbox" name="prod_del" value=1 <c:out value="${vo.prod_del=='1'?'checked':''}"/>>판매중지</td>
				</tr>
				<tr>
					<td class="title">상품이미지</td>
					<td colspan=5>
						<c:if test="${vo.image==null}">
							<img src="http://placehold.it/150x120" id="image" width=150 />
						</c:if> 
						<c:if test="${vo.image!=null}">
							<img src="/img/product/${vo.image}" id="image" width=150 />
						</c:if> 
						<input type="file" name="image" accept="image/*" style="visibility: hidden;"></td>
				</tr>
				<tr>
					<td class="title">상품설명</td>
					<td colspan=5><textarea rows="10" cols="100" name="detail">${vo.detail}</textarea></td>
				</tr>
			</table>
			<div id="pagination">
				<input type="submit" value="수정"> 
				<input type="reset" value="취소">
				<input type="button" id="btnDelete" value="삭제">
			</div>
		</form>
	</div>
</body>
<script>

	var prod_id="${vo.prod_id}";
	
	//삭제버튼을 눌렀을때
	$("#btnDelete").on("click", function(){
		if(!confirm("상품을 삭제하시겠습니까?")) return;
		$.ajax({
			type:"get",
			url:"delete",
			data:{"prod_id":prod_id},
			dataType:"json",
			success:function(data){
				if(data.count==0) {
					alert("삭제되었습니다.");
					location.href="list.jsp";
				} else {
					alert("주문한 상품이므로 삭제할수 없습니다.");
				}
			}
		});
	});

	//수정버튼을 눌렀을때
	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("수정하시겠습니까?")) return;
		frm.submit();
	});
	
	//판매중지 버튼을 눌렀을때
	$(frm.prod_del).on("click", function(){
		if($(frm.prod_del).is(":checked")) {
			alert("판매를 중지합니다.");
		} else {
			alert("판매중지를 해제합니다.");
		}
	});
	
	//업로드일 이미지 불러오기
	$("#image").on("click", function() {
		$(frm.image).click();
	});

	//불러오기한 이미지가 변경되었을때
	$(frm.image).on("change", function() {
		var reader = new FileReader();
		reader.onload = function(e) {
			$("#image").attr("src", e.target.result);
		}
		reader.readAsDataURL(this.files[0]);
	});
	//업체목록 불러오기
	$(frm.mall_id).click(
			function() {
				window.open('/shop/mall/listAll.jsp', 'mall',
						'width=400,height=300,top=200,left=900');
			});

	/*
	//상품코드 불러오기
	$.ajax({
		type:"get",
		url:"id",
		dataType:"json",
		success:function(data){
			$(frm.prod_id).val(data.id);
		}
	});
	 */
</script>
</html>
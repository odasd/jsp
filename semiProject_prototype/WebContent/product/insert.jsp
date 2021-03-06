<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품등록</title>
	<link rel="stylesheet" href="../home.css">
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<div id="divPage">
	<div id="divTop"><jsp:include page="../top.jsp" /></div>
		<div id="divHeader">
			<h2>상 품 등 록</h2>
		</div>
		<form name="frm" action="insert" method="post" enctype="multipart/form-data"> <!-- enctype="multipart/form-data" 이미지를 저장할수있게해주는거 -->
			<table id="tbl">
				<tr>
					<td class="title" width=100>상품코드</td>
					<td width=100><input type="text" name="product_code" size=10></td>
					<td class="title" width=100>제조원/수입원</td>
					<td width=200><input type="text" name="company" size=27></td>
					<td class="title" width=100>판매가격</td>
					<td width=100><input type="text" name="product_price" size=10></td>
				</tr>
				<tr>
					<td class="title">제조일</td>
					<td><input type="date" name="product_date" size=10></td>
					<td class="title">폐기일</td>
					<td><input type="date" name="product_exp" size=10></td>
					<td class="title">판매가능</td>
					<td><input type="text" name="prod_del" size=10></td>
				</tr>
				<tr>
					<td class="title">상품이름</td>
					<td colspan=5><input type="text" name="product_name" size=99></td>
				</tr>
				<tr>
					<td class="title">상품이미지</td>
					<td colspan=5>
						<img src="http://placehold.it/150x120" id="image" width=150 />
						 <input type="file" name="image" accept="image/*" style="visibility: hidden;">
					</td>
				</tr>
				<tr>
					<td class="title">카테고리</td>
					<td colspan=5><textarea rows="10" cols="100" name="category_code"></textarea></td>
				</tr>
			</table>
			<div id="pagination">
				<input type="submit" value="저장"> <input type="reset" value="취소">
			<div id="divFoot" style="text-align: center"><jsp:include page="../footer.jsp" /></div>
			</div>
		</form>
	</div>
</body>
<script>


$(frm).submit(function(e){
	e.preventDefault();
	if(!confirm("상품을 등록하시겠습니까?")) return;
	alert("상품이 등록되었습니다.");
	frm.submit();
});

	//업로드일 이미지 불러오기
	$("#image").on("click", function(){
		$(frm.image).click();
	});
	
	//불러오기한 이미지가 변경되었을때
	$(frm.image).on("change", function(){
		var reader=new FileReader();
		reader.onload=function(e){
			$("#image").attr("src", e.target.result);
		}
		reader.readAsDataURL(this.files[0]);
	});
	
	//상품코드 불러오기
	$.ajax({
		type:"get",
		url:"id",
		dataType:"json",
		success:function(data){
			$(frm.product_code).val(data.id);
		}
	});
	
	 
</script>
</html>
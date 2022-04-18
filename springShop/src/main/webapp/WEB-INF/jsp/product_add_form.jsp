<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product_add_form</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
	crossorigin="anonymous"></script>
<script>
	function add(){
		var name = $('#name').val();
		var com = $('#com').val();
		var price = $('#price').val();
		if(name=='' || com=='' || price==''){
			alert('모든 항목을 입력해주세요');
			return false;
		}
		var form = $('#product_add')[0]
		var formData = new FormData(form);
		console.log('form-data=',formData);
		$.ajax({
			url:'/onlineshop/product_add',
			method:'post',
			enctype:'multipart/form-data',
			cache:false,
			data:formData,
			dataType:'json',
			processData:false,
			contentType:false,
			timeout:000000,
			success:function(res){
				alert(res.added?'저장성공':'저장실패');
				location.href='/onlineshop/product_list/1';
			},
			error:function(xhr,status,err){
				alert('에러'+err);
			}
		});
		return false;
	}
</script>
</head>
<body>
<a href="/onlineshop/main"><h3>Product add form</h3></a>
<form id="product_add" onsubmit="return add();">
	<div><label>상품번호:<input type="text" id="num" name="num"></label></div>
	<div><label>상품이름:<input type="text" id="name" name="name"></label></div>
	<div><label>제조회사:<input type="text" id="com" name="com"></label></div>
	<div><label>상품소개:<input type="text" id="sum" name="sum"></label></div>
	<div><label>상품가격:<input type="text" id="price" name="price"></label></div>
	<div><label>제조날짜:<input type="text" id="pdate" name="pdate"></label></div>
	<div><label>사진:<input type="file" id="imgpath" name="imgpath" multiple="multiple"></label></div>
	<div>   
		<button type="submit">저 장</button>
		<button type="reset">취 소</button>
	</div>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Edit Form</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
	crossorigin="anonymous"></script>
<script>
	function edit(){
		var name = $('#name').val();
		var com = $('#com').val();
		var price = $('#price').val();
		if(name=='' || com=='' || price==''){
			alert('모든 항목을 입력해주세요');
			return false;
		}
		var serData = $('#product_edit').serialize();
		console.log('form-data=',serData);
		$.ajax({
			url:'/onlineshop/product_update',
			method:'post',
			cache:false,
			data:serData,
			dataType:'json',
			success:function(res){
				alert(res.updated?'수정성공':'수정실패');
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
<a href="/onlineshop/main"><h3>Product Edit Form</h3></a>
<form id="product_edit" onsubmit="return edit();">
	<div><label>상품번호 : <input type="text" id="num" name="num" readonly value='${find.num}'></label></div>
	<div><label>상품이름 : ${find.name}</label></div>
	<div><label>제조회사 : ${find.com}</label></div>
	<div><label>상품소개 : <input type="text" id="sum" name="sum" value='${find.sum}'></label></div>
	<div><label>상품가격 : <input type="text" id="price" name="price" value='${find.price}'></label></div>
	<div><label>제조날짜 : ${find.pdate}</label></div>
	<c:forEach var="img" items="${imgpath}">
	<div><label><img src="/img/${img.imgpath}"/></label></div>
	</c:forEach>
	<div>
		<button type="submit">저 장</button>
		<button type="reset">취 소</button>
	</div>
</form>
</body>
</html>
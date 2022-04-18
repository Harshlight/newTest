<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop Main Home</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
	crossorigin="anonymous"></script>
<script>
	//로그인 안한 사람이 inputform에 접근했을때 여기 있는 메세지가 뜨면서 로그인하라고 해야됨
	if('${msg}'){
		alert('${msg}');
		}
	if('${msg2}'){
		alert('${msg2}');
	}
</script>
</head>
<body>
<h3>Main Home Page</h3>
<br>
<div><a href="/onlineshop/user_detail">[My page]</a></div>
<div><a href="/onlineshop/login">[Login]</a></div>
<br>
<div><a href="/onlineshop/product_add">[상품 등록하기]</a></div>
<div><a href="/onlineshop/product_list/1">[상품 List]</a></div>

</body>
</html>
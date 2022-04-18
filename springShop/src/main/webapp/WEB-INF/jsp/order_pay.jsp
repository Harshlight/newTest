<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
	crossorigin="anonymous"></script>
<script>
	function pay(){
		if(!confirm("장바구니 상품들을 결제하시겠어요?")){
			return;
		}
		$.ajax({
			url:'/onlineshop/pay',
			cache:false,
			dataType:'json',
			success:function(res){
				alert(res.ok?'결제 성공':'결제 실패');
				location.href='/onlineshop/main';
			},
			error:function(xhr,status,err){
				alert('에러:'+err);
			}
		});
	}

</script>
</head>
<body>
<a href="/onlineshop/main"><h3>Order pay</h3></a>
<form id="pay_form" onclick="return pay();">
<table>
<tr><th>주문자</th><th>상품번호</th><th>상품이름</th><th>제조회사</th><th>상품수량</th><th>상품금액</th></tr>
		<c:forEach var="product" items="${list}">
		<tr>
		<td>${user.uid} </td>
		<td>${product.num} </td>
		<td>${product.name} </td>
		<td>${product.com} </td>
		<td>${product.qty} </td>
		<td>${product.price} </td>
		</tr>
		</c:forEach>
</table>
	<div><button type="button">결제하기</button></div>	
</form>
		
	
</body>
</html>
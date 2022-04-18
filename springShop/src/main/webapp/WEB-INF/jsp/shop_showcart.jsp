<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 리스트</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
	crossorigin="anonymous"></script>
<script>
	function qtychange(num){
		var newQty = $('#'+num).val();
		var obj = {};
		obj.num = num;
		obj.qty = newQty;
		if(!confirm('수량을 변경하시겠습니까?')){
			return;
		}
		$.ajax({
			url:'/onlineshop/qtychange',
			method:'post',
			cache:false,
			data:obj,
			dataType:'json',
			success:function(res){
				alert(res.change? '수정성공':'수정실패');
				$('#tdTotal').text(res.total+'원');
			},
			error:function(xhr,status,err){
				alert('에러'+err);
			}
		});
		return false;
	}
	
	function del(num){
		var reqURL='/onlineshop/cartdel/'+num;
		if(!confirm('정말로 삭제하시겠습니까?')){
			return;
		}
		location.href= reqURL;
	}
	
	function cartEmpty(){
		if(!confirm('정말로 장바구니를 비우시겠어요?')){
			return;
		}
		location.href='/onlineshop/cartempty';
	}
	
	function order(){
		if(!confirm("장바구니 상품들을 주문하시겠어요?")){
			return;
		}
		location.href='/onlineshop/order';
	}
</script>
</head>
<a href="/onlineshop/main"><h3>Show Cart</h3></a>
<body>

<table>
<tr><th>상품번호</th><th>상품이름</th><th>제조회사</th><th>가격</th><th>수량</th><th>삭제</th></tr>
<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.num}</td>
				<td>${item.name}</td>
				<td>${item.com} </td>
				<td>${item.price}</td>
				<td>
					<input type="number" id="${item.num}" value="${item.qty}" min="0">
					<button type="button" onclick="qtychange(${item.num});">저장</button>
				</td>
				<td>
					<button type="button" onclick="del(${item.num});">삭 제</button>
				</td>
			</tr>
		</c:forEach>
	<fmt:formatNumber type="number" maxFractionDigits="3" value="${total}" var="sum" />
	<tr id="footer"><td colspan="2">총 계<td id="tdTotal" colspan="3">${sum}원</td></tr>
</table>
<br>
[주문자 정보]
<table>
<tr><th>회원 번호</th><th>회원 이름</th><th>회원 주소</th><th>회원 이메일</th></tr>
	<tr>
		<td>${user.num}</td>
		<td>${user.uid}</td>
		<td>${user.uadr}</td>
		<td>${user.uemail}</td>
	</tr>
</table>


<hr>
<div><a href="/onlineshop/product_list/1">[쇼핑 계속하기]</a></div>
<div><a href="javascript:cartEmpty();">[장바구니 비우기]</a></div>
<div><a href="javascript:order();">[주문하기]</a></div>
</body>
</html>
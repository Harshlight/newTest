<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product detail</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
	crossorigin="anonymous"></script>
	
<c:set var="today" value="<%=new java.util.Date()%>" />
<!-- 현재날짜 -->
<c:set var="date"><fmt:formatDate value="${today}" pattern="yyyy-MM-dd hh:mm:ss" /></c:set> 
<!-- 현재년도 -->
<c:set var="year"><fmt:formatDate value="${today}" pattern="yyyy" /></c:set> 
<!-- 현재월 -->
<c:set var="month"><fmt:formatDate value="${today}" pattern="MM" /></c:set> 

<style>
	table{
	border: 1px solid #444444;
    border-collapse: collapse;
    width = "300";
    height = "100";
    align = "center";
	}
	th {
    border: 1px solid #444444;
  	}
</style>
<script>
	function del(num){
		if(!confirm('삭제하시겠습니까?')){
			return;
		}
		$.ajax({
			url:'/onlineshop/product_delete?num=${detail.num}',
			dataType:'json',
			success:function(res){
				alert(res.deleted="삭제 성공");
				location.href = '/onlineshop/product_list/1';
			},
			error:function(xhr,status,err){
				alert("error:"+err);
			}
		});
	}
	
	function inCart(){
		if($('#qty').val()<1){
			alert('수량은 필수 항목입니다');
			return false;
		}
		var serData= $('#order_form').serialize();
		console.log('form_data=', serData);
		$.ajax({
			url:'/onlineshop/tocart',
			method:'post',
			cache:false,
			data:serData,
			dataType:'json',
			success:function(res){
				alert(res.incart? '카트에 저장 성공' : '카트에 저장 실패');
				location.href='/onlineshop/showcart';
			},
			error:function(xhr,status,err){
				alert('에러'+err);
			}
		});
		return false;
	}
	
	function inputcomment(){
		var serData=$('#input_comment').serialize();
		console.log('form_data=', serData);
		$.ajax({
			url:'/onlineshop/product_detail/comment',
			method:'post',
			cache:false,
			data:serData,
			dataType:'json',
			success:function(res){
				alert(res.commentok? '등록 성공' : '등록 실패');
				location.reload();
			},
			error:function(xhr,status,err){
				alert('에러'+err);
			}
		})
	}
</script>
</head>
<body>
<a href="/onlineshop/main"><h3>Product detail</h3></a>

<div>상품 번호 : ${detail.num}</div>
<div>상품 이름 : ${detail.name}</div> 
<div>제조 회사 : ${detail.com}</div>
<div>상품 소개 : ${detail.sum}</div>
<div>상품 가격 : ${detail.price}</div>
<div>제조 날짜 : ${detail.pdate}</div>
<c:forEach var="img" items="${imgpath}">
<div><img src="${pageContext.request.contextPath}/img/${img.imgpath}" width="500" height="500"/></div>
</c:forEach>
<hr>
	<c:forEach var="com" items="${commentlist}">
	<table>
		<tr>
			<td>ID : ${com.uid}</td>
		</tr>
		<tr>
			<td colspan="2"> date : ${com.date}</td>
  			<td colspan="2"></td>
		</tr>
		<tr><td colspan="3" rowspan="3">${com.comment}</button></td>	</tr>
	</table>
	</c:forEach>
<hr>

<form id="input_comment" onsubmit="return inputcomment();">
	<table>
		<tr>
			<td>ID : <input type="text" name="uid" value="${user.uid}" readonly></td>
		</tr>
		<tr>
			<td colspan="2"> date :  <input type="text" name="date" value="${date}" readonly></td>
  			<td colspan="2"><input type="hidden" name="num" value="${detail.num}"/></td>
		</tr>
		<tr><td colspan="3" rowspan="3"><input type="text" name="comment" value="댓글을 입력해주세요"><button type="submit">등록</button></td>	</tr>
	</table>
</form>





<hr>
<a href="/onlineshop/product_edit_form/${detail.num}">[상품 내용 수정하기]</a>
<a href="javascript:del(${detail.num});">[상품 내용 삭제하기]</a>
<form id="order_form" onsubmit="return inCart();">
	<div>
	<input type="hidden" name="num" value="${detail.num}">
	<input type="hidden" name="name" value="${detail.name}">
	<input type="hidden" name="com" value="${detail.com}">
	<input type="hidden" name="price" value="${detail.price}">
	<input type="hidden" name="date" value="${detail.pdate}">
	<button type="submit">장바구니에 담기</button>	수량	<input type="number" id="qty" name="qty" min="1" max="100" value="1">
	</div>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User detail</title>
<style>
 	div {
 	
 	}
</style>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
	crossorigin="anonymous"></script>
<script>
	function del(num){
		if(!confirm('삭제하시겠습니까?')){
			return;
		}
		$.ajax({
			url:'/onlineshop/user_delete?num=${user.num}',
			dataType:'json',
			success:function(res){
				alert(res.deleted ? "삭제 성공" : "삭제 실패");
				location.href = '/onlineshop/main';
			},
			error:function(xhr,status,err){
				alert("error:"+err);
			}
		});
	}
</script>
</head>
<body>
<a href="/onlineshop/main"><h3>This is user detail page(Mypage)</h3></a>
<div>회원 번호 : ${user.num}</div>
<div>회원 아이디 : ${user.uid}</div>
<div>회원 비밀번호 : ${user.pwd}</div>
<div>회원 주소 : ${user.uadr}</div>
<div>회원 이메일 : ${user.uemail}</div>
<c:forEach var="img" items="${pfimg}">
<div><img src="/pfimg/${img.pfimg}" width="250" height="250"/></div>
</c:forEach>
<hr>
<div><a href="/onlineshop/user_edit">[회원정보 수정]</a></div>
<div><a href="/onlineshop/logout">[로그아웃]</a></div>
<div><a href="javascript:del(${user.num});">[회원탈퇴]</a></div>
<div><a href="/onlineshop/ordercheck/${user.uid}">[주문내역보기]</a></div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
	crossorigin="anonymous"></script>
<script>
	function update(){
		if(!confirm('정말로 수정하시겠어요?')) return false;
		var serData = $('#user_edit').serialize();
		console.log('form-data=',serData);
		$.ajax({
			url:'/onlineshop/user_update',
			method:'post',
			cache:false,
			data:serData,
			dataType:'json',
			success:function(res){
				alert(res.updated?'수정성공':'수정실패');
				//alert('로그아웃 이후 다시 재접속 해주세요');
				location.href='/onlineshop/user_detail';
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
<a href="/onlineshop/main"><h3>user update form test</h3></a>

<form id="user_edit" onsubmit="return update();">

	<div>회원 번호 : <input type="text" id="num" name="num" value='${user.num}' readonly></div>
	<div>회원 아이디 : <input type="text" id="uid" name="uid" value='${user.uid}' readonly></div>
	<div>회원 비밀번호 : <input type="text" id="pwd" name="pwd" value='${user.pwd}'></div>
	<div>회원 주소 : <input type="text" id="uadr" name="uadr" value='${user.uadr}'></div>
	<div>회원 메일 : <input type="text" id="uemail" name="uemail" value='${user.uemail}'></div>
	<c:forEach var="img" items="${pfimg}">
	<div><img src="/pfimg/${img.pfimg}"/></div>
	</c:forEach>
	<div>
		<button type="submit">저 장</button>
		<button type="reset">취 소</button>
	</div>
	
</form>

</body>
</html>
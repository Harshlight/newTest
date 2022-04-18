<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Add Form</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
	crossorigin="anonymous"></script>
<script>
	function add_user(){
		var uid = $('#uid').val();
		var pwd = $('#pwd').val();
		if(uid=='' || pwd==''){
			alert('아이디와 비밀번호는 필수입력입니다');
			return false;
		}
		
		var form = $('#user_add')[0]
		var formData = new FormData(form);
		console.log('form-data=',formData);
		$.ajax({
			url:'/onlineshop/user/add',
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
				location.href='/onlineshop/main';
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
<a href="/onlineshop/main"><h3>User Add Form</h3></a>
<form id="user_add" onsubmit="return add_user();">
	<div>회원 번호 : <input type="text" id="num" name="num"></div>
	<div>회원 아이디 : <input type="text" id="uid" name="uid"></div>
	<div>회원 비밀번호 : <input type="text" id="pwd" name="pwd"></div>
	<div>회원 주소 : <input type="text" id="uadr" name="uadr"></div>
	<div>회원 메일 : <input type="text" id="uemail" name="uemail"></div>
	<div>회원 프로필 사진 :<input type="file" id="pfiles" name="pfiles" multiple="multiple"></div>
	<div>
		<button type="submit">저 장</button>
		<button type="reset">취 소</button>
	</div>
</form>
</body>
</html>
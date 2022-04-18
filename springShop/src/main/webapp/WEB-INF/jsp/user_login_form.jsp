<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>

<script>
	//로그인 안한 사람이 inputform에 접근했을때 여기 있는 메세지가 뜨면서 로그인하라고 해야됨
	if('${msg}'){
		alert('${msg}');
		}
</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
	crossorigin="anonymous"></script>
<script>
	function login(){
		var uid = $('#uid').val();
		var pwd = $('#pwd').val();
		if(uid=='' || pwd==''){
			alert('아이디와 비밀번호는 필수입력입니다');
			return false;
		}
		var serData = $('#user_login').serialize();
		console.log('form-data=',serData);
		$.ajax({
			url:'/onlineshop/user_login',
			method:'post',
			cache:false,
			data:serData,
			dataType:'json',
			success:function(res){
				alert(res.login?'로그인성공':'로그인실패');
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
<a href="/onlineshop/main"><h3>User Login</h3></a>
<form id="user_login" onsubmit="return login();">
	<div>ID:<input type="text" id="uid" name="uid"></div>
	<div>PW:<input type="text" id="pwd" name="pwd"></div>

	<div><button type="submit">로그인</button><button type="reset">취소</button></div> 
</form>
<hr>
<a href="/onlineshop/user/add">[회원등록]</a>
</body>
</html>
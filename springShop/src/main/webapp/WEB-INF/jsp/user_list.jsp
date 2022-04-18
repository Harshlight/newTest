<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
<h3>This is User List</h3>
<c:forEach var="user" items="${list}">
	<div>${user.num} ${user.uid} ${user.pfimg}</div>
</c:forEach>
</body>
</html>
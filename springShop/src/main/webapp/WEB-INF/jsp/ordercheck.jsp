<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OrderCheck</title>
</head>
<body>
<a href="/onlineshop/main"><h3>This is OrderCheck test</h3></a>

<table>
<tr><th>주문자</th><th>상품번호</th><th>상품이름</th><th>제조회사</th><th>상품수량</th><th>주문날짜</th></tr>
		<c:forEach var="orderlist" items="${orderlist}">
		<tr>
		<td>${orderlist.uid} </td>
		<td>${orderlist.num} </td>
		<td>${orderlist.name} </td>
		<td>${orderlist.com} </td>
		<td>${orderlist.qty} </td>
		<td>${orderlist.date} </td>
		</tr>
		</c:forEach>
</table>	
</body>
</html>
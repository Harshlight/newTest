<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List Page</title>
</head>
<body>
<a href="/onlineshop/main"><h3>Product List Page</h3></a>
<table>
<tr><th>상품번호</th><th>상품이름</th><th>제조회사</th><th>가격</th></tr>
<c:forEach var="product" items="${pageInfo.list}">
	<tr>
		<td>${product.num}</td>
		<td><a href="/onlineshop/product_detail/${product.num}">${product.name}</a></td>
		<td>${product.com}</td>
		<td>${product.price}</td>
	</tr>
</c:forEach>
</table>

<div id="pagination">
   <c:forEach var="i" items="${pageInfo.navigatepageNums}">
      <c:choose>
         <c:when test="${i==pageInfo.pageNum}">
            [${i}] 
         </c:when>
         <c:otherwise>
            [<a href="/onlineshop/product_list/${i}">${i}</a>] 
         </c:otherwise>
      </c:choose> 
   </c:forEach>
</div>
</body>
</html>
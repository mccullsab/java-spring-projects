<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
        	<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
   
<meta charset="UTF-8">
<title>Fruit</title>
</head>
<body>

<h2 class=ml-5>Fruits</h2>

<table >
<thead>
<tr>
<td>Fruit</td>
<td>Price</td>
</tr>
</thead>
<tbody>
	<tr>
<td><c:out value="${fruitList[0].name }"/></td>
<td><c:out value="${fruitList[0].price }"/></td>
</tr>
	<tr>
<td><c:out value="${fruitList[1].name }"/></td>
<td><c:out value="${fruitList[1].price }"/></td>
</tr>
	<tr>
<td><c:out value="${fruitList[2].name }"/></td>
<td><c:out value="${fruitList[2].price }"/></td>
</tr>
	<tr>
<td><c:out value="${fruitList[3].name }"/></td>
<td><c:out value="${fruitList[3].price }"/></td>
</tr>
</tbody>
</table>

</body>
</html>
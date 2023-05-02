<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
        	<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
   
</head>
<body>
<h1>Expenses Details</h1>
<a href="/">Go Back</a>
<h3>Id: <c:out value="${oneExpense.id }"></c:out></h3>
<h3>Expense: <c:out value="${oneExpense.item }"></c:out></h3>
<h3>Vendor: <c:out value="${oneExpense.vendor }"></c:out></h3>
<h3>Amount: <c:out value="${oneExpense.price }"></c:out></h3>

</body>
</html>
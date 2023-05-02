<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
        	<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
   
</head>
<body>
Details Page
<h3>Id: <c:out value="${oneDonation.id }"></c:out></h3>
<h3>Donation Name: <c:out value="${oneDonation.donationName }"></c:out></h3>
<h3>Donor: <c:out value="${oneDonation.donor }"></c:out></h3>
<h3>Quantity: <c:out value="${oneDonation.quantity }"></c:out></h3>
<h3>Description: <c:out value="${oneDonation.description }"></c:out></h3>

</body>
</html>
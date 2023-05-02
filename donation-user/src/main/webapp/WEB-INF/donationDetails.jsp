<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Donation details Page
<h3>Id: <c:out value="${oneDonation.id }"></c:out></h3>
<h3>Donation Name: <c:out value="${oneDonation.donationName }"></c:out></h3>
<h3>Quantity: <c:out value="${oneDonation.quantity }"></c:out></h3>
<h3>Description: <c:out value="${oneDonation.description }"></c:out></h3>


<h3>Donated By: <c:out value="${oneDonation.donor.userName }"></c:out></h3>
<h3>Contact Donor: <c:out value="${oneDonation.donor.email }"></c:out></h3>

</body>
</html>
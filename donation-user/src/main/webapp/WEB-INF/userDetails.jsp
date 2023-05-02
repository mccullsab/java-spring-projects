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
User Details Page
<h3>Id: <c:out value="${oneUser.id }"></c:out></h3>
<h3>User Name: <c:out value="${oneUser.userName }"></c:out></h3>
<h3>Email: <c:out value="${oneUser.email }"></c:out></h3>
	<table>
		<thead>
			<tr>
				<th> ID </th>
				<th> donation name </th>
				<th> Quantity </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachDonation" items="${oneUser.sentDonations }" >
			<tr>
				<td> <c:out value="${eachDonation.donor.id }" /> </td>
				<td> <a href="/donations/${eachDonation.donationName }"><c:out value="${eachDonation.donationName }" /> </a></td>
				<td> <c:out value="${eachDonation.quantity }" /> </td>
			</tr>
			</c:forEach>
		</tbody>
		
	</table>
</body>
</html>
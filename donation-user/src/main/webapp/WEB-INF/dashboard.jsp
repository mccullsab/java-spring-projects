<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>donation name</th>
				<th>Donor</th>
				<th>Quantity</th>
				<th colspan="2">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachDonation" items="${donationList }">
				<tr>
					<td><c:out value="${eachDonation.id }" /></td>
					<td><a href="donations/${eachDonation.id }"> <c:out
								value="${eachDonation.donationName }" />
					</a></td>
					<td><a href="users/${eachDonation.donor.id }"> <c:out
								value="${eachDonation.donor.userName }" /></a></td>
					<td><c:out value="${eachDonation.quantity }" /></td>
					
					<c:choose>
					<c:when test ="${eachDonation.donor.id == userId }" >
					<td><a href="/donations/edit/${eachDonation.id }">Edit</a>
						<form action="/donations/${eachDonation.id }" method="POST">
							<input type="hidden" name="_method" value="delete" />
							<button type="submit">Delete</button>
						</form></td>
					</c:when>
					<c:otherwise>
					<!-- needed for many to many -->
					<td>
						<form action="/donations/${eachDonation.id }/recieve" method="POST">
						<input type="hidden" name="_method" value="PUT" />
						<button type="submit">Receive</button>
						</form>
					</td>
					<td>
						
					</td>
					</c:otherwise>
					</c:choose>
						
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>
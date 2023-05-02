<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Donation</title>
</head>
<body>
	<h1>Edit Donation</h1>
	<form:form action="/donations/${oneDonation.id }" method="PUT"
		modelAttribute="newDonation">
		
<!-- 		used for login and reg
 -->		<form:hidden path="donor"/>
		
<!-- 		below removed for login and reg
 -->		
<%-- 		<form:select path="donor">
			<c:forEach var="eachUser" items="${userList }">
				<c:choose>
					<c:when test="${eachUser.id == oneDOnation.donor.id }">
						<form:option value="${eachUser.id }" selected="true">${eachUser.userName } -- ${eachUser.email }</form:option>
					</c:when>
					<c:otherwise>
						<form:option value="${eachUser.id }">${eachUser.userName } -- ${eachUser.email }</form:option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</form:select> --%>
		<p>
			<form:label path="donationName"> Donation name</form:label>
			<form:input type="text" path="donationName" />
			<form:errors path="donationName" />
		</p>
		<p>
			<form:label path="quantity"> Quantity</form:label>
			<form:input type="number" path="quantity" />
			<form:errors path="quantity" />
		</p>
		<p>
			<form:label path="description"> Description</form:label>
			<form:textarea path="description"></form:textarea>
			<form:errors path="description" />
		</p>
		<button type="submit">Submit</button>

	</form:form>
</body>
</html>
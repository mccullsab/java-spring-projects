<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring demo</title>
</head>
<body>
	<form:form action="/donations/edit/${oneDonation.id }" method="PUT" modelAttribute="oneDonation">
	<p>
		<form:label path="donationName"> Donation name</form:label>
		<form:input type="text" path="donationName" />
		<form:errors path="donationName" />
	</p>
	<p>
		<form:label path="donor"> Donor</form:label>
		<form:input type="text" path="donor" />
		<form:errors path="donor" />
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
	<button type="submit"> Submit</button>
	
	</form:form>
</body>
</html>
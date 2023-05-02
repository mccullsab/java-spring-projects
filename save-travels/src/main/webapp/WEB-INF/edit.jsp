<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
<h1>Edit Expenses</h1>
<a href="/">Go Back</a>

	<form:form action="/expenses/edit/${oneExpense.id }" method="PUT" modelAttribute="oneExpense">
	<p>
		<form:label path="item"> Expense</form:label>
		<form:input type="text" path="item" />
		<form:errors path="item" />
	</p>
	<p>
		<form:label path="vendor"> Vendor</form:label>
		<form:input type="text" path="vendor" />
		<form:errors path="vendor" />
	</p>
	<p>
		<form:label path="price"> Amount</form:label>
		<form:input type="double" path="price" />
		<form:errors path="price" />
	</p>
	<button type="submit"> Submit</button>
	
	</form:form>
</body>
</html>
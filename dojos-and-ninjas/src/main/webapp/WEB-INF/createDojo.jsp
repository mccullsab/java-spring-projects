<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Dojo</title>
</head>
<body>
<h1>Create Dojo</h1>
<form:form action="/dojos" method="POST" modelAttribute="dojo">
	<p>
		<form:label path="dojoName"> Location</form:label>
		<form:input type="text" path="dojoName" />
		<form:errors path="dojoName" />
	</p>
	<button type="submit"> Submit</button>
	
	</form:form>
</body>
</html>
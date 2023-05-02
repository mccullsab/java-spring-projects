<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Reg</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <h1> Register</h1>
   <form:form action="/register" method="POST" modelAttribute="newUser">
   <p>
		<form:label path="userName"> User name</form:label>
		<form:input type="text" path="userName" />
		<form:errors path="userName" />
	</p>
	<p>
		<form:label path="email">Email</form:label>
		<form:input type="text" path="email" />
		<form:errors path="email" />
	</p>
		<p>
		<form:label path="password">Password</form:label>
		<form:input type="password" path="password" />
		<form:errors path="password" />
	</p>
		<p>
		<form:label path="confirm">Confirm Password</form:label>
		<form:input type="password" path="confirm" />
		<form:errors path="confirm" />
	</p>
	<button type="submit"> Register</button>
   </form:form>
   
   
      <h1>Login</h1>
   <form:form action="/login" method="POST" modelAttribute="newLogin">
	<p>
		<form:label path="email">Email</form:label>
		<form:input type="text" path="email" />
		<form:errors path="email" />
	</p>
		<p>
		<form:label path="password">Password</form:label>
		<form:input type="password" path="password" />
		<form:errors path="password" />
	</p>

	<button type="submit"> Login</button>
   </form:form>
</body>
</html>


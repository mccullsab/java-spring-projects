<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
<div class="flex d-flex justify-content-between align-items-center px-3">
	<h1>Change Your Entry</h1>
	<a href="/books">Back to the shelves</a>
	</div>
	<form:form action="/books/${oneBook.id }/edit" method="PUT"
		modelAttribute="oneBook" class="px-3">
		<form:hidden path="user" />
		<p class=form-group>
			<form:label path="title"> Title</form:label>
			<form:input type="text" path="title" />
			<form:errors path="title" />
		</p>
		<p class=form-group>
			<form:label path="author"> Author</form:label>
			<form:input type="text" path="author" />
			<form:errors path="author" />
		</p>
		<p class=form-group>
			<form:label path="thoughts"> Thoughts</form:label>
			<form:textarea path="thoughts"></form:textarea>
			<form:errors path="thoughts" />
		</p>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
</body>
</html>


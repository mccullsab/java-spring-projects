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
<title>Detail</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div
		class="flex d-flex justify-content-between align-items-center px-3">
		<h1>Book Details Page</h1>
		<a href="/books">Back to the shelves</a>
	</div>
	<div class="px-3">

		<h2>
			<c:out value="${oneBook.user.userName }"></c:out>
			read
			<c:out value="${oneBook.title }"></c:out>
			by
			<c:out value="${oneBook.author }"></c:out>
		</h2>
		<h4>Here are ${oneBook.user.userName }'s thoughts:</h4>
		<p>
			<c:out value="${oneBook.thoughts }"></c:out>
		</p>
		<c:choose>
			<c:when test="${oneBook.user.id == userId}">
				<div class="flex d-flex">
					<a href="/books/${oneBook.id }/edit" class="btn btn-secondary">Edit</a>
					<div class="px-3">
						<form action="/books/${oneBook.id}" method="POST">
							<input type="hidden" name="_method" value="delete" />
							<button type="submit" class="btn btn-danger">Delete</button>
						</form>
					</div>
			</c:when>
			<c:otherwise>
				<!-- 	<td></td>
						<td></td> -->
			</c:otherwise>
		</c:choose>
	</div>
	</div>
</body>
</html>


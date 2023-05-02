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
<title>Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="row">
		<div>
			<a href="/songs/new">Add Song</a>
			<a href="/songs/top">Tops Songs</a>
			
		</div>
		<div>
			<form action="dashboard" method="post">
				<input id="artist" name="artist" placeholder="Search" /> 
				<input type="submit" value="Search" />
			</form>
		</div>
	</div>
	<table class=table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Actions</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneSong" items="${songList }">
				<tr>
					<td><a href="/songs/${oneSong.id }"><c:out
								value="${oneSong.name }"></c:out></a></td>
					<td><c:out value="${oneSong.rating }"></c:out></td>
					<td>
						<form action="/songs/${oneSong.id }" method="POST">
							<input type="hidden" name="_method" value="delete" />
							<button type="submit" class="btn btn-outline-secondary">Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>


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
	<div
		class="flex d-flex justify-content-between align-items-center px-3">
		<h1 class=px-3>
			Welcome,
			<c:out value="${userName }"></c:out>
			here are some name suggestions.
		</h1>
		<div class="flex d-flex">
			<a href="/logout">Logout</a>
		</div>
	</div>
	<br>
	<div class=px-3>
		<h2>Baby Names</h2>
		<table class=table>
			<thead>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th>Votes</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="eachName" items="${nameList }">
					<tr>
						<td><c:choose>
								<c:when test="${not eachName.hasUserVoted(userId) }">
									<form action="/names/${eachName.id}/upvote" method="POST"
										class="px-3 mt-3">
										<input type="hidden" name="_method" value="upvote" /> <input
											type="hidden" name="userId" value="${userId }" />

										<button type="submit" class="btn btn-success px-3">Upvote</button>
									</form>
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose></td>
						<td><a href="names/${eachName.id }"> <c:out
									value="${eachName.babyName }" />
						</a></td>
						<td><c:out value="${eachName.gender }" /></td>
						<td>Origin: <c:out value="${eachName.origin }" /></td>
						<td><c:out value="${eachName.users.size() }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<p class=px-3>
		<a href="/names/new" class="px-3 btn btn-success">New name</a>
	</p>
</body>
</html>


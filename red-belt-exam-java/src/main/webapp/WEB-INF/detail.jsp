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
		<h1>
			<c:out value="${oneName.babyName }"></c:out>
		</h1>
		<a href="/names">home</a>
	</div>
	<div class="px-3">
		<h1>
			(Added by
			<c:out value="${oneName.user.userName}"></c:out>
			)
		</h1>
		<h3>
			Gender:
			<c:out value="${oneName.gender }"></c:out>
		</h3>
		<h3>
			Origin:
			<c:out value="${oneName.origin }"></c:out>
		</h3>
		<p>
			Meaning:
			<c:out value="${oneName.meaning }"></c:out>
		</p>
		<c:choose>
			<c:when test="${oneName.user.id == userId}">
				<div class="flex d-flex">
					<a href="/names/${oneName.id }/edit" class="btn btn-secondary">Edit</a>
			</div>
			</c:when>
			<c:otherwise>
				<!-- 	<td></td>
						<td></td> -->
			</c:otherwise>
		</c:choose>
	</div>


</body>
</html>


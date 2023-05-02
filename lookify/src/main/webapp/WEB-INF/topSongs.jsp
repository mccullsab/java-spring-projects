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
<title>Top Songs</title>
</head>
<body>
<table class=table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Artist</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneSong" items="${songList }">
				<tr>
					<td><a href="/songs/${oneSong.id }"><c:out
								value="${oneSong.name }"></c:out></a></td>
					<td><c:out value="${oneSong.rating }"></c:out></td>
					<td><c:out value="${oneSong.artist }"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>
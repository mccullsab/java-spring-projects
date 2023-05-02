<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table table-striped">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachNinja" items="${oneNinja.setNinja}">
				<tr>
					<td><c:out value="${eachNinja.ninjaFirstName}"></c:out></td>
					<td><c:out value="${eachNinja.ninjaLastName}"></c:out></td>
					<td><c:out value="${eachNinja.age}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
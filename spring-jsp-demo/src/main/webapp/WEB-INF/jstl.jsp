<!-- Here we have to import the Date class. -->
<!-- You will put the import in the first line of the jsp tag. Use the import attribute -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Demo JSP</title>
        	<link rel="stylesheet" type="text/css" href="/css/style.css">
        	<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        	
    </head>
<body>
<div class=container> 
HI JSTL!
<h2 class="redtext">Variables</h2>
<h3>Name: ${jspName}</h3>
<h3>Happiness: <c:out value="${jspHappiness }"/></h3>
<h3>HackerCode: <c:out value="${jspHack }"/></h3>
<!-- How does the below work -->
<h3><c:out value="${hackerCode }"/></h3>
<h2>If condition</h2>
<c:if test="${jspHappiness > 5 }">
<h3>I am happy</h3>
</c:if>

<h2>If else condition</h2>
<c:choose>
<c:when test="${jspName.length() > 5 }">
<h3>Name is long</h3>
</c:when>
<c:otherwise>
<h3>Name is short</h3>
</c:otherwise>
</c:choose>

<h2>For loop</h2>
<ol>
<c:forEach var="eachSkill" items="${skillList }">
	<li><c:out value="${eachSkill }"/></li>
</c:forEach>
</ol>

</div>
</body>
</html>

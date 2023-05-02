<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
        	<link rel="stylesheet" type="text/css" href="/css/style.css">
        	<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        
</head>
<body>
<h1>Here is your Omikuji!</h1>
<h3 class=border>
In ${number } years, you will live in ${city } with ${person }
as your roommate, ${hobby } for a living. The next time you see a ${thing }, you will have good luck.
Also, You do not realize how happy you make others.
</h3>
<p><a href="/">Go Back</a></p>
</body>
</html>
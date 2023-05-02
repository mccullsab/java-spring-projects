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
<h1>Your Gold:</h1>
<div class=main>
<div class="square">
<p>Farm</p>
<p>(earns 10-20 gold)</p>
<form method="POST" action="/process">
<button>Find Gold!</button>
</form>
</div>
<div class="square">
<p>Cave</p>
<p>(earns 5-10 gold)</p>
<form method="POST" action="/process">
<button>Find Gold!</button>
</form>
</div>
<div class="square">
<p>House</p>
<p>(earns 2-5 gold)</p>
<form method="POST" action="/process">
<button>Find Gold!</button>
</form>
</div>
<div class="square">
<p>Quest</p>
<p>(earns 0-50 gold)</p>
<form method="POST" action="/process">
<button>Find Gold!</button>
</form>
</div>
</div>
</body>
</html>
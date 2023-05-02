<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Render</title>
        	<link rel="stylesheet" type="text/css" href="/css/style.css">
        	<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
      
</head>
<body>
<h1>Send your Omikuji!</h1>
    <form action='/process' method='POST'>
	<label>Pick any number from 5 to 25:</label>
    	<input type="number" name='number'>
    	<br>
	<label>Enter the name of any city:</label>
    	<input type='text' name='city'>
    	    	<br>
    <label>Enter the name of a real person:</label>
    	<input type='text' name='person'>
    	    	<br>
    <label>Enter a profession endeavor or hobby:</label>
    	<input type='text' name='hobby'>
    	    	<br>
     <label>Enter any type of living thing:</label>
    	<input type='text' name='thing'>
    	    	<br>
     <label>Say something nice to someone:</label>
        <textarea name="nice"></textarea>
            	<br>
    <button type='submit'>Send</button>
    <p>send and show a friend!</p>
    </form>
</body>
</html>
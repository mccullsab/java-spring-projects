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
<link rel="stylesheet" type="text/css" href="/css/style.css">

<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="header px-3 m-1">
		<div class="logocombo">
		<a href="/dashboard"><img
				src="https://media.istockphoto.com/id/1310532475/vector/lighthouse-beacon-warning-sign-navigation-seamark-grey-icon.jpg?s=612x612&w=0&k=20&c=-NA0ZK1zx6QEkDh1Ytzb-cCQKGD5edEAaWaTZNKDn-o=">			</a>
		
			
			<h1>Lighthouse Home</h1>
		</div>
		<div class="links">
			 <a href="/profile/${userId }" class="btn">Profile</a>
			 | 
			 <a href="/logout" class="btn">Logout</a>
		</div>
	</div>


	<div class="body">
		<div class="bodycontain">

			<div class="left">
				<h2 class="text-center">Send Message</h2>
				<p>Select a user and write them a message in
					the box below.</p>

				<form:form action="/dashboard" method="POST"
					modelAttribute="newMessage" class="form">
					<form:hidden path="from_user" value="${userId }" />
					<form:select path="to_user">
						<c:forEach var="eachUser" items="${toUserList }">
							<form:option value="${eachUser }" label="${eachUser.userName }" />
						</c:forEach>
					</form:select>
					<p>
						<form:textarea path="message"></form:textarea>
						<form:errors path="message" />
					</p>
					<div class="flex d-flex">
						<button type="submit" class="btn formbutton">Send</button>
					</div>
				</form:form>
				<br>
				<p><em>New messages will only be viewable by the recipient after 9pm local time.</em></p>
			</div>
			<div class="right">
				<h2 class="text-center">Messages Received</h2>
				<!-- 					<thead>
						<tr>
							<th>Message</th>
							<th>From</th>
							<th>Date</th>
							<th>Vote</th>
						</tr>
					</thead> -->
				<c:forEach var="eachMessage" items="${messageList }">



					<c:choose>

						<c:when test="${eachMessage.to_user.id == userId}">
							<div class="messagebox">

								<div class="messageleft">
									<p>
									<a href="/profile/${eachMessage.from_user.id }" class="link-secondary"><strong><c:out value="${eachMessage.from_user.userName }" /></strong></a>
										
										messaged you...
									</p>
									<h5 class="messagetext">
										<c:out value="${eachMessage.message }" />
									</h5>
									<p class="messagetime">
										on
										<fmt:formatDate type = "date" value = "${eachMessage.createdAt}" />
									</p>
									
								</div>
								<div class="vote">
									<form action="/messages/${eachMessage.id}/upvote" method="POST">
										<button class="votebutton">+</button>
									</form>
									<p class="votenumb">
										<c:out value="${eachMessage.vote }" />
									</p>
									<form action="/messages/${eachMessage.id}/downvote"
										method="POST">
										<button class="votebutton">-</button>
									</form>
								</div>
							</div>

						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>


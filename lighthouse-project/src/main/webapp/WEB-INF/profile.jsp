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
<title>User Profile</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" type="text/css" href="/css/profile.css">

<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="header px-3 m-1">
		<div class="logocombo">
			<a href="/dashboard"><img
				src="https://media.istockphoto.com/id/1310532475/vector/lighthouse-beacon-warning-sign-navigation-seamark-grey-icon.jpg?s=612x612&w=0&k=20&c=-NA0ZK1zx6QEkDh1Ytzb-cCQKGD5edEAaWaTZNKDn-o=">
			</a>


			<h1>${oneUser.userName }'s Profile</h1>
		</div>
		<div class="links">
			<a href="/dashboard" class="btn">Dashboard</a> | <a href="/logout"
				class="btn">Logout</a>
		</div>
	</div>


	<div class="body">
		<div class="bodycontain">
			<c:choose>
				<c:when test="${oneUser.id == userId}">
					<div class="left">
						<h2 class="text-center">${oneUser.userName }'s Information</h2>
						<p>
							<strong>Username</strong>: ${oneUser.userName }
						</p>
						<p>
							<strong>User Id</strong>: ${oneUser.id }
						</p>
						<p>
							<strong>Email</strong>: ${oneUser.email }
						</p>
					</div>

					<div class="right">
						<h2 class="text-center">Settings</h2>
						<p>
							<strong> Message Visibility</strong>:
							<c:choose>
								<c:when test="${oneUser.privacy == 'false' }">
				Public
				</c:when>
								<c:when test="${oneUser.privacy == 'true' }">
				Private
				</c:when>
							</c:choose>

						</p>
						<div class="d-flex justify-content-around align-items-center">
							<c:choose>
								<c:when test="${oneUser.privacy == 'false' }">
									<form action="/profile/${oneUser.id}/setpublic" method="POST">
										<button
											class="m-2 btn btn-outline-secondary border border-5 bg-light">Public</button>
									</form>
									<form action="/profile/${oneUser.id}/setprivate" method="POST">
										<button class="m-2 btn border border-1">Private</button>
									</form>
								</c:when>
								<c:otherwise>
									<form action="/profile/${oneUser.id}/setpublic" method="POST">
										<button class="m-2 btn border border-1">Public</button>
									</form>
									<form action="/profile/${oneUser.id}/setprivate" method="POST">
										<button
											class="m-2 btn btn-outline-secondary border border-5 bg-light">Private</button>
									</form>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="left" style="margin-right: 25px;">
						<h2 class="text-center">${oneUser.userName }'s Information</h2>
						<p>
							<strong>Username</strong>: ${oneUser.userName }
						</p>
						<p>
							<strong>User Id</strong>: ${oneUser.id }
						</p>
						<p>
							<strong>Email</strong>: ${oneUser.email }
						</p>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="bottomcenter">
			<h2 class="text-center">Messages Sent</h2>
			<c:forEach var="eachMessage" items="${messageList }">
				<c:choose>
					<c:when
						test="${oneUser.id == eachMessage.from_user.id && oneUser.privacy == 'false' || oneUser.id == userId}">
						<div class="messagebox">

							<div class="messageleft">
								<p>
									${eachMessage.from_user.userName } messaged
									<c:out value="${eachMessage.to_user.userName }" />
									...
								</p>
								<h5 class="messagetext">
									<c:out value="${eachMessage.message }" />
								</h5>
								<p class="messagetime">
									on
									<fmt:formatDate type="date" value="${eachMessage.createdAt}" />
								</p>
							</div>
							<div class="vote">
								<c:choose>
									<c:when test="${eachMessage.vote > 0 || eachMessage.vote < 0}">
										<p>
											<span class="votenumb"><c:out
													value="${eachMessage.vote }" /></span> likes
										</p>
									</c:when>
									<c:otherwise>
										<p>
											<span class="votenumb"> 0</span> likes

										</p>
									</c:otherwise>
								</c:choose>
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
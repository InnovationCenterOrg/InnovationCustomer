<!DOCTYPE HTML>

<%@page import="com.ibm.innovationcustomer.constants.CommonConstants"%>
<%@page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@page import="com.ibm.innovationcustomer.model.ProfileUserModel"%>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<title>IBM Innovation Center</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<img align="left" class="img-responsive" src="images/logo-ibm-white.png" width="20%" height="20%"/>
			</div>
		</div>
	</nav>
	<div class="container">
		<h1 align="left">Access Denied</h1>
		<br>
		<table>
		<tbody>
			<tr height="20%">
				<td width="5%"></td>
				<td width="25%">
					<img class="img-responsive" src="images/dislike.png" width="100%" height="100%">
				</td>
				<td width="5%"></td>
				<td width="65%">
					Please <a href="LoginInitAction">login</a> first.<br>
					Or <a href="RegisterInitAction">sign up here</a>
				</td>
			</tr>
			</tbody>
		</table>
		
	</div>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	
</body>
</html>
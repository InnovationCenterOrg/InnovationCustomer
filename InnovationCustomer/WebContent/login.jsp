<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@include file="includes/meta.jsp"%>
<title>LuckyDraw</title>
<!-- Bootstrap -->
<link href="css/default.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">

<!--  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  -->

</head>

<body>
	<h1>Hello World</h1>
	<div class="container">
		<form method="post" action="LoginAction" class="form-signin">
			<input type="text" class="form-control" id="userId" name="userId" placeholder="UserId">
			<button type="submit" class="btn btn-primary form-control">Login</button>
	
		</form>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js"></script>

	</div>
</body>
</html>
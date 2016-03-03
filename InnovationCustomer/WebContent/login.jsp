<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@include file="includes/meta.jsp"%>
<title>IBM Innovation Center</title>
<!-- Bootstrap -->
<link href="css/default.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">

<!--  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  -->
</head>
<body>
	<br><br><br>
	<div align="center">
		<img class="img-responsive" src="images/ibm_logo.png" width="60%" height="60%"/>
	</div>
	<div class="container">
	<h2 align="center">Innovation Center</h2>
		<%String authenMessage = (String) request.getAttribute("message");
		if(authenMessage != null && !authenMessage.equals("")){%>
			<p class="bg-danger" style="font-size: x-small; height: 8%;" > <!-- background-color: #fad1d1; -->
			  <i class="glyphicon glyphicon-remove"></i> ${message}
			</p>
		<%} %>
		<form method="post" action="LoginAction" class="form-signin">
			<%System.out.println("JSP REQUEST URL : "+request.getAttribute("javax.servlet.forward.request_uri").toString()); %>
			<input type="hidden" id="eveId" name="eveId" value="<%=request.getParameter("eveId")%>">
			<input type="text" class="form-control" id="userId" name="userId" placeholder="Username"><br>
			<input type="password" class="form-control" id="password" name="password" placeholder="Password"><br>
			<div class='col-md-2 text-center'>
				<button type="submit" class="btn btn-primary btn-block">
					<i class="glyphicon glyphicon-log-in"></i> Log in
				</button>
			</div>
			<div align="center">
				<font style="font-size: x-small;">
					<a href="RegisterInitAction">Sign up here</a><br>
					<a class="test" href="#" data-toggle="tooltip" data-placement="bottom" title="Please contact IBM Staff to reset your password.">Forgot Password</a>
					
				</font>
			</div>
		</form>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js"></script>
		<script>
		$(document).ready(function(){
		    $('[data-toggle="tooltip"]').tooltip();   
		});
		</script>
	</div>
</body>
</html>
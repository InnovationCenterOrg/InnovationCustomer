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
	<%ProfileUserModel currentUser = (ProfileUserModel) request.getSession().getAttribute("currentUser"); %>
	<div class="navbar navbar-static-top">
   		<div class="container">
   			<div align="left">
   			<a href="HomeInitAction">
				<img style="margin-top: 2%;" align="left" class="img-responsive" src="./images/logo-ibm-white.png" width="20%" height="20%"/>
			</a>
			</div>
			<div align="right">
			  	<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
			    	<img style="margin-top: 3%" align="right" class="img-responsive" src="./images/profile_icon_3.ico" width="15%" height="15%"/>
			 	 </a>
			  	<ul class="dropdown-menu  pull-right" role="menu">
			    	<li style="background-color: #75c3f0"><a tabindex="-1" href="ViewProfileInitAction">Profile Setting</a></li>
			    	<li style="background-color: #75c3f0"><a tabindex="-1" href="ChangePasswordInitAction">Change Password</a></li>
				  	<li style="background-color: #75c3f0"><a tabindex="-1" href="LogoutAction">Logout</a></li>
			  	</ul>
			</div>
		</div>
	</div>		
	<div align="right" style="font-size: x-small; padding-right: 3%">		
		<font style="font-size: xx-small;">Hi, <%=currentUser.getProFullName() %></font>
	</div>
	<div class="container">
		<%
		String result = (String) request.getAttribute("profileMessage");
		if(result != null && !result.equals("")){ 
				if(result.toUpperCase().contains(CommonConstants.RETURN_SUCCESS)){%>
				<p class="bg-info" style="font-size: x-small; height: 8%;" > <!-- background-color: #d1ebfa;  -->
					  <i class="glyphicon glyphicon-ok"></i> ${profileMessage}
				</p>
			<%}else{ %>
				<p class="bg-danger" style="font-size: x-small; height: 8%;" > <!-- background-color: #fad1d1; -->
					  <i class="glyphicon glyphicon-remove"></i> ${profileMessage}
				</p>
			<%} %>
		<%} %>
		<h3>Profile Information</h3>
		<table class="table table-condensed">
		<tbody>
			<tr>
				<td width="15%">Title</td>
				<td width="3%">:</td>
				<td width="82%">
					<div class="col-md-6"><%=currentUser.getProTitle() %></div>
				</td>
			</tr>
			<tr>
				<td width="15%">Firstname</td>
				<td width="3%">:</td>
				<td width="82%">
					<div class="col-md-6"><%=currentUser.getProFirstName() %></div>
				</td>
			</tr>
			<tr>
				<td width="15%">Lastname</td>
				<td width="3%">:</td>
				<td width="82%">
					<div class="col-md-6"><%=currentUser.getProLastName() %></div>
				</td>
			</tr>
			<tr>
				<td width="15%">Company</td>
				<td width="3%">:</td>
				<td width="82%">
					<div class="col-md-6"><%=currentUser.getProCompanyName() %></div>
				</td>
			</tr>
			<tr>
				<td width="15%">Email</td>
				<td width="3%">:</td>
				<td width="82%">
					<div class="col-md-6"><%=currentUser.getProEmail() %></div>
				</td>
			</tr>
			<tr>
				<td width="15%">Contact No.</td>
				<td width="3%">:</td>
				<td width="82%">
					<div class="col-md-6"><%=currentUser.getProContactNo() %></div>
				</td>
			</tr>
			</tbody>
		</table>
		<div class='col-md-2 text-center'>
			<button id="editBtn" type="button" class="btn btn-primary btn-block">
				<i class="glyphicon glyphicon-pencil"></i> Edit Profile
			</button>
			<button id="backBtn" type="button" class="btn btn-primary btn-block">
				<i class="glyphicon glyphicon-arrow-left"></i> Back
			</button>
		</div>
	</div>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		document.getElementById('editBtn').onclick = function() {
			document.location.href = '${pageContext.request.contextPath}/EditProfileInitAction';
		}
		document.getElementById('changePwdBtn').onclick = function() {
			document.location.href = '${pageContext.request.contextPath}/ChangePasswordInitAction';
		}
		document.getElementById('backBtn').onclick = function(){
			document.location.href = '${pageContext.request.contextPath}/HomeInitAction';
		}
	</script>
</body>
</html>
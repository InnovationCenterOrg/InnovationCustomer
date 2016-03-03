<!DOCTYPE HTML>
<%@page import="com.ibm.innovationcustomer.model.ProfileUserModel"%>
<%@page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.ibm.innovationcustomer.model.EventModel"%>
<%@page import="com.ibm.innovationcustomer.model.RegisterEventModel"%>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<title>IBM Innovation Center</title>
</head>

<body>
	<%	EventModel eventModel = (EventModel) request.getSession().getAttribute("event"); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
		
		ProfileUserModel currentUser = (ProfileUserModel) request.getSession().getAttribute("currentUser");
	%>
	<div class="navbar navbar-static-top">
   		<div class="container">
   			<div>
	   			<a href="HomeInitAction">
					<img style="margin-top: 3%;" align="left" class="img-responsive" src="./images/logo-ibm-white.png" width="20%" height="20%"/>
				</a>
			</div>
			<div>
			  	<a class="btn dropdown-toggle" data-toggle="dropdown" href="#" style="width: 80%">
			    	<img style="margin-top: 3%" align="right" class="img-responsive" src="./images/profile_icon_3.ico" width="13%" height="13%"/>
			 	</a>
			  	<ul class="dropdown-menu  pull-right" role="menu" style="width: 50%">
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
	<h4 align="center">Welcome to IBM Innovation Center</h4>
	Social business is a different way of working. It's about communicating in the open when it's appropriate to do so. It's about having all of your non-private conversations in the open where others can participate and provide their input and advice.
	<br>
	The tools in IBM Connections Cloud make it easy for you to collaborate with people inside and outside your organization. The following list contains some of the tools and applications that are available to you:
	<h5>Event Information</h5>
	
	
	<table class="table table-condensed">
		<tbody>
			<tr>
				<td width="30%">Event Name</td>
				<td width="3%">:</td>
				<td width="67%">
					<div class="col-md-6"><%=eventModel.getEveName() %></div>
				</td>
			</tr>
			<tr>
				<td width="30%">Event Description</td>
				<td width="3%">:</td>
				<td width="67%">
					<div class="col-md-6"><%=eventModel.getEveDescription() %></div>
				</td>
			</tr>
			<tr>
				<td width="30%">Location</td>
				<td width="3%">:</td>
				<td width="67%">
					<div class="col-md-6"><%=eventModel.getEveLocation() %></div>
				</td>
			</tr>
			<tr>
				<td width="30%">Start Date/Time</td>
				<td width="3%">:</td>
				<td width="67%">
					<div class="col-md-6"><%=dateFormat.format(eventModel.getEveStartDate()) %><br></div>
				</td>
			</tr>
			<tr>
				<td width="30%">End Date/Time</td>
				<td width="3%">:</td>
				<td width="67%">
					<div class="col-md-6"><%=dateFormat.format(eventModel.getEveEndDate()) %><br></div>
				</td>
			</tr>
		</tbody>
	</table>
	
	<form method="post" action="GenerateLuckyNoAction" class="form-signin">
	<%if(null != request.getSession().getAttribute("registerEvent")){
		RegisterEventModel regEve = (RegisterEventModel)request.getSession().getAttribute("registerEvent");
		if(regEve.getReeLuckyNo() == 0){
			//Not get lucky no.%>
			<div class='col-md-2 text-center'>
				<button type="submit" class="btn btn-primary btn-block">
					<i class="glyphicon glyphicon-gift"></i> Get Lucky No.
				</button>
			</div>
		<%}else{
			//already get lucky no.%>
			<table>
				<tbody>
					<tr height="10%">
						<td width="20%"><img class="img-responsive" src="images/Gift-512.png" width="70%" height="70%"></td>
						<td width="80%" align="left"><h3><font color="gray"><%=regEve.getReeLuckyNo() %></font></h3></td>
					</tr>
				</tbody>
			</table>
			<!-- <p class="bg-info" align="center" style="height: 20%">
				
			</p> -->
		<% }
	}
	 %>
	 <br><br>
	 </form>
	 
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	</div>
	
	<img class="img-responsive" src="images/footer.png" width="100%">
</body>
</html>


</html>
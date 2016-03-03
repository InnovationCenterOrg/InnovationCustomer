<!DOCTYPE HTML>
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
		<h3>Edit Profile Information</h3>
		<form method="post" action="SaveProfileAction" class="form-signin">
		<table class="table table-condensed">
		<tbody>
			<tr>
				<td width="15%">Title</td>
				<td width="3%">:</td>
				<td width="82%">
					<div class="col-md-6">
					<select class="form-control" name="title" id="title">
						<option value="MR" <%if(currentUser.getProTitle().equals("MR")){%>selected="selected"<%}%>>MR</option>
						<option value="MS" <%if(currentUser.getProTitle().equals("MS")){%>selected="selected"<%}%>>MS</option>
						<option value="MRS" <%if(currentUser.getProTitle().equals("MRS")){%>selected="selected"<%}%>>MRS</option>
					</select>
					</div>
				</td>
			</tr>
			<tr>
				<td width="15%">Firstname</td>
				<td width="3%">:</td>
				<td width="82%">
					<div class="col-md-6">
						<input class="form-control" name="firstname" type="text" id="firstname" value="<%=currentUser.getProFirstName() %>">
					</div>
				</td>
			</tr>
			<tr>
				<td width="15%">Lastname</td>
				<td width="3%">:</td>
				<td width="82%">
					<div class="col-md-6">
						<input class="form-control" type="text" name="lastname" id="lastname" value="<%=currentUser.getProLastName() %>">
					</div>
				</td>
			</tr>
			<tr>
				<td width="15%">Company</td>
				<td width="3%">:</td>
				<td width="82%">
					<div class="col-md-6">
						<input class="form-control" type="text" name="companyName" id="companyName" value="<%=currentUser.getProCompanyName() %>">
					</div>
				</td>
			</tr>
			<tr>
				<td width="15%">Email</td>
				<td width="3%">:</td>
				<td width="82%">
					<div class="col-md-6">
						<input class="form-control" type="text" name="email" id="email" value="<%=currentUser.getProEmail() %>">
					</div>
				</td>
			</tr>
			<tr>
				<td width="15%">Contact No.</td>
				<td width="3%">:</td>
				<td width="82%">
					<div class="col-md-6">
						<input class="form-control" type="text" name="contactNo" id="contactNo" value="<%=currentUser.getProContactNo() %>">
					</div>
				</td>
			</tr>
			</tbody>
		</table>
		<div class='col-md-2 text-center'>
			<button id="saveBtn" type="submit" class="btn btn-primary btn-block" onclick="return validateRequiredField()">
				<i class="glyphicon glyphicon-save"></i> Save
			</button>
			<button id="backBtn" type="button" class="btn btn-primary btn-block">
				<i class="glyphicon glyphicon-arrow-left"></i> Back
			</button>
		</div>
		</form>
	</div>

</div>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	
</body>
<script type="text/javascript">
	
 	function validateRequiredField(){
 		var validate = true;
 		var errorMsg = "";
 		
 		var title = document.getElementById('title').value;
 		var companyName = document.getElementById('companyName').value;
 		var firstname = document.getElementById('firstname').value;
 		var lastname = document.getElementById('lastname').value;
 		var email = document.getElementById('email').value;
 		var contactNo = document.getElementById('contactNo').value;
 		
 		if(title == ''){
 			validate = false;
 			errorMsg = errorMsg.concat("Title is required.\n");
 		}
 		
 		if(companyName == ''){
 			validate = false;
 			errorMsg = errorMsg.concat("Company Name is required.\n");
 		}
 		
 		if(firstname == ''){
 			validate = false;
 			errorMsg = errorMsg.concat("Firstname is required.\n");
 		}
 		
 		if(lastname == ''){
 			validate = false;
 			errorMsg = errorMsg.concat("Lastname is required.\n");
 		}
 		
 		if(email == ''){
 			validate = false;
 			errorMsg = errorMsg.concat("Email is required.\n");
 		}
 		
 		if(contactNo == ''){
 			validate = false;
 			errorMsg = errorMsg.concat("Contact No. is required.\n");
 		}
 	
 		if(!validate){
 			alert(errorMsg);
 			return false;
 		}
 		
 		return true;
 	
 	}
	
	document.getElementById('backBtn').onclick = function(){
		alert('Press Back Btn');
		window.history.back();
	}
	
</script>
</html>
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>IBM Innovation Center</title>
<!-- Bootstrap -->
<link href="css/default.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">

<!--  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  -->

</head>

<body>
	<br>
	<div align="center"><img class="img-responsive" src="images/ibm_logo.png" width="60%" height="60%"/></div>
	<div class="container" style="font-size: small;">
		<h3 align="left">Registration</h3>
		<form method="post" action="RegisterAction" class="form-signin">
			<select class="form-control" name="title" id="title" style="color: #A1AAB1;" onchange="changeTextcolor()">
				<option value="" disabled selected>Title</option>
				<option value="MR">MR</option>
				<option value="MS">MS</option>
				<option value="MRS">MRS</option>
			</select><br>
			<input type="text" class="form-control" id="firstname" name="firstName" placeholder="Firstname"><br>
			<input type="text" class="form-control" id="lastname" name="lastName" placeholder="Lastname"><br>
			<input type="text" class="form-control" id="companyName" name="companyName" placeholder="Company Name"><br>
			<input type="text" class="form-control" id="email" name="email" placeholder="Email"><br>
			<input type="text" class="form-control" id="contactNo" name="contactNo" placeholder="Contact No."><br>
			<input type="text" class="form-control" id="username" name="username" placeholder="Username"><br>
			<input type="text" class="form-control" id="password" name="password" placeholder="Password"><br>
			<input type="text" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Re-Enter Password"><br>
			
			<button type="submit" class="btn btn-primary form-control" onclick="validateRequiredField()">Submit</button><br>
			<div align="center">
				<font style="font-size: x-small;">
					<a href="LoginAction">Login</a><br>
					<a href="#">Forgot Password</a>
				</font>
			</div>
				
		</form>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

	</div>
</body>
</html>
<script type="text/javascript">

	function changeTextcolor(){
		document.getElementById("title").style.color = "#555555";
	}

 	function validateRequiredField(){
 	 	
 		var validate = true;
 		var errorMsg = "";
 		
 		var title = document.getElementById('title').value;
 		var companyName = document.getElementById('companyName').value;
 		var firstname = document.getElementById('firstname').value;
 		var lastname = document.getElementById('lastname').value;
 		var email = document.getElementById('email').value;
 		var contactNo = document.getElementById('contactNo').value;
 		var username = document.getElementById('username').value;
 		var password = document.getElementById('password').value;
 		var confirmPassword = document.getElementById('confirmPassword').value;
 		
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
 	
 		if(username == ''){
 			validate = false;
 			errorMsg = errorMsg.concat("Username is required.\n");
 		}
 		
 		if(password == ''){
 			validate = false;
 			errorMsg = errorMsg.concat("Password is required.\n");
 		}
 		
 		if(confirmPassword == ''){
 			validate = false;
 			errorMsg = errorMsg.concat("Re-Enter Password is required.\n");
 		}
 		if(password != '' && confirmPassword != ''){
 			if(password != confirmPassword){
 				validate = false;
 				errorMsg = errorMsg.concat("Password and Re-Enter Password must be the same.");
 			}
 		}
 		
 		if(!validate){
 			alert(errorMsg);
 			return false;
 		}
 		
 		return true;
 	
 	}
	
</script>

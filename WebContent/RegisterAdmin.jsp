<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>

<!-- Bootstrap CSS -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="Registration.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>

/*Registration CSS*/
@import "font-awesome.min.css";

@import "font-awesome-ie7.min.css";
/* Space out content a bit */
body {
	padding-top: 20px;
	padding-bottom: 20px;
}

/* Everything but the jumbotron gets side spacing for mobile first views */
.header, .marketing, .footer {
	padding-right: 15px;
	padding-left: 15px;
}

/* Custom page header */
.header {
	border-bottom: 1px solid #e5e5e5;
}
/* Make the masthead heading the same height as the navigation */
.header h3 {
	padding-bottom: 19px;
	margin-top: 0;
	margin-bottom: 0;
	line-height: 40px;
}

/* Custom page footer */
.footer {
	padding-top: 19px;
	color: #777;
	border-top: 1px solid #e5e5e5;
}

/* Customize container */
@media ( min-width : 768px) {
	.container {
		max-width: 730px;
	}
}

.container-narrow>hr {
	margin: 30px 0;
}

/* Main marketing message and sign up button */
.jumbotron {
	text-align: center;
	border-bottom: 1px solid #e5e5e5;
}

.jumbotron .btn {
	padding: 14px 24px;
	font-size: 21px;
}

/* Supporting marketing content */
.marketing {
	margin: 40px 0;
}

.marketing p+h4 {
	margin-top: 28px;
}

/* Responsive: Portrait tablets and up */
@media screen and (min-width: 768px) {
	/* Remove the padding we set earlier */
	.header, .marketing, .footer {
		padding-right: 0;
		padding-left: 0;
	}
	/* Space out the masthead */
	.header {
		margin-bottom: 30px;
	}
	/* Remove the bottom border on the jumbotron for visual effect */
	.jumbotron {
		border-bottom: 0;
	}
}

.btn-project {
	font-family: 'Poppins', sans-serif;
	background: #7386D5;
	color: #fff;
	transition: all 0.3s;
}

.btn:hover {
	opacity: 1.5;
}

/*Registration CSS*/
body {
	padding-top: 20px;
	padding-bottom: 20px;
}
/* Everything but the jumbotron gets side spacing for mobile first views */
.header, .marketing, .footer {
	padding-right: 15px;
	padding-left: 15px;
}
/* Custom page header */
.header {
	border-bottom: 1px solid #e5e5e5;
}
/* Make the masthead heading the same height as the navigation */
.header h3 {
	padding-bottom: 19px;
	margin-top: 0;
	margin-bottom: 0;
	line-height: 40px;
}
/* Custom page footer */
.footer {
	padding-top: 19px;
	color: #777;
	border-top: 1px solid #e5e5e5;
}
/* Customize container */
@media ( min-width : 768px) {
	.container {
		max-width: 730px;
	}
}

.container-narrow>hr {
	margin: 30px 0;
}
/* Main marketing message and sign up button */
.jumbotron {
	text-align: center;
	border-bottom: 1px solid #e5e5e5;
}

.jumbotron .btn {
	padding: 14px 24px;
	font-size: 21px;
}
/* Supporting marketing content */
.marketing {
	margin: 40px 0;
}

.marketing p+h4 {
	margin-top: 28px;
}
/* Responsive: Portrait tablets and up */
@media screen and (min-width: 768px) {
	/* Remove the padding we set earlier */
	.header, .marketing, .footer {
		padding-right: 0;
		padding-left: 0;
	}
	/* Space out the masthead */
	.header {
		margin-bottom: 30px;
	}
	/* Remove the bottom border on the jumbotron for visual effect */
	.jumbotron {
		border-bottom: 0;
	}
}

.btn-project {
	font-family: 'Poppins', sans-serif;
	background: #7386D5;
	color: #fff;
	transition: all 0.3s;
}

.btn:hover {
	opacity: 1.5;
}
</style>

</head>
<body>

	<%
		java.util.Date date = new java.util.Date();
		String fDate = new java.text.SimpleDateFormat("dd-MM-yyyy").format(date);
	%>

	<!-- Navigation Bar -->
	<div>
		<nav class="navbar navbar-expand-lg navbar-light bg-light ">
			<div class="navbar-header">
				<a href="home" class="navbar-brand"><p
						style="font-size: 30px; color: black; text-shadow: 5px 5px 10px grey;">PatientX</p></a>
			</div>
		</nav>
	</div>

	<!-- Navigation Bar -->

	<!-- Registration Form -->

	<div class="container">
		<h2 class="well">Admin Registration Form</h2>
		<div class="col-lg-12 well">
			<div class="row">

				<form:form action="registerAdmin" method="post"
					modelAttribute="admin">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">

								<label>First Name</label>
								<form:input path="firstName" type="text"
									placeholder="First Name" class="form-control" name="first-name"
									maxlength="20" required="required" />
							</div>
							<div class="col-sm-6 form-group">
								<label>Last Name</label>
								<form:input path="lastName" type="text" placeholder="Last Name"
									class="form-control" name="last-name" maxlength="20"
									required="required" />
							</div>
						</div>

						<div class="row">
							<div class="col-sm-4 form-group">
								<label>Age</label>
								<form:input path="age" type="number" placeholder="Age"
									class="form-control" min="1" max="130" name="age" maxlength="3"
									required="required" />
							</div>
							<div class="col-sm-4 form-group">
								<div class="form-group">
									<label for="gender">Gender</label>
									<form:select path="gender" class="form-control" id="gender"
										name="gender">
										<form:option value="Male">Male</form:option>
										<form:option value="Female">Female</form:option>
									</form:select>
								</div>
							</div>

							<div class="col-sm-4 form-group">
								<label>Date of Birth</label>
								<form:input path="dateOfBirth" type="date"
									placeholder="Date of Birth (dd-mm-yyyy)" class="form-control"
									max="<%=fDate%>" name="dob" required="required" />
							</div>
						</div>

						<div class="form-group">
							<label>Contact Number</label>
							<form:input path="contactNumber" type="text"
								placeholder="Contact Number" class="form-control" name="contact"
								pattern="[0-9]{10,}"
								title="Don't begin with '0', should contain '10' digits only"
								maxlength="10" required="required" />
						</div>
						<div class="form-group">
							<label>Alternate Contact Number (Enter '0' if not required)</label>
							<form:input path="alternateContactNumber" type="number"
								placeholder="Alternate Contact Number (if any)"
								class="form-control" name="altcontact" pattern="[0-9]{10,}"
								title="Don't include '0', should contain '10' digits only"
								maxlength="10" />
						</div>

						<div class="form-group">
							<label>Email Address</label>
							<form:input path="emailId" type="email" placeholder="Email ID"
								class="form-control" name="email" maxlength="25"
								required="required" />
						</div>

						<div class="form-group">
							<label for="pass">Password</label>
							<form:input path="password" type="password"
								placeholder="Enter New Password" class="form-control"
								name="pass" required="required" id="password"
								pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
								title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
								maxlength="20" />
						</div>

						<div class="form-group">
							<label for="cfnpass">Confirm Password</label>
							<form:input path="confirmPassword" type="password"
								placeholder="Confirm Password " class="form-control"
								name="cfnpass" required="required" id="confirmPassword"
								onChange="isPasswordMatch();" />
							<div id="divCheckPassword"></div>
						</div>

<!-- 						<div class="col-md-12">
							<div class="checkbox">
								<label> <input type="checkbox" value="" id="" /> I
									accept the <a href="#">terms and conditions</a>.
								</label>
							</div>
						</div> -->
					</div>

					<div class="form-group">
						<div class="col-md-12">
							<button type="submit" class="btn btn-project"
								name="registerAdmin">Register</button>
							<a href="">Already have an account?</a>
						</div>
					</div>
				</form:form>

			</div>

		</div>
	</div>

	<!-- Registration Form -->

	<script type="text/javascript">
		$('#confirmPassword').on(
				'keyup',
				function() {
					var password = $("#password").val();
					var confirmPassword = $("#confirmPassword").val();
					if (password != confirmPassword)
						$("#divCheckPassword").html("Passwords do not match!")
								.css('color', 'red');
					else
						$("#divCheckPassword").html("Passwords match.").css(
								"color", "green");
				});
		
		$("#my-form").submit(function() {
		    $(this).find(":input").filter(function () {
		        return !this.value;
		    }).attr("disabled", true);

		    return true;
		});
	</script>

</body>
</html>
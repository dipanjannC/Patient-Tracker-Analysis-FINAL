<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style>
/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px;
	margin: 3px 0 10px 0;
	border: none;
	background: #f1f1f1;
	border-radius: 50px;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}
/* Set a style for the submit button */
.btn-project {
	font-family: 'Poppins', sans-serif;
	background: #7386D5;
	color: #fff;
	transition: all 0.3s;
	border-radius: 80px;
}

.btn:hover {
	opacity: 1.5;
}
/* Set a style for the submit button */
</style>
</head>
<body>
	<%
		if (request.getAttribute("success") != null) {
			//request.removeAttribute("success");
	%>

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		swal('WELCOME ADMIN !!', "Your ID : ${id}", 'success')
	</script>

	<%
		}
	%>

	<%
		if (request.getAttribute("failure") != null) {
	%>

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		swal('OOPS !!', "Invalid Username or Password...", 'error')
	</script>

	<%
		}
	%>

	<!-- Navigation Bar -->
	<div>
		<nav class="navbar navbar-expand-lg navbar-light bg-light ">
			<div class="navbar-header">
				<a href="#" class="navbar-brand"></a>
			</div>


			<form:form class="form-inline ml-auto" action="loginAdmin"
				method="POST" modelAttribute="admin">

				<form:input class="form-control mr-sm-1 mb-2" type="text"
					placeholder="Username" pattern="ADN+[0-9]{1,}$"
					title="e.g., ADN1001" name="id" path="adminId" maxlength="13"
					required="required" />

				<form:input class="form-control mr-sm-1 mb-2" type="password"
					placeholder="Password" name="password" path="password"
					maxlength="20" required="required" />

				<form:button class="btn btn-project mr-sm-1 " name="loginAdmin">Login</form:button>
			</form:form>
			<a href="adminRegistration" class="btn btn-project" role="button">Register</a>

		</nav>
	</div>

	<!-- Navigation Bar -->

	<!-- Company -->
	<div class="jumbotron text-center">
		<h1>PatientX</h1>
		<p>Resize this responsive page to see the effect!</p>
	</div>
	<!-- Company -->

	<!-- Content -->
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<h3>Services</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
				<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
					laboris...</p>
			</div>
			<div class="col-sm-4">
				<h3>Customers</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
				<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
					laboris...</p>
			</div>
			<div class="col-sm-4">
				<h3>About Us</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
				<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
					laboris...</p>
			</div>
		</div>
	</div>
	<!-- Content -->
</body>
</html>
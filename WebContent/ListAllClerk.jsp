<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.pta.model.ClerkPOJO"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Clerks</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="Dashboard.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<style>

/*Common Dashboard CSS*/
@import
	"https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";

body {
	font-family: 'Poppins', sans-serif;
	background: #fafafa
}

p {
	font-family: 'Poppins', sans-serif;
	font-size: 1.1em;
	font-weight: 300;
	line-height: 1.7em;
	color: #0a0a0f;
}

a, a:hover, a:focus {
	color: inherit;
	text-decoration: none;
	transition: all 0.3s;
}

.navbar {
	padding: 15px 10px;
	background: #fff;
	border: none;
	border-radius: 0;
	margin-bottom: 40px;
	box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1);
}

.navbar-btn {
	box-shadow: none;
	outline: none !important;
	border: none;
}

.line {
	width: 100%;
	height: 1px;
	border-bottom: 1px dashed #ddd;
}

#sidebar {
	min-width: 250px;
	max-width: 250px;
	background: #7386D5;
	color: #fff;
	transition: all 0.3s;
	height: 100;
}

#sidebar.active {
	margin-left: -250px;
}

#sidebar .sidebar-header {
	padding: 20px;
	background: #6d7fcc;
}

#sidebar ul.components {
	padding: 20px 0px;
	border-bottom: 1px solid #47748b;
}

#sidebar ul p {
	padding: 10px;
	font-size: 1.1em;
	display: block;
}

#sidebar ul li a {
	padding: 10px;
	font-size: 1.1em;
	display: block;
}

#sidebar ul li a:hover {
	color: #7386D5;
	background: #fff;
}

#sidebar ul li.active>a, a[aria-expanded="true"] {
	color: #fff;
	background: #6d7fcc;
}

a[data-toggle="collapse"] {
	position: relative;
}

.dropdown-toggle::after {
	display: block;
	position: absolute;
	top: 50%;
	right: 20px;
	transform: translateY(-50%);
}

ul ul a {
	font-size: 0.9em !important;
	padding-left: 30px !important;
	background: #6d7fcc;
}

ul.CTAs {
	padding: 20px;
}

ul.CTAs a {
	text-align: center;
	font-size: 0.9em !important;
	display: block;
	border-radius: 5px;
	margin-bottom: 5px;
}

a.download {
	background: #fff;
	color: #7386D5;
}

a.article, a.article:hover {
	background: #6d7fcc !important;
	color: #fff !important;
}

#content {
	width: 100%;
	padding: 20px;
	min-height: 100vh;
	transition: all 0.3s;
}

@media ( maz-width :768px) {
	#sidebar {
		margin-left: -250px;
	}
	#sidebar.active {
		margin-left: 0px;
	}
	#sidebarCollapse span {
		display: none;
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
/*Common Dashboard CSS*/
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 10px;
}

.bg {
	background: #7386D5;
}

input[type=text], input[type=number], input[type=textarea], input[type=date],
	input[type=email] {
	width: 100%;
	padding: 12px 20px;
	background: transparent;
	border: none;
}
</style>

</head>

<body>

	<%
		if (request.getAttribute("success") != null) {
	%>

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		swal('WELCOME CLERK !!', "Your ID : ${clerkId}", 'success')
	</script>

	<%
		}
	%>

	<%
		if (request.getAttribute("update") != null) {
	%>

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		swal('SUCCESSFULLY UPDATED !!', "Your ID : ${clerkId}", 'success')
	</script>

	<%
		}
	%>


	<!--Navigation Bar-->
	<nav class="navbar navbar-expand-lg navbar-light "
		style="background: #ebeef9;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="dashboard" class="navbar-brand">PatientX</a>
			</div>

		</div>
		<div align="right">
			<form class="navbar-form navbar-right">
				<button type="button" class="btn btn-project" data-toggle="modal"
					data-target="#logoutModal">Logout</button>
			</form>
		</div>

	</nav>
	<!--Navigation Bar-->

	<div class="d-flex mb-2 align-content-stretch">


		<div class="p-1 bg mr-2" style="border-radius: 5px;">

			<nav id="sidebar"
				style="box-shadow: 0px 20px 50px grey; border-radius: 25px;">
				<div class="sidebar-header">
					<h5>
						Hi
						<%=session.getAttribute("name")%>,
					</h5>
				</div>


				<ul class="list-unstyled components">
				<!-- 	<p>Management</p>
					<li class="active"><a href="#homeSubmenu"
						data-toggle="collapse" aria-expanded="false"
						class="dropdown-toggle">Home</a>
						<ul class="collapse list-unstyled" id="homeSubmenu">
							<li><a href="#">home1</a></li>
							<li><a href="#">home2</a></li>
							<li><a href="#">home3</a></li>
						</ul></li -->>

					<li><a href="listAllClerk">Clerk</a></li>
					<li><a href="listAllDoctor">Doctor</a></li>
					<li><a href="listAllPatient">Patient</a></li>
					<li><a href="listAllMedicine">Medicine</a></li>
					<li><a href="listAllPrescription">Prescription</a></li>
					<li><a href="listAllBill">Bill</a></li>
					<li><a href="#pageSubmenu" data-toggle="collapse"
						aria-expanded="false" class="dropdown-toggle">About Us</a>
						<ul class="collapse list-unstyled" id="pageSubmenu">
							<li><a href="#">Developer 1</a></li>
							<li><a href="#">Developer 2</a></li>
							<li><a href="#">Developer 3</a></li>
							<li><a href="#">Developer 4</a></li>
							<li><a href="#">Developer 5</a></li>
						</ul></li>
				</ul>

				<ul class="list-unstyled CTAs">
					<li><a href="#" class="download">Download code</a></li>
					<li><a href="#" class="article">article</a></li>
				</ul>

			</nav>


		</div>



		<div class="p-1 flex-grow-1">

			<nav class="navbar navbar-expand-lg navbar-light bg-light "
				style="box-shadow: 0px 15px 50px 5px grey; border-radius: 5px;">

				<button type="button" id="sidebarCollapse"
					class="btn btn-project rounded-circle">
					<i class="fa fa-align-justify"></i> <span></span>
				</button>

				<!--<a class="navbar-brand" href="#">Navbar</a> -->
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link" href="#">Home
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Services</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">Appointments</a>
						</li>
						<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
						</li>
					</ul>
				</div>
			</nav>

			<div class="container">
				<div class="card" style="box-shadow: 0px 20px 50px grey;">
					<div class="card-header" style="background: #eaeafb;">Clerk</div>
					<div class="card-body">


						<!-- Search and Add -->
						<div class="container-fluid">
							<div class="row">

								<!-- Search Bar-->
								<div class="col-8">

									<input class="form-control" id="input" type="text"
										placeholder="Search"
										style="background: #ececf9; border-radius: 80px;" />

								</div>


								<!-- Search Bar -->

								<!-- Add Product Button -->
								<div class="col-4">
									<div align="right">

										<a href="clerkAddition" role="button""> <i
											class="material-icons" style="font-size: 40px;">add_circle
										</i>
										</a>
									</div>
								</div>
								<!-- Add Product Button -->
							</div>
						</div>
						<!-- Search and Add -->
						<br>

						<div class="table-responsive" style="background: #f0e8f7">
							<table id="table" class="table table-bordred table-striped">
								<thead>
									<th>Clerk ID</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>State</th>
									<th>Email</th>
									<th>Contact</th>
									<th>Edit</th>
									<%
										ArrayList clerkDetails = (ArrayList) request.getAttribute("clerkDetails");
										Iterator iterator = clerkDetails.iterator();
										while (iterator.hasNext()) {
											ClerkPOJO pojo = (ClerkPOJO) iterator.next();
									%>
								</thead>
								<tbody id="table">
									<tr>
										<td><a href="viewClerkDetails?id=<%=pojo.getClerkId()%>"
											class="btn btn-basic" role="button"><%=pojo.getClerkId()%></a></td>
										<td><%=pojo.getFirstName()%></td>
										<td><%=pojo.getLastName()%></td>
										<td><%=pojo.getState()%></td>
										<td><%=pojo.getEmailId()%></td>
										<td><%=pojo.getContactNumber()%></td>
										<td><a href="clerkUpdation?id=<%=pojo.getClerkId()%>"
											role="button"><i class="material-icons">mode_edit</i></a></td>

										<%
											}
										%>


									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="card-footer"></div>
				</div>
			</div>
		</div>
	</div>
	<!--Logout Modal-->
	<div class="modal fade" id="logoutModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Logout</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<!--Update Modal-->
				<div class="modal-body">
					<hr>
					Are you Sure? <br>
					<hr>
					<form action="logout" method="post">
						<input type="submit" name="logout-option" value="Yes"
							class="btn btn-content btn-block" /> <br>
					</form>
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!--Logout Modal-->
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			$('#sidebarCollapse').on('click', function() {
				$('#sidebar').toggleClass('active');
			});
		});

		$(document)
				.ready(
						function() {
							$("#input")
									.on(
											"keyup",
											function() {
												var value = $(this).val()
														.toLowerCase();
												$("#table tr")
														.filter(
																function() {
																	$(this)
																			.toggle(
																					$(
																							this)
																							.text()
																							.toLowerCase()
																							.indexOf(
																									value) > -1)
																});
											});
						});
	</script>
</body>
</html>
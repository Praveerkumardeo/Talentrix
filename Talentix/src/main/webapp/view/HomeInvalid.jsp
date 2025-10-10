<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>JobPortal</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/css/main.css" />
</head>
<body>
	<header class="navbar">
		<div class="logo">
			<img src="https://cdn-icons-png.flaticon.com/512/709/709579.png"
				alt="logo" class="logo-icon"> <span>JobPortal</span>
		</div><!-- 
		<nav>
			<ul class="nav-links">
				<li><a href="#" class="active">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/view/jobs.jsp">Find Jobs</a></li>
				<li><a href="${pageContext.request.contextPath}/view/companies.jsp">Companies</a></li>
				<li><a href="${pageContext.request.contextPath}/view/about.jsp">About</a></li> 
			</ul>
		</nav>-->
		<div class="nav-buttons">
			<button class="sign-in" id="openSignIn">Login</button>
			<button class="post-job" id="openSignUp">Sign Up</button>
		</div>
	</header>

	<section class="hero">
		<p class="tagline">🚀 Over 10,000+ jobs available</p>
		<h1>Find Your Dream Job Today</h1>
		<p class="subtitle">Discover amazing opportunities from top
			companies around the world</p>



	
	</section>


	<!-- Modal Popup -->
	<div class="modal" id="authModal">
		<div class="modal-content">
			<span class="close" id="closeModal">&times;</span>
			<div class="modal-header">
				<img src="https://cdn-icons-png.flaticon.com/512/709/709579.png"
					alt="logo" class="modal-logo">
				<h2>Welcome to JobPortal</h2>
				<p>Sign in to your account or create a new one to get started</p>
				<h1>Invalid data</h1>
			</div>

			<div class="tab-buttons">
				<button class="tab-btn active" id="tabSignIn">Login</button>
				<button class="tab-btn" id="tabUserSignUp">Register User</button>
				<button class="tab-btn" id="tabEmployerSignUp">Register
					Employer</button>
			</div>

			<!-- Login Form -->
			<form id="signInForm" class="form active" action="/api/auth/login"
				method="post">
				
				<label>Email</label> <input type="email" name="email"
					placeholder="you@example.com" required> <label>Password</label>
				<input type="password" name="password" placeholder="••••••••"
					required>

				<button type="submit" class="submit-btn">Login</button>
			</form>

			<!-- Register User Form -->
			<form id="userSignUpForm" class="form" action="/api/auth/registerUser"
				method="post">
				<label>Full Name</label> <input type="text" name="name"
					placeholder="John Doe" required> <label>Email</label> <input
					type="email" name="email" placeholder="you@example.com" required>

				<label>Phone</label> <input type="text" name="phoneNumber"
					placeholder="xxxxxxxxxx" required> <label>Password</label>
				<input type="password" name="password"
					placeholder="Create a password" required>

				<button type="submit" class="submit-btn">Register User</button>
			</form>

			<!-- Register Employer Form -->
			<form id="employerSignUpForm" class="form" action="/api/auth/registerEmployer"
				method="post">
				
				<label>Employer Name</label> <input type="text" name="name"
					placeholder="Your name" required> 
				
				<label>Company Name</label> <input type="text" name="companyName"
					placeholder="TechCorp Pvt Ltd" required> 
					
				<label>Email</label>
				<input type="email" name="email" placeholder="company@example.com"
					required> 
					
					<label>Phone</label> 
					<input type="text" name="phoneNumber" placeholder="xxxxxxxxxx" required> <label>Password</label>
					
				<input type="password" name="password" splaceholder="Create a password" required>

				<button type="submit" class="submit-btn">Register Employer</button>
			</form>
		</div>
	</div>
	s

	<script src="${pageContext.request.contextPath}/view/js/main.js"></script>
</body>
</html>

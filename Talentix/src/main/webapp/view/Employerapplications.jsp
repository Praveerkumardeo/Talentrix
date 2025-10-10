<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Employer Dashboard - Applications</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/css/Employerapplication.css" />
</head>
<body>
	<div class="sidebar">
		<h2 class="logo">Employer Dashboard</h2>
		<ul>
			        <li class="active"><a href="${pageContext.request.contextPath}//employer">My Jobs</a></li>
        <li><a href="${pageContext.request.contextPath}/employerApplications">Applications</a></li>
		</ul>
		<button class="back-btn"
			onclick="window.location.href='${pageContext.request.contextPath}/'">
			Back to Portal</button>

		<button class="signout-btn"
			onclick="window.location.href='${pageContext.request.contextPath}/logout'">
			Sign Out</button>
	</div>
	

	<div class="main-content">
		<header>
			<div>
				<h1>Applications Received</h1>
			</div>
			<div class="filter">
				<label for="statusFilter">Filter by status:</label> <select
					id="statusFilter">
					<option value="all">All Status</option>
					<option value="reviewing">Reviewing</option>
					<option value="shortlisted">Shortlisted</option>
					<option value="pending">Pending</option>
					<option value="accepted">Accepted</option>
					<option value="rejected">Rejected</option>
				</select>
			</div>
		</header>

		<table>
			<thead>
				<tr>
					<th>Applicant</th>
					<th>Job Title</th>
					<th>Applied Date</th>
					<th>Status</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody id="applicationsTableBody">
				<!-- Filled by JS -->
			</tbody>
		</table>
	</div>

	<script
		src="${pageContext.request.contextPath}/view/js/Employerapplications.js"></script>
</body>
</html>

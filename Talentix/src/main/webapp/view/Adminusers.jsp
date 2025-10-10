<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Admin Dashboard - User Management</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/css/Adminusers.css" />
</head>
<body>
	<div class="sidebar">
		<h2 class="logo">Admin Dashboard</h2>
		<ul>
			<!-- <li><a href="#">Analytics</a></li> -->
			<li><a href="${pageContext.request.contextPath}//adminUser">Users</a></li>
      <li class="active"><a href="${pageContext.request.contextPath}/AdminJobs">Jobs</a></li>
      <li><a href="${pageContext.request.contextPath}/view/Adminapplication.jsp">Applications</a></li>
		</ul>
		<button class="back-btn"
			onclick="window.location.href='${pageContext.request.contextPath}/view/Home.jsp'">
			Back to Portal</button>

		<button class="signout-btn"
			onclick="window.location.href='${pageContext.request.contextPath}/logout'">
			Sign Out</button>

	</div>

	<div class="main-content">
		<header>
			<h1>User Management</h1>
			<!-- <p><a href="#" class="manage-link">Manage all registered users</a></p> -->
		</header>

		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Role</th>
					<th>Joined</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody id="userTableBody">
				<!-- Users dynamically loaded from adminusers.js -->
			</tbody>
		</table>
	</div>

	<script src="${pageContext.request.contextPath}/view/js/Adminusers.js"></script>
</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Admin Dashboard - Job Management</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/Admin.css" />
</head>
<body>
  <div class="sidebar">
    <h2 class="logo">Admin Dashboard</h2>
    <ul>
      <!-- <li><a href="#">Analytics</a></li> -->
      <li><a href="${pageContext.request.contextPath}/view/Adminusers.jsp">Users</a></li>
      <li class="active"><a href="${pageContext.request.contextPath}/view/Admin.jsp">Jobs</a></li>
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
      <h1>Job Management</h1>
      <p><a href="#" class="manage-link">Manage all job postings</a></p>
      <button id="addJobBtn">+ Add Job</button>
    </header>

    <table>
      <thead>
        <tr>
          <th>Title</th>
          <th>Company</th>
          <th>Location</th>
          <th>Type</th>
          <th>Category</th>
          <th>Posted</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody id="jobTableBody">
        <!-- Rows inserted by admin.js -->
      </tbody>
    </table>
  </div>

  <script src="${pageContext.request.contextPath}/view/js/admin.js"></script>
</body>
</html>

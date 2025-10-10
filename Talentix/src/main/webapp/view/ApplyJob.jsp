<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Applied Jobs</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/appliedJobs.css" />

</head>
<body>
	 <div class="container">
    <h1>🧾 Applied Jobs</h1>
    <p class="subtitle">Here are the jobs you’ve applied for</p>

    <div id="appliedJobsContainer" class="jobs-list"></div>
    <p id="emptyMessage" class="empty-message">You haven’t applied for any jobs yet!</p>

    <!-- 🔙 Back to Home Button -->
    <button id = "homeButton" class="home-bt" onclick= "window.location.href='${pageContext.request.contextPath}/userlanding'">🏠 Back to Home</button>
    
  </div>

  <script src="${pageContext.request.contextPath}/view/js/appliedJobs.js"></script>
</body>
</html>
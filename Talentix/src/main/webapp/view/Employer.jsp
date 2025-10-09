<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Employer Dashboard - Job Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/Employer.css" />
  </head>

  <body>
    <div class="sidebar">
      <h2 class="logo">Employer Dashboard</h2>
      <ul>
        <li class="active"><a href="${pageContext.request.contextPath}/view/employer.jsp">My Jobs</a></li>
        <li><a href="${pageContext.request.contextPath}/view/Employerapplications.jsp">Applications</a></li>

      </ul>
      <button class="back-btn" onclick="window.location.href='${pageContext.request.contextPath}/'">
        Back to Portal</button>

      <button class="signout-btn" onclick="window.location.href='${pageContext.request.contextPath}/logout'">
        Sign Out</button>
        
        
    </div>




    <div class="main-content">

      <h1>My Job Listings</h1>
      <button onclick="window.location.href='${pageContext.request.contextPath}/view/Addjob.jsp'">+ Add Job</button>

        <div>
      <section class="jobs-list" id="jobsList">
      <!-- Job cards will load here dynamically -->
    </section>
    </div>

    </div>

  

    

    <script src="${pageContext.request.contextPath}/view/js/Employer.js"></script>

  </body>

  </html>
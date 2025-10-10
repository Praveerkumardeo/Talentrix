<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>User Dashboard - JobPortal</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/userlanding.css" />
</head>
<body>
  <header class="navbar">
    <div class="logo">
      <img src="https://cdn-icons-png.flaticon.com/512/709/709579.png" alt="logo" class="logo-icon">
      <span>JobPortal</span>
    </div>

    <nav>
      <ul class="nav-links">
        <li><a href="#" class="active">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/jobs">Find Jobs</a></li>
        <li><a href="${pageContext.request.contextPath}/companies">Companies</a></li>
        <li><a href="${pageContext.request.contextPath}/about">About</a></li>
      </ul>
    </nav>

    <div class="nav-buttons">
      <button class="username-btn" id="userNameBtn">Hi</button>
      <img src="https://cdn-icons-png.flaticon.com/512/1077/1077063.png" alt="User Icon" class="user-icon" id="userIcon">
    </div>
  </header>

  <section class="hero">
    <p class="tagline">🌟 Welcome back!</p>
    <h1>Continue Your Job Hunt</h1>
    <p class="subtitle">Find your next opportunity from thousands of new listings</p>

    <div class="search-bar">
      <input type="text" id="searchInput" placeholder="🔍 Search for jobs, companies, or keywords">
      <button id="searchBtn">Search</button>
    </div>

    <div class="popular">
      <span>Popular searches:</span>
      <button class="pill">Frontend</button>
      <button class="pill">Backend</button>
      <button class="pill">AI/ML</button>
      <button class="pill">Product Design</button>
    </div>
  </section>

  <!-- Dropdown Menu for User -->
  <div class="dropdown-menu" id="userDropdown">
    <ul>
      <li><a href="${pageContext.request.contextPath}/updateProfilePage">Edit Profile</a></li>
      <li><a href="${pageContext.request.contextPath}/changePasswordPage">Change Password</a></li>
      <li><a href="${pageContext.request.contextPath}/appliedJobs">Applied Jobs</a></li>
      <li><a href="${pageContext.request.contextPath}/api/auth/logout">Logout</a></li>
    </ul>
  </div>

  <script src="${pageContext.request.contextPath}/view/js/userlanding.js"></script>
</body>
</html>

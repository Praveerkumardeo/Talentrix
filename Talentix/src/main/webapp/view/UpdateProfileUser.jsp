<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Update Profile - Employer Panel</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/update.css" />
</head>
<body>
  <div class="container">
    <h1>Update Profile</h1>

    <form action="/api/profile/updateProfile" method="post">
    <label>Name:</label>
    <input type="text" name="name" placeholder="Enter your name">

    <label>Phone Number:</label>
    <input type="number" name="phoneNumber" placeholder="Enter phone number">

    <label>Resume Link:</label>
    <input type="text" name="resume" placeholder="Enter resume Link">

    <input type="submit" value="Update Profile">
</form>
  </div>

  <script src="${pageContext.request.contextPath}/view/js/update.js"></script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Update Profile - Employer Panel</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/impcss/update.css" />
</head>
<body>
  <div class="container">
    <h1>Update Profile</h1>

    <!-- <form id="updateForm" action="/updateProfile" method="post">

      <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" placeholder="Enter your name" required />
      </div>

      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" placeholder="Enter your email" required />
      </div>

      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="Enter new password" required />
      </div>

      <div class="form-group">
        <label for="phoneNumber">Phone Number:</label>
        <input type="number" id="phoneNumber" name="phoneNumber" placeholder="Enter phone number" required />
      </div>

      <div class="form-group">
        <label for="companyName">Company Name:</label>
        <input type="text" id="companyName" name="companyName" placeholder="Enter company name" required />
      </div>

      <div class="form-group">
        <label for="resume">Resume ID (optional):</label>
        <input type="text" id="resume" name="resume" placeholder="Enter resume ID" />
      </div>

      <div class="form-buttons">
        <button type="submit" class="btn">Update Profile</button>
        <button type="button" class="btn cancel" id="cancelBtn">Cancel</button>
      </div>
    </form> -->


    <form action="/updateProfile" method="post">
    <label>Name:</label>
    <input type="text" name="name" placeholder="Enter your name">

    <label>Email:</label>
    <input type="email" name="email" placeholder="Enter your email">

    <label>Password:</label>
    <input type="password" name="password" placeholder="Enter new password">

    <label>Phone Number:</label>
    <input type="number" name="phoneNumber" placeholder="Enter phone number">

    <label>Company Name:</label>
    <input type="text" name="companyName" placeholder="Enter company name">

    <label>Resume ID (optional):</label>
    <input type="text" name="resume" placeholder="Enter resume ID">

    <input type="submit" value="Update Profile">
</form>
  </div>

  <script src="${pageContext.request.contextPath}/view/js/update.js"></script>
</body>
</html>

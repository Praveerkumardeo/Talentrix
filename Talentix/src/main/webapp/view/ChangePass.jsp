<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
      <h1>Change Password</h1>

      <form action="/api/auth/changePassword" method="post" onsubmit="return validatePassword()">


        <label for="oldPass">Old Password</label>
        <input type="password" id="oldPass" name="oldPass" placeholder="Enter your old password" required>

        <label for="newPass">New Password</label>
        <input type="password" id="newPass" name="newPass" placeholder="Enter new password" required>

        <label for="confirmPass">Re-Enter New Password</label>
        <input type="password" id="confirmPass" name="confirmPass" placeholder="Re-enter new password" required>

        <p id="errorMsg" style="color:red; display:none;">⚠️ Passwords do not match.</p>

        <input type="submit" value="Change Password">
      </form>
    </div>

    <script src="${pageContext.request.contextPath}/view/js/update.js"></script>
  </body>

  </html>
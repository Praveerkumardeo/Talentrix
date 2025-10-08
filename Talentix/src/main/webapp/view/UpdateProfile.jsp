<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Profile</title>

</head>
<body>
<h2>Update Profile</h2>
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
</body>
</html>

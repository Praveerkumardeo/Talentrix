<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding = "UTF-8"%>

<!DOCTYPE html>

<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1" />
  <title>Register</title>
</head>
<body>
  <main class="card" role="main">
    <h1>Create an account</h1>
    <p class="lead">Enter your details to register.</p>

<form action="/registerUser" method="post">
  <input type="text" name="name" placeholder="Name">
  <input type="email" name="email" placeholder="Email">
  <input type="password" name="password" placeholder="Password">
  <input type="text" name="phone" placeholder="Phone">
  <button type="submit">Register</button>
  <button type="button" onclick="window.location.href='/login'">For Login</button>

</form>


  </main>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding = "UTF-8"%>

<!DOCTYPE html>

<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1" />
  <title>Login</title>
</head>
<body>
  <main class="card" role="main">
    <h1>Login</h1>
    <p class="lead">Enter your details.</p>

<form action="/api/auth/login" method="post">
  <input type="email" name="email" placeholder="Email">
  <input type="password" name="password" placeholder="Password">
  <button type="submit">Login</button>
  <button type="button" onclick="window.location.href='/'">For Register</button>

</form>
  </main>

</body>
</html>

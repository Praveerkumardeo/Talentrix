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
    <h1>Send mail</h1>
    <p class="lead">Enter your details.</p>

<form action="notification" method="post">
 <input type="text" name="userId" placeholder="User ID">
  <input type="text" name="message" placeholder="message">
  <button type="submit">Send</button>


</form>
  </main>

</body>
</html>

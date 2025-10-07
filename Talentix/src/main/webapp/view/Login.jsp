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

    <form id="registerForm" action="register" method="post" novalidate>

      <div class="field">
        <label for="email">Email</label>
        <input id="email" name="email" type="email" autocomplete="email" required placeholder="you@example.com" />
        <div class="error" id="emailError">Please enter a valid email address.</div>
      </div>


      <div class="field">
        <label for="password">Password</label>
        <div class="row">
          <input id="password" name="password" type="password" autocomplete="new-password" required minlength="8" placeholder="At least 8 characters" />
          <button type="button" class="toggle-pass" id="togglePassword" aria-pressed="false">Show</button>
        </div>
        <div class="note">Use 8 or more characters. Avoid common words.</div>
        <div class="error" id="passwordError">Password must be at least 8 characters.</div>
      </div>

      <div class="actions">
        <button class="primary" type="submit">Login</button>
        <button class="secondary" type="button" onclick="document.getElementById('registerForm').reset();">Reset</button>
      </div>
    </form>
  </main>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Add Job - Employer Panel</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/Addjob.css" />
</head>
<body>
  <div class="container">
    <h1>Add New Job Posting</h1>

    <form action="/api/jobs/create" method="post">
        <label for="title">Job Title:</label>
        <input type="text" id="title" name="title" required>
        <br><br>

        <label for="description">Job Description:</label>
        <textarea id="description" name="description" rows="4" required></textarea>
        <br><br>

        <label for="location">Location:</label>
        <input type="text" id="location" name="location" required>
        <br><br>

        <label for="type">Job Type:</label>
        <select id="type" name="type" required>
            <option value="">Select type</option>
            <option value="Full-time">Full-time</option>
            <option value="Part-time">Part-time</option>
            <option value="Contract">Contract</option>
            <option value="Internship">Internship</option>
        </select>
        <br><br>

        <label for="numberOfPositions">Number of Positions:</label>
        <input type="number" id="numberOfPositions" name="numberOfPositions" min="1" required>
        <br><br>

        <label for="salary">Salary (₹):</label>
        <input type="number" id="salary" name="salary" min="0" step="0.01" required>
        <br><br>

        <label for="deadline">Application Deadline:</label>
        <input type="date" id="deadline" name="deadline" required>
        <br><br>

        <label for="skill">Required Skills (comma-separated):</label>
        <input type="text" id="skill" name="skill">
        <br><br>

        <label for="categories">Categories (comma-separated):</label>
        <input type="text" id="categories" name="categories">
        <br><br>

        <button type="submit">Save Job</button>
    </form>


    
  </div>

  <script src="${pageContext.request.contextPath}/view/js/Addjob.js"></script>
</body>
</html>

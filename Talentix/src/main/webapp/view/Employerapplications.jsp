<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Applicants - JobPortal</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/jobs.css" />
</head>
<body>
  <header class="header">
    <h1>Applicants</h1>
  </header>

  <section class="filter-section">
    <div class="search-box">
      <input type="text" id="searchInput" placeholder="Search users by name or email...">
      <i class="fa fa-search"></i>
    </div>
  </section>

  <section class="users-list" id="usersList">
    <!-- User cards will load here dynamically -->
  </section>

  <script src="${pageContext.request.contextPath}/view/js/Employerapplication.js"></script>
</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Job Listings - JobPortal</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/jobs.css" />
</head>
<body>
  <header class="header">
    <h1>Find Your Next Opportunity</h1>
  </header>

  <section class="filter-section">
    <div class="search-box">
      <input type="text" id="searchInput" placeholder="Search jobs, companies, keywords...">
      <i class="fa fa-search"></i>
    </div>

    <div class="filter">
      <h3>Job Type</h3>
      <div class="filter-options" id="jobTypeFilter">
        <button class="active">All Types</button>
        <button>Full-time</button>
        <button>Part-time</button>
        <button>Contract</button>
        <button>Internship</button>
      </div>
    </div>

    <div class="filter">
      <h3>Category</h3>
      <div class="filter-options" id="categoryFilter">
        <button class="active">All</button>
        <button>Engineering</button>
        <button>Design</button>
        <button>Marketing</button>
        <button>Sales</button>
        <button>Data Science</button>
      </div>
    </div>

    <button class="reset-btn" id="resetFilters">⟳ Reset Filters</button>
  </section>

  <section class="jobs-list" id="jobsList">
  <!-- Job cards will load here dynamically -->
</section>


  <script src="${pageContext.request.contextPath}/view/js/jobs.js"></script>
</body>
</html>

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

  <section class="jobs-list">
    <!-- Job Card 1 -->
    <div class="job-card">
      <div class="job-header">
        <img src="https://randomuser.me/api/portraits/men/32.jpg" alt="Company Logo" class="company-logo">
        <div class="job-info">
          <h2>Senior Frontend Developer</h2>
          <p class="company">TechCorp Inc.</p>
          <p class="details">
            <span>📍 San Francisco, CA</span> • 
            <span>💼 Full-time</span> • 
            <span>💰 $120k - $160k</span> • 
            <span>🕓 2 days ago</span>
          </p>
        </div>
        <span class="featured">⭐ Featured</span>
      </div>
      <p class="description">
        We are looking for an experienced Frontend Developer to join our growing team. 
        You will be responsible for building modern web applications using React and TypeScript.
      </p>
      <div class="tags">
        <span>Engineering</span>
      </div>
      <button class="view-btn">View Details</button>
    </div>

    <!-- Job Card 2 -->
    <div class="job-card">
      <div class="job-header">
        <img src="https://randomuser.me/api/portraits/men/31.jpg" alt="Company Logo" class="company-logo">
        <div class="job-info">
          <h2>Product Designer</h2>
          <p class="company">DesignHub</p>
          <p class="details">
            <span>📍 New York, NY</span> • 
            <span>💼 Full-time</span> • 
            <span>💰 $100k - $140k</span> • 
            <span>🕓 1 week ago</span>
          </p>
        </div>
        <span class="featured">⭐ Featured</span>
      </div>
      <p class="description">
        Join our design team to create beautiful and intuitive user experiences for our products. 
        You will work closely with product managers and engineers.
      </p>
      <div class="tags">
        <span>Design</span>
      </div>
      <a href="/jobsdes.html" class="view-btn">View Details</a>

      
    </div>
  </section>

  <script src="${pageContext.request.contextPath}/view/js/jobs.js"></script>
</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Discover Companies - JobPortal</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/companies.css" />
</head>
<body>
  <!-- ===== HERO SECTION ===== -->
  <section class="hero">
    <h1>Discover Amazing <span>Companies</span></h1>
    <p>Explore top companies across various industries and find your perfect workplace culture</p>
  </section>

  <!-- ===== FEATURED SECTION ===== -->
  <section class="featured-section">
    <button class="featured-btn">Featured Employers</button>
    <h2>Top Companies Hiring Now</h2>
    <p>Join these innovative companies that are leading their industries</p>
  </section>

  <!-- ===== COMPANY CARDS ===== -->
  <section class="companies-container">

    <!-- Company 1 -->
    <div class="company-card">
      <div class="card-header">
        <img src="https://cdn-icons-png.flaticon.com/512/747/747376.png" alt="TechCorp Logo" class="company-logo">
        <span class="open-roles">12 open roles</span>
      </div>
      <h3>TechCorp Inc.</h3>
      <p class="industry">Technology</p>
      <p class="description">
        Leading technology company specializing in cloud computing and AI solutions.
      </p>
      <ul class="company-details">
        <li>📍 San Francisco, CA</li>
        <li>👥 1,000–5,000</li>
        <li>🏢 Since 2010</li>
        <li>⭐ 4.8</li>
      </ul>
      <div class="tags">
        <span>Health Insurance</span>
        <span>Remote Work</span>
        <span>401(k)</span>
        <span>+1 more</span>
      </div>
      <button class="view-btn">View Jobs</button>
    </div>

    <!-- Company 2 -->
    <div class="company-card">
      <div class="card-header">
        <img src="https://cdn-icons-png.flaticon.com/512/3159/3159338.png" alt="Design Studio Plus" class="company-logo">
        <span class="open-roles">8 open roles</span>
      </div>
      <h3>Design Studio Plus</h3>
      <p class="industry">Design</p>
      <p class="description">
        Creative design agency working with Fortune 500 companies.
      </p>
      <ul class="company-details">
        <li>📍 New York, NY</li>
        <li>👥 50–200</li>
        <li>🏢 Since 2015</li>
        <li>⭐ 4.6</li>
      </ul>
      <div class="tags">
        <span>Creative Freedom</span>
        <span>Flexible Hours</span>
        <span>Health Insurance</span>
        <span>+1 more</span>
      </div>
      <button class="view-btn">View Jobs</button>
    </div>

    <!-- Company 3 -->
    <div class="company-card">
      <div class="card-header">
        <img src="https://cdn-icons-png.flaticon.com/512/1077/1077012.png" alt="InnovateLabs" class="company-logo">
        <span class="open-roles">15 open roles</span>
      </div>
      <h3>InnovateLabs</h3>
      <p class="industry">Research</p>
      <p class="description">
        Research and development company focused on breakthrough innovations.
      </p>
      <ul class="company-details">
        <li>📍 Boston, MA</li>
        <li>👥 200–500</li>
        <li>🏢 Since 2012</li>
        <li>⭐ 4.7</li>
      </ul>
      <div class="tags">
        <span>Research Budget</span>
        <span>Conference Attendance</span>
        <span>Health Insurance</span>
        <span>+1 more</span>
      </div>
      <button class="view-btn">View Jobs</button>
    </div>
  </section>

  <script src="${pageContext.request.contextPath}/view/js/companies.js"></script>
</body>
</html>

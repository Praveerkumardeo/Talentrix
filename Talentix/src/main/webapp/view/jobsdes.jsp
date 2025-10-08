<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Job Description - Senior Frontend Developer</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/jobsdes.css" />
</head>
<body>
  <a href="jobs.html" class="back-link">&larr; Back to Jobs</a>

  <main class="job-details-container">
    <section class="job-card">
      <div class="job-header">
        <img src="https://via.placeholder.com/80" alt="Company Logo" />
        <div>
          <h2>Senior Frontend Developer</h2>
          <p class="company-name">TechCorp Inc.</p>
        </div>
        <span class="badge">Featured</span>
      </div>

      <div class="job-tags">
        <span>📍 San Francisco, CA</span>
        <span>💼 Full-time</span>
        <span>💰 $120k - $160k</span>
        <span>⏱ Posted 2 days ago</span>
      </div>

      <div class="tabs">
        <button class="tab-button active" data-tab="overview">Overview</button>
        <button class="tab-button" data-tab="tasks">Tasks</button>
        <button class="tab-button" data-tab="skills">Skills</button>
        <button class="tab-button" data-tab="benefits">Benefits</button>
      </div>

      <div class="tab-content active" id="overview">
        <h3>About the Role</h3>
        <p>
          We are looking for an experienced Frontend Developer to join our growing team.
          You will be responsible for building modern web applications using React and TypeScript.
        </p>
      </div>
      <div class="tab-content" id="tasks">
        <h3>Responsibilities</h3>
        <ul>
          <li>Develop scalable frontend features</li>
          <li>Collaborate with designers and backend developers</li>
          <li>Participate in code reviews</li>
        </ul>
      </div>
      <div class="tab-content" id="skills">
        <h3>Required Skills</h3>
        <ul>
          <li>JavaScript / TypeScript</li>
          <li>React.js</li>
          <li>REST APIs</li>
          <li>Version control (Git)</li>
        </ul>
      </div>
      <div class="tab-content" id="benefits">
        <h3>Perks & Benefits</h3>
        <ul>
          <li>Health insurance</li>
          <li>Remote work options</li>
          <li>Annual bonus</li>
        </ul>
      </div>
    </section>

    <aside class="sidebar">
      <button class="apply-button">Apply Now</button>
      <button class="save-button">Save Job</button>

      <div class="job-info">
        <h4>Job Information</h4>
        <p><strong>Category:</strong> <span>Engineering</span></p>
        <p><strong>Job Type:</strong> <span>Full-time</span></p>
        <p><strong>Location:</strong> <span>San Francisco, CA</span></p>
        <p><strong>Salary Range:</strong> <span>$120k - $160k</span></p>
        <p><strong>Posted:</strong> <span>2 days ago</span></p>
      </div>

      <div class="share">
        <h4>Share this job</h4>
        <button>Twitter</button>
        <button>LinkedIn</button>
        <button onclick="copyLink()">Copy</button>
      </div>
    </aside>
  </main>

  <script src="${pageContext.request.contextPath}/view/js/jobsdes.js"></script>
</body>
</html>

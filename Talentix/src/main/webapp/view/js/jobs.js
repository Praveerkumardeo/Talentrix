// Activate filters
const jobTypeButtons = document.querySelectorAll("#jobTypeFilter button");
const categoryButtons = document.querySelectorAll("#categoryFilter button");
const resetBtn = document.getElementById("resetFilters");
const jobCards = document.querySelectorAll(".job-card");

function handleFilterClick(buttons, activeClass = "active") {
  buttons.forEach((btn) => {
    btn.addEventListener("click", () => {
      buttons.forEach((b) => b.classList.remove(activeClass));
      btn.classList.add(activeClass);
      filterJobs();
    });
  });
}

handleFilterClick(jobTypeButtons);
handleFilterClick(categoryButtons);

resetBtn.addEventListener("click", () => {
  document.querySelectorAll(".filter-options button").forEach((btn) => {
    btn.classList.remove("active");
  });
  document.querySelectorAll(".filter-options button:first-child").forEach((btn) =>
    btn.classList.add("active")
  );
  filterJobs();
});

// Filter job cards based on active filters

function filterJobs() {
  const activeJobType = document.querySelector("#jobTypeFilter .active")?.textContent.trim();
  const activeCategory = document.querySelector("#categoryFilter .active")?.textContent.trim();

  jobCards.forEach((card) => {
    const cardType = card.getAttribute("data-type");
    const cardCategory = card.getAttribute("data-category");

    const matchType = (activeJobType === "All Types" || activeJobType === "All" || activeJobType === null || cardType === activeJobType);
    const matchCategory = (activeCategory === "All" || activeCategory === null || cardCategory === activeCategory);

    if (matchType && matchCategory) {
      card.style.display = "block";
    } else {
      card.style.display = "none";
    }
  });
}

// Search (demo functionality)
document.getElementById("searchInput").addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    alert(`Searching for: ${e.target.value}`);
  }
});






// adding job card dinamically 
const jobsList = document.getElementById("jobsList");
const apiUrl = "http://localhost:8080/api/jobs/getAll"; // ✅ adjust port if needed

async function loadJobs() {
  try {
    const response = await fetch(apiUrl);
    const jobs = await response.json();
    renderJobs(jobs);
  } catch (error) {
    console.error("❌ Error loading jobs:", error);
  }
}

function renderJobs(jobs) {
  jobsList.innerHTML = ""; // clear old data

  if (!jobs || jobs.length === 0) {
    jobsList.innerHTML = "<p>No jobs found.</p>";
    return;
  }

  jobs.forEach(job => {
    const jobCard = document.createElement("div");
    jobCard.classList.add("job-card");

    // Use correct backend field names 👇
    const title = job.jobTitle || "Untitled";
    const description = job.jobDescription || "No description available.";
    const location = job.jobLocation || "Location not specified";
    const type = job.jobType || "N/A";
    const salary = job.salary ? `$${job.salary}` : "Not disclosed";
    const category = (job.categories && job.categories.length > 0) ? job.categories[0] : "General";

    jobCard.setAttribute("data-type", type);
    jobCard.setAttribute("data-category", category);

    jobCard.innerHTML = `
      <div class="job-header">
        <img src="https://randomuser.me/api/portraits/men/${Math.floor(Math.random() * 80)}.jpg" 
             alt="Company Logo" class="company-logo">
        <div class="job-info">
          <h2>${title}</h2>
          <p class="company">${job.postedBy ? job.postedBy.name || "Unknown Employer" : "Anonymous"}</p>
          <p class="details">
            <span>📍 ${location}</span> •
            <span>💼 ${type}</span> •
            <span>💰 ${salary}</span> •
            <span>🕓 ${formatDate(job.postedDate)}</span>
          </p>
        </div>
        <span class="featured">⭐ Featured</span>
      </div>
      <p class="description">${description}</p>
      <div class="tags"><span>${category}</span></div>
      <a href="/view/jobdetails.jsp?id=${job.id}" class="view-btn">View Details</a>
    `;

    jobsList.appendChild(jobCard);
  });
}

function formatDate(dateStr) {
  if (!dateStr) return "Unknown date";
  const date = new Date(dateStr);
  const diff = Math.floor((new Date() - date) / (1000 * 60 * 60 * 24));
  if (isNaN(diff)) return "Unknown date";
  return diff === 0 ? "Today" : diff === 1 ? "1 day ago" : `${diff} days ago`;
}

// Load jobs on page load
document.addEventListener("DOMContentLoaded", loadJobs);

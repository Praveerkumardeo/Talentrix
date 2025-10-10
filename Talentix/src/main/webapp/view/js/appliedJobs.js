// Get elements
const container = document.getElementById("appliedJobsContainer");
const emptyMessage = document.getElementById("emptyMessage");

const homeButton = document.getElementById("homeButton");
homeButton.addEventListener("click", () => {
	window.location.href = "http://localhost:8080/userlanding";
});

const baseurl = "http://localhost:8080";

// ✅ Fetch applied jobs from backend
async function fetchAppliedJobs() {
	try {
		const response = await fetch(`${baseurl}/api/applications/myApplications`);


		// Handle 204 No Content
		if (response.status === 204) {
			emptyMessage.style.display = "block";
			container.innerHTML = "";
			return;
		}

		if (!response.ok) {
			throw new Error("Failed to fetch applied jobs");
		}

		const jobs = await response.json();
		if (jobs == null) {
			console.log("Response is null");
		}
		console.log("jobs:", jobs);
		renderAppliedJobs(jobs);

	} catch (error) {
		console.error("Error fetching applied jobs:", error);
		emptyMessage.style.display = "block";
		emptyMessage.textContent = "⚠️ Failed to load your applied jobs.";
	}
}

// ✅ Render job cards
function renderAppliedJobs(jobs) {
  if (!jobs || jobs.length === 0) {
    emptyMessage.style.display = "block";
    container.innerHTML = "";
    return;
  }

  emptyMessage.style.display = "none";
  container.innerHTML = "";

  jobs.forEach(job => {
    const jobCard = document.createElement("div");
    jobCard.classList.add("job-card");

    jobCard.innerHTML = `
      <h3 class="job-title">${job.jobTitle || "No Title"}</h3>
      <p class="company-name">${job.companyName || "Unknown Company"}</p>
      <p class="job-description">${job.jobDescription || "No description available."}</p>
      <div class="job-meta">
        <span>📍 ${job.jobLocation || "N/A"}</span>
        <span class="status">${job.status || "Applied"}</span>
      </div>
    `;

    container.appendChild(jobCard);
  });
}


// ✅ Initialize on page load
fetchAppliedJobs();

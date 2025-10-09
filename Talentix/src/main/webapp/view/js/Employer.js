

// adding job card dinamically 
const jobsList = document.getElementById("jobsList");
const apiUrl = "http://localhost:8080/api/jobs/getAll"; // ✅ adjust port if needed

async function loadJobs() {
    try {
        const response = await fetch(apiUrl);
        const jobs = await response.json();
        console.log(jobs)
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
        const salary = (job.salary != null && job.salary !== 0) ? `$${job.salary}` : "Not disclosed";


        const category = (job.categories && job.categories.length > 0) ? job.categories[0] : "General";

        jobCard.setAttribute("data-type", type);
        jobCard.setAttribute("data-category", category);

        jobCard.innerHTML = `
      <a href="/view/jobdetails.jsp?id=${job.id}" 
   style="text-decoration: none; color: inherit; display: block; background: #ffffff; border: 1px solid #e0e0e0; border-radius: 12px; box-shadow: 0 4px 12px rgba(0,0,0,0.08); margin-bottom: 25px; overflow: hidden; transition: transform 0.2s ease, box-shadow 0.2s ease; cursor: pointer;"
   onmouseover="this.style.transform='translateY(-4px)'; this.style.boxShadow='0 8px 20px rgba(0,0,0,0.15)'" 
   onmouseout="this.style.transform='translateY(0)'; this.style.boxShadow='0 4px 12px rgba(0,0,0,0.08)'">
  
  <div class="job-header" style="display: flex; align-items: flex-start; justify-content: space-between; padding: 25px; position: relative;">
    <img src="https://randomuser.me/api/portraits/men/${Math.floor(Math.random() * 80)}.jpg" 
         alt="Company Logo" 
         class="company-logo"
         style="width: 70px; height: 70px; border-radius: 10px; object-fit: cover; margin-right: 18px; flex-shrink: 0; border: 2px solid #f0f0f0;">
    
    <div class="job-info" style="flex: 1;">
      <h2 style="margin: 0 0 10px 0; font-size: 22px; font-weight: 600; color: #2c3e50; line-height: 1.3;">${title}</h2>
      <p class="company" style="margin: 0 0 12px 0; font-size: 15px; color: #7f8c8d; font-weight: 500;">
        ${job.postedBy ? job.postedBy.name || "Unknown Employer" : "Anonymous"}
      </p>
      <p class="details" style="margin: 0; font-size: 13px; color: #95a5a6; display: flex; flex-wrap: wrap; gap: 12px; align-items: center;">
        <span style="display: inline-flex; align-items: center; gap: 4px;">📍 ${location}</span>
        <span style="color: #ddd;">•</span>
        <span style="display: inline-flex; align-items: center; gap: 4px;">💼 ${type}</span>
        <span style="color: #ddd;">•</span>
        <span style="display: inline-flex; align-items: center; gap: 4px;">💰 ${salary}</span>
        <span style="color: #ddd;">•</span>
        <span style="display: inline-flex; align-items: center; gap: 4px;">🕓 ${formatDate(job.postedDate)}</span>
      </p>
    </div>
    
    <span class="featured" style="position: absolute; top: 25px; right: 25px; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; padding: 6px 14px; border-radius: 20px; font-size: 12px; font-weight: 600; box-shadow: 0 2px 8px rgba(102, 126, 234, 0.4);">
      ⭐ Featured
    </span>
  </div>
  
  <p class="description" style="margin: 0; padding: 0 25px 20px 25px; font-size: 14px; color: #666; line-height: 1.7; border-top: 1px solid #f5f5f5; padding-top: 20px;">
    ${description}
  </p>
  
  <div class="tags" style="padding: 0 25px 25px 25px;">
    <span style="display: inline-block; background: #ecf0f1; color: #34495e; padding: 7px 16px; border-radius: 6px; font-size: 13px; font-weight: 500;">
      ${category}
    </span>
  </div>
  
</a>


    `;

        // <div class="job-header">
        //     <img src="https://randomuser.me/api/portraits/men/${Math.floor(Math.random() * 80)}.jpg" 
        //          alt="Company Logo" class="company-logo">
        //     <div class="job-info">
        //       <h2>${title}</h2>
        //       <p class="company">${job.postedBy ? job.postedBy.name || "Unknown Employer" : "Anonymous"}</p>
        //       <p class="details">
        //         <span>📍 ${location}</span> •
        //         <span>💼 ${type}</span> •
        //         <span>💰 ${salary}</span> •
        //         <span>🕓 ${formatDate(job.postedDate)}</span>
        //       </p>
        //     </div>
        //     <span class="featured">⭐ Featured</span>
        //   </div>
        //   <p class="description">${description}</p>
        //   <div class="tags"><span>${category}</span></div>
        //   <a href="/view/jobdetails.jsp?id=${job.id}" class="view-btn">View Details</a>

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

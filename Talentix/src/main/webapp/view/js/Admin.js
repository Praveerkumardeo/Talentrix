const jobTableBody = document.getElementById("jobTableBody");

const jobs = [
  { title: "Senior Frontend Developer", company: "TechCorp Inc.", location: "San Francisco, CA", type: "Full-time", category: "Engineering", posted: "NaN months ago" },
  { title: "Product Designer", company: "DesignHub", location: "New York, NY", type: "Full-time", category: "Design", posted: "NaN months ago" },
  { title: "Data Scientist", company: "DataWorks", location: "Remote", type: "Full-time", category: "Data Science", posted: "NaN months ago" },
  { title: "Marketing Manager", company: "GrowthLabs", location: "Austin, TX", type: "Full-time", category: "Marketing", posted: "NaN months ago" },
  { title: "Backend Engineer", company: "CloudServices", location: "Seattle, WA", type: "Full-time", category: "Engineering", posted: "NaN months ago" },
  { title: "UX Researcher", company: "UserFirst", location: "Boston, MA", type: "Full-time", category: "Design", posted: "NaN months ago" },
  { title: "DevOps Engineer", company: "InfraTech", location: "Remote", type: "Full-time", category: "Engineering", posted: "NaN months ago" },
  { title: "Content Writer", company: "ContentPro", location: "Los Angeles, CA", type: "Part-time", category: "Marketing", posted: "NaN months ago" },
  { title: "Mobile Developer", company: "AppMakers", location: "Chicago, IL", type: "Contract", category: "Engineering", posted: "NaN months ago" },
  { title: "Sales Executive", company: "SalesPro", location: "Miami, FL", type: "Full-time", category: "Sales", posted: "NaN months ago" },
];

function renderJobs() {
  jobTableBody.innerHTML = jobs.map(job => `
    <tr>
      <td>${job.title}</td>
      <td>${job.company}</td>
      <td>${job.location}</td>
      <td>${job.type}</td>
      <td>${job.category}</td>
      <td>${job.posted}</td>
      <td class="actions">
        <i class="edit">✏️</i>
        <i class="delete">🗑️</i>
      </td>
    </tr>
  `).join("");
}

renderJobs();

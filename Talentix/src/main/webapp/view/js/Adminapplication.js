const applications = [
  { name: "John Doe", email: "john.doe@email.com", job: "Senior Frontend Developer", company: "TechCorp Inc.", date: "Oct 1, 2025, 04:00 PM", status: "reviewing" },
  { name: "Jane Smith", email: "jane.smith@email.com", job: "UX/UI Designer", company: "DesignHub", date: "Sep 30, 2025, 07:50 PM", status: "shortlisted" },
  { name: "Mike Johnson", email: "mike.j@email.com", job: "Senior Frontend Developer", company: "TechCorp Inc.", date: "Oct 2, 2025, 02:45 PM", status: "pending" },
  { name: "Sarah Williams", email: "sarah.w@email.com", job: "Product Manager", company: "InnovateCo", date: "Sep 28, 2025, 04:30 PM", status: "accepted" },
  { name: "Robert Brown", email: "robert.b@email.com", job: "DevOps Engineer", company: "CloudSys", date: "Sep 29, 2025, 10:15 PM", status: "reviewing" },
  { name: "Emily Davis", email: "emily.d@email.com", job: "UX/UI Designer", company: "DesignHub", date: "Sep 27, 2025, 07:00 PM", status: "rejected" },
  { name: "David Lee", email: "david.lee@email.com", job: "Data Scientist", company: "DataCorp", date: "Oct 1, 2025, 01:30 PM", status: "shortlisted" },
  { name: "Lisa Chen", email: "lisa.chen@email.com", job: "Mobile Developer", company: "AppWorks", date: "Oct 3, 2025, 03:30 PM", status: "pending" }
];

const tableBody = document.getElementById("applicationsTableBody");
const filter = document.getElementById("statusFilter");

function renderApplications(filterStatus = "all") {
  const filteredApps = filterStatus === "all"
    ? applications
    : applications.filter(app => app.status === filterStatus);

  tableBody.innerHTML = filteredApps.map(app => `
    <tr>
      <td>
        <strong>${app.name}</strong><br />
        <small>${app.email}</small>
      </td>
      <td>${app.job}</td>
      <td>${app.company}</td>
      <td>${app.date}</td>
      <td><span class="status ${app.status}">${app.status}</span></td>
      <td class="actions"><i class="view">👁️</i> View</td>
    </tr>
  `).join("");
}

filter.addEventListener("change", e => renderApplications(e.target.value));
renderApplications();

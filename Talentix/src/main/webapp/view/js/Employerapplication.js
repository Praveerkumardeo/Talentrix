const applications = [
  { name: "Alice Johnson", email: "alice.j@email.com", job: "Software Engineer", date: "Oct 5, 2025, 11:00 AM", status: "reviewing" },
  { name: "Brian King", email: "brian.k@email.com", job: "Backend Developer", date: "Oct 4, 2025, 03:15 PM", status: "pending" },
  { name: "Catherine Ray", email: "catherine.r@email.com", job: "Product Designer", date: "Oct 3, 2025, 09:45 AM", status: "shortlisted" },
  { name: "Daniel Park", email: "daniel.p@email.com", job: "Data Analyst", date: "Oct 2, 2025, 05:30 PM", status: "accepted" },
  { name: "Ella Zhang", email: "ella.z@email.com", job: "Frontend Developer", date: "Oct 1, 2025, 10:20 AM", status: "rejected" }
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
      <td>${app.date}</td>
      <td><span class="status ${app.status}">${app.status}</span></td>
      <td class="actions"><i class="view">👁️</i> View</td>
    </tr>
  `).join("");
}

filter.addEventListener("change", e => renderApplications(e.target.value));
renderApplications();

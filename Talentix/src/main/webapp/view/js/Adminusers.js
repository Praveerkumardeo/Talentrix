const userTableBody = document.getElementById("userTableBody");

const users = [
  {
    name: "Admin User",
    email: "admin@jobportal.com",
    role: "admin",
    joined: "Oct 8, 2025"
  }
];

function renderUsers() {
  userTableBody.innerHTML = users.map(user => `
    <tr>
      <td>${user.name}</td>
      <td>${user.email}</td>
      <td><span class="role-badge">${user.role}</span></td>
      <td>${user.joined}</td>
      <td class="actions">
        <i class="edit">✏️</i>
        <i class="delete">🗑️</i>
      </td>
    </tr>
  `).join("");
}

renderUsers();

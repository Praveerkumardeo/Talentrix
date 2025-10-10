const apiUrl = "http://localhost:8080/api/applications/verifyApplications"; // adjust if needed
const usersList = document.getElementById("usersList");

// Load users dynamically
async function loadUsers() {
  try {
    const response = await fetch(apiUrl);
    const users = await response.json();
    console.log(users);
    renderUsers(users);
  } catch (error) {
    console.error("❌ Error loading users:", error);
    usersList.innerHTML = "<p>Error loading users.</p>";
  }
}

const api = "http://localhost:8080/"

function renderUsers(users) {
  usersList.innerHTML = "";

  if (!users || users.length === 0) {
    usersList.innerHTML = "<p>No applicants found.</p>";
    return;
  }

  users.forEach(user => {
    const userCard = document.createElement("div");
    userCard.classList.add("user-card");
    const id = user.id;
    const name = user.name || "No Name";
    const email = user.email || "No Email";
    const resume = user.resume || "No Resume";

    userCard.innerHTML = `
     <div style="display: flex; flex-wrap: wrap; gap: 20px; justify-content: center;">

  <!-- Single User Card -->
  <div style="width: 400px; background: #ffffff; border: 1px solid #ddd; border-radius: 10px; 
              padding: 20px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); 
              display: flex; flex-direction: column; align-items: flex-start; 
              font-family: Arial, sans-serif; transition: 0.3s;">
    
    <div class="user-header" style="display: flex; align-items: center; margin-bottom: 15px; width: 100%;">
      <img src="https://randomuser.me/api/portraits/men/${Math.floor(Math.random() * 80)}.jpg" 
           alt="User Avatar" 
           style="width: 70px; height: 70px; border-radius: 50%; object-fit: cover; margin-right: 15px; border: 2px solid #007bff;">
      
      <div style="flex-grow: 1;">
        <h2 style="margin: 0; font-size: 20px; color: #333;">${name}</h2>
        <p style="margin: 5px 0 0; font-size: 14px; color: #555;">Email: ${email}</p>
      </div>
    </div>

    <p style="font-size: 14px; color: #333; margin-bottom: 15px;">
      <strong>Resume:</strong> 
      <a href="${resume}" target="_blank" style="color: #007bff; text-decoration: none;">View Resume</a>
    </p>

    <!-- Buttons inside each card -->
    <div style="display: flex; gap: 10px; width: 100%;">
      <a href="${api}api/applications/changeStatus/${id}/shortlisted" 
         style="flex: 1; text-align: center; background: #28a745; color: white; padding: 10px 12px; 
                text-decoration: none; border-radius: 6px; font-size: 14px; font-weight: bold; 
                transition: background 0.3s;">
        Shortlist
      </a>

      <a href="${api}api/applications/changeStatus/${id}/rejected" 
         style="flex: 1; text-align: center; background: #dc3545; color: white; padding: 10px 12px; 
                text-decoration: none; border-radius: 6px; font-size: 14px; font-weight: bold; 
                transition: background 0.3s;">
        Reject
      </a>
    </div>
  </div>

  <!-- Repeat this card for each user dynamically -->
</div>


    `;

    usersList.appendChild(userCard);
  });
}

// Simple search by name or email
document.getElementById("searchInput").addEventListener("input", e => {
  const query = e.target.value.toLowerCase();
  document.querySelectorAll(".user-card").forEach(card => {
    const name = card.querySelector("h2").textContent.toLowerCase();
    const email = card.querySelector("p").textContent.toLowerCase();
    card.style.display = name.includes(query) || email.includes(query) ? "block" : "none";
  });
});

document.addEventListener("DOMContentLoaded", loadUsers);

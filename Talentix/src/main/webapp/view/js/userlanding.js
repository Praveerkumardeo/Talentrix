// Dropdown toggle for user menu
const userIcon = document.getElementById('userIcon');
const dropdown = document.getElementById('userDropdown');

userIcon.addEventListener('click', () => {
  dropdown.style.display = dropdown.style.display === 'block' ? 'none' : 'block';
});

// Close dropdown when clicking outside
window.addEventListener('click', (e) => {
  if (!userIcon.contains(e.target) && !dropdown.contains(e.target)) {
    dropdown.style.display = 'none';
  }
});

// Search button click
document.getElementById("searchBtn").addEventListener("click", () => {
  const query = document.getElementById("searchInput").value.trim();
  if (query) {
    alert(`Searching for: ${query}`);
  } else {
    alert("Please enter a search term!");
  }
});

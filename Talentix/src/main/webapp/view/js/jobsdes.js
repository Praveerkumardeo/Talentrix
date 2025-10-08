// Tab switching functionality
const tabButtons = document.querySelectorAll(".tab-button");
const tabContents = document.querySelectorAll(".tab-content");

tabButtons.forEach((btn) => {
  btn.addEventListener("click", () => {
    // Remove active class from all buttons and contents
    tabButtons.forEach(b => b.classList.remove("active"));
    tabContents.forEach(c => c.classList.remove("active"));

    // Activate selected tab and content
    btn.classList.add("active");
    const selectedTab = btn.getAttribute("data-tab");
    document.getElementById(selectedTab).classList.add("active");
  });
});

// Copy link functionality
function copyLink() {
  navigator.clipboard.writeText(window.location.href).then(() => {
    alert("Link copied to clipboard!");
  }).catch(err => {
    alert("Failed to copy link.");
  });
}

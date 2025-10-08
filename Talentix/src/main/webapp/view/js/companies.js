// Make all buttons clickable
document.querySelectorAll(".view-btn").forEach(button => {
  button.addEventListener("click", () => {
    alert("Redirecting to jobs for this company...");
    window.location.href = "jobs.html"; // You can change this URL
  });
});

document.querySelector(".featured-btn").addEventListener("click", () => {
  alert("Showing featured employers!");
});

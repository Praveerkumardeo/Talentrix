document.getElementById("jobForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const job = {
    jobTitle: document.getElementById("jobTitle").value,
    jobDescription: document.getElementById("jobDescription").value,
    jobLocation: document.getElementById("jobLocation").value,
    jobType: document.getElementById("jobType").value,
    numberOfPositions: document.getElementById("numberOfPositions").value,
    salary: document.getElementById("salary").value,
    applicationDeadline: document.getElementById("applicationDeadline").value,
    requiredSkills: document.getElementById("requiredSkills").value.split(",").map(s => s.trim()).filter(s => s),
    categories: document.getElementById("categories").value.split(",").map(c => c.trim()).filter(c => c),
    postedDate: new Date().toISOString().split("T")[0],
    postedBy: "Employer123" // placeholder — replace with logged-in employer info
  };

  console.log("Job Data Submitted:", job);
  alert("Job added successfully!");

  // Example: send data to backend
  /*
  fetch("/api/jobs", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(job)
  })
  .then(res => res.json())
  .then(data => {
    alert("Job added successfully!");
  })
  .catch(err => console.error(err));
  */

  document.getElementById("jobForm").reset();
});

document.getElementById("cancelBtn").addEventListener("click", function () {
  if (confirm("Are you sure you want to cancel?")) {
    window.location.href = "employer.html";
  }
});

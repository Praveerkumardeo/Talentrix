document.getElementById("updateForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const profile = {
    name: document.getElementById("name").value,
    email: document.getElementById("email").value,
    password: document.getElementById("password").value,
    phoneNumber: document.getElementById("phoneNumber").value,
    companyName: document.getElementById("companyName").value,
    resume: document.getElementById("resume").value || null
  };

  console.log("Profile Update Submitted:", profile);
  alert("Profile updated successfully!");

  // Example: Send to backend (uncomment once backend is ready)
  /*
  fetch("/updateProfile", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(profile)
  })
    .then((res) => res.json())
    .then((data) => {
      alert("Profile updated successfully!");
    })
    .catch((err) => console.error(err));
  */
});

document.getElementById("cancelBtn").addEventListener("click", function () {
  if (confirm("Cancel profile update?")) {
    window.location.href = "employer.html";
  }
});

// Modal controls
const modal = document.getElementById("authModal");
const openSignIn = document.getElementById("openSignIn");
const openSignUp = document.getElementById("openSignUp");
const closeModal = document.getElementById("closeModal");

// Tab buttons
const tabSignIn = document.getElementById("tabSignIn");
const tabUserSignUp = document.getElementById("tabUserSignUp");
const tabEmployerSignUp = document.getElementById("tabEmployerSignUp");

// Forms
const signInForm = document.getElementById("signInForm");
const userSignUpForm = document.getElementById("userSignUpForm");
const employerSignUpForm = document.getElementById("employerSignUpForm");

// Open modal for Sign In or Sign Up
openSignIn.addEventListener("click", () => {
  modal.style.display = "flex";
  showTab("signIn");
});
openSignUp.addEventListener("click", () => {
  modal.style.display = "flex";
  showTab("userSignUp");
});
closeModal.addEventListener("click", () => {
  modal.style.display = "none";
});
window.addEventListener("click", (e) => {
  if (e.target === modal) modal.style.display = "none";
});

// Tab switching
tabSignIn.addEventListener("click", () => showTab("signIn"));
tabUserSignUp.addEventListener("click", () => showTab("userSignUp"));
tabEmployerSignUp.addEventListener("click", () => showTab("employerSignUp"));

// Show specific form and activate tab
function showTab(type) {
  // remove active from all tabs
  [tabSignIn, tabUserSignUp, tabEmployerSignUp].forEach(btn =>
    btn.classList.remove("active")
  );
  [signInForm, userSignUpForm, employerSignUpForm].forEach(form =>
    form.classList.remove("active")
  );

  if (type === "signIn") {
    tabSignIn.classList.add("active");
    signInForm.classList.add("active");
  } else if (type === "userSignUp") {
    tabUserSignUp.classList.add("active");
    userSignUpForm.classList.add("active");
  } else if (type === "employerSignUp") {
    tabEmployerSignUp.classList.add("active");
    employerSignUpForm.classList.add("active");
  }
}

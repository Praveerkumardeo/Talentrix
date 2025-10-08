// Activate filters
const jobTypeButtons = document.querySelectorAll("#jobTypeFilter button");
const categoryButtons = document.querySelectorAll("#categoryFilter button");
const resetBtn = document.getElementById("resetFilters");
const jobCards = document.querySelectorAll(".job-card");

function handleFilterClick(buttons, activeClass = "active") {
  buttons.forEach((btn) => {
    btn.addEventListener("click", () => {
      buttons.forEach((b) => b.classList.remove(activeClass));
      btn.classList.add(activeClass);
      filterJobs();
    });
  });
}

handleFilterClick(jobTypeButtons);
handleFilterClick(categoryButtons);

resetBtn.addEventListener("click", () => {
  document.querySelectorAll(".filter-options button").forEach((btn) => {
    btn.classList.remove("active");
  });
  document.querySelectorAll(".filter-options button:first-child").forEach((btn) =>
    btn.classList.add("active")
  );
  filterJobs();
});

// Filter job cards based on active filters

function filterJobs() {
  const activeJobType = document.querySelector("#jobTypeFilter .active")?.textContent.trim();
  const activeCategory = document.querySelector("#categoryFilter .active")?.textContent.trim();

  jobCards.forEach((card) => {
    const cardType = card.getAttribute("data-type");
    const cardCategory = card.getAttribute("data-category");

    const matchType = (activeJobType === "All Types" || activeJobType === "All" || activeJobType === null || cardType === activeJobType);
    const matchCategory = (activeCategory === "All" || activeCategory === null || cardCategory === activeCategory);

    if (matchType && matchCategory) {
      card.style.display = "block";
    } else {
      card.style.display = "none";
    }
  });
}

// Search (demo functionality)
document.getElementById("searchInput").addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    alert(`Searching for: ${e.target.value}`);
  }
});

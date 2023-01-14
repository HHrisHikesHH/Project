const circles = document.querySelectorAll(".circle");

// console.log(circles);
const next = document.getElementById("next");
const prev = document.getElementById("prev");
const progress = document.getElementById("progress");

let currentActive = 1;
next.addEventListener("click", () => {
  if (currentActive >= circles.length) currentActive = circles.length;
  update();
  // console.log(currentActive);
  currentActive += 1;
});

prev.addEventListener("click", () => {
  currentActive -= 1;
  if (currentActive <= 1) currentActive = 1;
  // console.log(currentActive);
  update();
});

function update() {
  circles.forEach((circle, idx) => {
    if (idx < currentActive) circle.classList.add("active");
    else circle.classList.remove("active");
  });

  const actives = document.querySelectorAll(".active");
  console.log(actives.length, circles.length);

  progress.style.width =
    ((actives.length - 1) / (circles.length - 1)) * 100 + "%";

  if (currentActive == 1) {
    prev.disabled = true;
    next.disabled = false;
  } else if (currentActive == circles.length) {
    prev.disabled = false;
    next.disabled = true;
  } else {
    prev.disabled = false;
    next.disabled = false;
  }
}

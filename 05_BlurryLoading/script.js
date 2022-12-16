const loadText = document.querySelector(".loading-text");
const bg = document.querySelector(".bg");
const qt = document.querySelector(".quote");

let load = 0;

let interval = setInterval(blur, 20);

function blur() {
  load++;
  if (load > 100) return;
  loadText.innerText = `${load}%`;

  loadText.style.opacity = scale(load, 0, 80, 1, 0);

  bg.style.filter = `blur(${scale(load, 0, 80, 20, 0)}px)`;

  qt.style.opacity = scale(load, 0, 80, 0, 1);
  console.log(qt.style.opacity);
}

function scale(number, inMin, inMax, outMin, outMax) {
  return ((number - inMin) * (outMax - outMin)) / (inMax - inMin) + outMin;
}

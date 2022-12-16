const open = document.getElementById("open");
const close = document.getElementById("close");
const container = document.querySelector(".container");
console.log(container);

open.addEventListener("click", () => container.classList.add("show-nav"));

// console.log(container.classList);

close.addEventListener("click", () => container.classList.remove("show-nav"));

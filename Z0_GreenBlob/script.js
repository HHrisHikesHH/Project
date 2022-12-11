console.log("Hello Madar Fuker");

const canvas = document.getElementById("gameArea");
const ctx = canvas.getContext("2d"); //tells 2D 3D

let radius = 20,
  x = radius,
  y = radius;

let downPress = false;
let upPress = false;
let leftPress = false;
let rightPress = false;
let speed = 20;

function drawGame() {
  //   console.log(x++, y++);
  requestAnimationFrame(drawGame); //draw in loop
  clearScreen();
  drawGreenBlob();
  inputs();
}

function inputs() {
  if (downPress) {
    y += speed;
    if (y >= canvas.height - radius) y = canvas.height - radius;
    //     downPress = false;
  }
  if (upPress) {
    y -= speed;
    if (y <= radius) y = radius;
    //     upPress = false;
  }
  if (rightPress) {
    x += speed;
    if (x >= canvas.width - radius) x = canvas.width - radius;
    //     downPress = false;
  }
  if (leftPress) {
    x -= speed;
    if (x <= radius) x = radius;
    //     upPress = false;
  }
}

function drawGreenBlob() {
  ctx.fillStyle = "greenYellow";
  ctx.beginPath();
  ctx.arc(x, y, radius, 0, Math.PI * 2);
  ctx.fill();
}

function clearScreen() {
  ctx.fillStyle = "black";
  ctx.fillRect(0, 0, canvas.width, canvas.height);
}

document.body.addEventListener("keydown", keyDown);
document.body.addEventListener("keyup", keyUp);
// document.body.addEventListener("keyleft", keyLeft);
// document.body.addEventListener("keyright", keyRight);

function keyDown(event) {
  if (event.keyCode == 38) {
    upPress = true;
  }
  if (event.keyCode == 40) {
    downPress = true;
  }
  if (event.keyCode == 37) {
    leftPress = true;
  }
  if (event.keyCode == 39) {
    rightPress = true;
  }
}

function keyUp(event) {
  if (event.keyCode == 38) {
    upPress = false;
  }
  if (event.keyCode == 40) {
    downPress = false;
  }
  if (event.keyCode == 37) {
    leftPress = false;
  }
  if (event.keyCode == 39) {
    rightPress = false;
  }
}

drawGame();
// setInterval(drawGame, 700); // draw game in loop

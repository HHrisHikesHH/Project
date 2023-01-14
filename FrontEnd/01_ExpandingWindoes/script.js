const panels = document.querySelectorAll('.panel')

const i1 = document.querySelector('#img1')
const i2 = document.querySelector('#img2')
const i3 = document.querySelector('#img3')
const i4 = document.querySelector('#img4')
const i5 = document.querySelector('#img5')

i1.addEventListener('click', () => {
       // i1.style.backgroundImage = "url('https://images.pexels.com/photos/461956/pexels-photo-461956.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2')"; 
       img1.style.backgroundColour = "black";
})

panels.forEach(panel => {
       panel.addEventListener('click', () => {
              makeUnActive();
              panel.classList.add('active')
       })
})

function makeUnActive() {
       panels.forEach(panel => {
              panel.classList.remove('active')
       })
}

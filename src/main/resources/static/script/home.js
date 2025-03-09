let slideIndex = 0;

function moveSlide(direction) {
  const slider = document.getElementById('slider');
  const slides = document.querySelectorAll('.destination');
  const slideWidth = slides[0].offsetWidth + 20; // Includes margin

  slideIndex += direction;

  // Loop back if at the ends
  if (slideIndex < 0) slideIndex = slides.length - 1;
  if (slideIndex >= slides.length) slideIndex = 0;

  const offset = -(slideWidth * slideIndex);
  slider.style.transform = `translateX(${offset}px)`;
}

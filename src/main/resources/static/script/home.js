document.addEventListener("DOMContentLoaded", function () {
  const slider = document.querySelector(".destination-grid");
  const destinations = document.querySelectorAll(".destination");
  const totalDestinations = destinations.length;
  const imagesPerSlide = 4; // Show 4 images at a time
  let currentIndex = 0;

  function updateSlider() {
      const offset = -currentIndex * (100 / imagesPerSlide) + "%"; // Moves only on click
      slider.style.transition = "transform 5s ease-in-out"; // Smooth 5s transition
      slider.style.transform = `translateX(${offset})`;
  }

  document.querySelector(".next").addEventListener("click", function () {
      if (currentIndex + imagesPerSlide < totalDestinations) {
          currentIndex += imagesPerSlide;
          updateSlider();
      }
  });

  document.querySelector(".prev").addEventListener("click", function () {
      if (currentIndex > 0) {
          currentIndex -= imagesPerSlide;
          updateSlider();
      }
  });
});

// const widgetProductForm = document.getElementById('widgetProductForm');
// const modal = document.querySelector('.widgetModal');
// function openModal() {
//     modal.classList.remove('d-none');
// }

// function closeModal() {
//     modal.classList.add('d-none');
// }
// let display = document.getElementsByClassName("widgetModal");
// let button = document.getElementById("addWidgetListbtn");
// button.textContent = "add widget";
// button.addEventListener("click", () => {
//     display.style.display = "block";
// });

const modal = document.querySelector('.widgetModal');
const addWidgetButton = document.getElementById("addWidgetListbtn");
const closeButton = document.querySelector(".cross-icon button");

// Ensure the modal is hidden by default
modal.style.display = "none";

// Function to open the modal when clicking "Add Widget"
function openModal() {
    modal.style.display = "block"; // Show modal
}

// Function to close the modal when clicking the close button
function closeModal() {
    modal.style.display = "none"; // Hide modal
}

// Ensure the "Add Widget" button correctly opens the modal
addWidgetButton.textContent = "Add Widget";
addWidgetButton.addEventListener("click", (event) => {
    event.preventDefault(); // Prevent default button behavior
    openModal();
});

// Ensure the close button correctly closes the modal
closeButton.addEventListener("click", closeModal);

// Form validation before submission
document.querySelector("form").addEventListener("submit", function (event) {
    let sequenceInput = document.querySelector('input[name="sequence"]');

    if (!sequenceInput.value.trim()) {
        alert("Sequence is required and must be a number!");
        event.preventDefault(); // Prevent form submission
    }
});
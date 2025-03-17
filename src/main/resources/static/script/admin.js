document.addEventListener("DOMContentLoaded", function () {
    let currentUrl = window.location.pathname;
    let menuItems = document.querySelectorAll(".sidebar ul li a");

    menuItems.forEach(item => {
        if (item.getAttribute("href") === currentUrl) {
            item.classList.add("active");
        }
    });
});

function openModal() {
    document.querySelector('.modal-overlay').style.display = 'block';
}

function closeModal() {
    document.querySelector('.modal-overlay').style.display = 'none';
}
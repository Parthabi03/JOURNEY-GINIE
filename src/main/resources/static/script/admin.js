document.addEventListener("DOMContentLoaded", function () {
    let currentUrl = window.location.pathname;
    let menuItems = document.querySelectorAll(".sidebar ul li a");

    menuItems.forEach(item => {
        if (item.getAttribute("href") === currentUrl) {
            item.classList.add("active");
        }
    });
});

// function openModal(){
//     console.log("admin js");

// }

async function openModal(destinationId = null) {
    document.querySelector('.modal-overlay').style.display = 'block';
    // document.getElementById("modalContent").style.display = "block";
    console.log(destinationId);

    if (destinationId) {
        const response = await fetch(`/admin/destinations/${destinationId}`).catch((err) =>
            console.error(err)
        );

        const destination = await response.json();
        console.log(destination);

        updateFields(destination);
    }
}

function updateFields(destination) {
    document.getElementById('destination-name').value = destination.destinationName;
    document.getElementById('description').value = destination.description;
    document.getElementById('country').value = destination.country;
    document.getElementById('city').value = destination.city;
    document.getElementById('price').value = destination.price;

    document.getElementById('destImage').value = destination.imageUrl;
    document.getElementById('destinationId').value = destination.destinationId;
}
function closeModal() {
    document.querySelector('.modal-overlay').style.display = 'none';
}

// Event Listener for Close Button
document.querySelector(".close-btn").addEventListener("click", closeModal);

// Close Modal When Clicking Outside
document.querySelector(".modal-overlay").addEventListener("click", function (event) {
    if (event.target.classList.contains("modal-overlay")) {
        closeModal();
    }
});

// Close Modal When Pressing Escape Key
document.addEventListener("keydown", function (event) {
    if (event.key === "Escape") {
        closeModal();
    }
});
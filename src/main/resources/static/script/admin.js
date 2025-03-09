function openModal() {
    document.getElementById("destinationModal").style.display = "block";
}

// Close Modal
function closeModal() {
    document.getElementById("destinationModal").style.display = "none";
}

// Handle Form Submission
document.getElementById("destinationForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent default form submission

    // Get Form Data
    const name = document.getElementById("destinationName").value;
    const description = document.getElementById("destinationDescription").value;
    const status = document.getElementById("destinationStatus").value;

    console.log("Destination Added:", { name, description, status });

    // Close Modal
    closeModal();

    // Redirect to Destination Table
    window.location.href = "/dashboard/destination-table"; // Update to your actual path
});

// Close modal when clicking outside the modal content
window.onclick = function(event) {
    const modal = document.getElementById("destinationModal");
    if (event.target === modal) {
        closeModal();
    }
}
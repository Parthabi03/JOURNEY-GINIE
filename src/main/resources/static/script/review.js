function submitReview() {
    let name = document.getElementById("reviewer-name").value;
    let text = document.getElementById("review-text").value;

    if (name.trim() === "" || text.trim() === "") {
        alert("Please enter your name and review.");
        return;
    }

    let newReview = document.createElement("div");
    newReview.classList.add("review-box");
    newReview.innerHTML = `
        <h3>${name}</h3>
        <div class="rating">⭐⭐⭐⭐⭐</div>
        <p>"${text}"</p>
        <button class="delete-review" onclick="deleteReview(this)">❌ Delete</button>
    `;

    document.querySelector(".reviews-container").appendChild(newReview);
    
    // Clear input fields after submission
    document.getElementById("reviewer-name").value = "";
    document.getElementById("review-text").value = "";
}

// 🔹 Delete function to remove a review
function deleteReview(button) {
    let reviewBox = button.parentElement; // Get the parent review box
    reviewBox.remove(); // Remove it from the page
}

// JavaScript for handling the Add Destination modal

// document.addEventListener("DOMContentLoaded", () => {
//     const addButton = document.querySelector(".add-destination-btn");
//     const formOverlay = document.getElementById("formOverlay");
//     const closeFormButton = document.getElementById("closeForm");
  
    // Open the modal
    // addButton.addEventListener("click", () => {
    //   formOverlay.style.display = "flex";
    // });
  
    // Close the modal when clicking the cancel button
    // closeFormButton.addEventListener("click", () => {
    //   formOverlay.style.display = "none";
    // });
  
    // Close the modal when clicking outside the form
    // formOverlay.addEventListener("click", (e) => {
    //   if (e.target === formOverlay) {
    //     formOverlay.style.display = "none";
    //   }
    // });
  
    // Handle form submission
    // const destinationForm = document.getElementById("destinationForm");
    // destinationForm.addEventListener("submit", (e) => {
    //   e.preventDefault();
  
      // Get form data
      // const destName = document.getElementById("destName").value;
      // const destDescription = document.getElementById("destDescription").value;
      // const destCountry = document.getElementById("destCountry").value;
      // const destCity = document.getElementById("destCity").value;
      // const destImage = document.getElementById("destImage").value;
  
      // Add new row to table
      // const table = document.querySelector("table tbody");
      // const newRow = document.createElement("tr");
  
      // newRow.innerHTML = `
      //   <td>${destName}</td>
      //   <td>${destDescription}</td>
      //   <td>${destCountry}</td>
      //   <td>${destCity}</td>
      //   <td>${destImage}</td>
      // `;
  
      // table.appendChild(newRow);
  
      // Reset form and close modal
  //     destinationForm.reset();
  //     formOverlay.style.display = "none";
  //   });
  // });
  
  document.addEventListener("DOMContentLoaded", () => {
    const addButton = document.querySelector(".add-destination-btn");
    const formOverlay = document.getElementById("formOverlay");
    const closeFormButton = document.getElementById("closeForm");
    const destinationForm = document.getElementById("destinationForm");

    // Open the modal
    addButton.addEventListener("click", () => {
        formOverlay.style.display = "flex";
    });

    // Close the modal
    closeFormButton.addEventListener("click", () => {
        formOverlay.style.display = "none";
    });

    // Handle form submission
    destinationForm.addEventListener("submit", (event) => {
        console.log("Submit button clicked!"); // Debugging log

        // Check if the form is submitting properly
        if (!destinationForm.checkValidity()) {
            console.log("Form validation failed.");
            return; // Stop submission if invalid fields exist
        }

        console.log("Form is valid. Submitting...");

        // Let the form submit normally to the server
    });
});

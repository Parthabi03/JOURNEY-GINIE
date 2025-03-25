let editIndex = null;

// async function openModal(destinationId = null) {
//   document.getElementById("modal-overlay").style.display = "block";
//   document.getElementById("modalContent").style.display = "block";
//   console.log(destinationId);
  
//   if (destinationId) {
//     const response = await fetch(`/admin/destinations/${destinationId}`).catch((err) =>
//       console.error(err)
//     );

//     const destination = await response.json();
//     console.log(destination);
    
//     updateFields(destination);
//   }
// }

// function updateFields(destination) {
//     document.getElementById('destination-name').value = destination.destinationName;
//     document.getElementById('description').value = destination.description;
//     document.getElementById('country').value = destination.country;
//     document.getElementById('city').value = destination.city;
//     document.getElementById('price').value = destination.price;
//     document.getElementById('status').value = destination.status;

//     document.getElementById('imageUrl').value = destination.imageUrl;
//     document.getElementById('destinationId').value = destination.destinationId;
// }

function closeModal() {
  document.getElementById("overlay").style.display = "none";
  document.getElementById("product-modal").style.display = "none";
}

function saveDestination() {
  
  closeModal();
}

function deleteDestination(element) {
  element.parentElement.parentElement.remove();
}

function editDestination(element) {
  openModal(true, element.parentElement.parentElement);
}

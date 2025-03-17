let selectedValues = [];

function updateSelection(checkbox) {
    if (checkbox.checked) {
        if (!selectedValues.includes(checkbox.value)) {
            selectedValues.push(checkbox.value);
        }
    } else {
        selectedValues = selectedValues.filter(id => id !== checkbox.value);
    }
    updateSelectedItems();
}

function updateSelectedItems() {
    let selectedContainer = document.getElementById("selectedItems");
    selectedContainer.innerHTML = "";

    selectedValues.forEach(id => {
        let label = document.querySelector(`input[value="${id}"]`).nextElementSibling.textContent.trim();
        let tag = document.createElement("div");
        tag.className = "tag";
        tag.innerHTML = `${label} <span class="remove" onclick="removeItem('${id}')">&times;</span>`;
        selectedContainer.appendChild(tag);
    });
}

function removeItem(id) {
    selectedValues = selectedValues.filter(item => item !== id);
    document.querySelector(`input[value="${id}"]`).checked = false;
    updateSelectedItems();
}

function toggleDropdown() {
    document.getElementById("optionsContainer").classList.toggle("show");
}

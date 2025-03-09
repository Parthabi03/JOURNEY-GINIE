document.addEventListener("DOMContentLoaded", function () {
    const paymentForm = document.getElementById("payment-form");

    paymentForm.addEventListener("submit", function (e) {
        e.preventDefault();

        let cardNumber = document.getElementById("card-number").value.replace(/\s+/g, '');
        let expiryDate = document.getElementById("expiry-date").value;
        let cvv = document.getElementById("cvv").value;

        if (cardNumber.length !== 16 || isNaN(cardNumber)) {
            alert("Invalid Card Number! Please enter a 16-digit card number.");
            return;
        }

        if (!/^(0[1-9]|1[0-2])\/\d{2}$/.test(expiryDate)) {
            alert("Invalid Expiry Date! Use MM/YY format.");
            return;
        }

        if (cvv.length !== 3 || isNaN(cvv)) {
            alert("Invalid CVV! Enter a 3-digit code.");
            return;
        }

        alert("Payment Successful! Thank you for choosing Journey Ginnie.");
        paymentForm.reset();
    });
});

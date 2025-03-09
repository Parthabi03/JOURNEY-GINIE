document.addEventListener("DOMContentLoaded", function () {
    // Sidebar menu interaction
    document.querySelectorAll(".sidebar ul li").forEach(item => {
        item.addEventListener("click", () => {
            document.querySelectorAll(".sidebar ul li").forEach(li => li.classList.remove("active"));
            item.classList.add("active");
        });
    });

    // Chart.js for User Growth
    const ctx = document.getElementById("userChart").getContext("2d");
    const userChart = new Chart(ctx, {
        type: "line",
        data: {
            labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun"],
            datasets: [{
                label: "New Users",
                data: [50, 75, 150, 200, 250, 300],
                backgroundColor: "rgba(59, 130, 246, 0.2)",
                borderColor: "#3B82F6",
                borderWidth: 2,
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
        }
    });
});

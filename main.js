document.getElementById('login-form').addEventListener('submit', async function (e) {
    e.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const message = document.getElementById('message');


    e.preventDefault();



    try {
        const response = await fetch("http://localhost:8080/user/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },



            body: JSON.stringify({ username, password }),
        });

        const data = await response.json();

        if (response.ok) {
            document.getElementById("message").innerText = data.message;
            message.textContent = 'Login successful!';
            message.style.color = 'green';
            // redirect or save token here
            // window.location.href = "/dashboard.html";
        } else {
            document.getElementById("message").innerText = data.message;
            message.style.color = 'red';
            message.textContent = 'Invalid username or password.';
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Something went wrong!");
    }
});



function ValidateUsername() {

    const username = document.getElementById("username").value.trim();
    const usernameError = document.getElementById("usernameError");
    usernameError.textContent = ""; // clear old errors


    const usernamePattern = /^[a-zA-Z0-9_]+$/;

    if (username === "") {
        usernameError.textContent = "Username is required.";
        return false;
    }
    else if (username.length < 4 || username.length > 15) {
        usernameError.textContent = "Username must be 4–15 characters long.";
        return false;
    }
    else if (!usernamePattern.test(username)) {
        usernameError.textContent = "Only letters, numbers, and underscores are allowed.";
        return false;
    }


    return true;

}
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("hello").addEventListener("submit", async function (e) {
        e.preventDefault();
        try {
            const userId = 0;
            const productId = 1;
            const message = document.getElementById('message');
            const response = await fetch(
                `http://localhost:8081/Cart/add?userId=${userId}&productId=${productId}`,
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                }
            );
            console.log("yash");

            const data = await response.json();

            if (response.ok) {
                message.textContent = data.message || "Product added to cart!";
                message.style.color = "green";
            } else {
                message.textContent = data.message || "Failed to add product!";
                message.style.color = "red";
            }


        } catch (error) {
            console.error("Error:", error);
            alert("Something went wrong!");
        }

    });
});



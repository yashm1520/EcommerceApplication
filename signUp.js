const form = document.querySelector('form');
form.addEventListener('submit', async function (e) {
    e.preventDefault();

    const userName = document.getElementById('name').value;
    const name = document.getElementById('name').value;
    const password = document.getElementById('confirmPassword').value;
    const message = document.getElementById('message');
    const role = 1;


    const formData = new FormData(form);
    const datal = Object.fromEntries(formData.entries());



    try {




        let roles = [
            { id: 1 }

        ];
        const response = await fetch("http://localhost:8080/user/signUp", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },



            body: JSON.stringify({ name, userName, password, roles }),
        });

        const data = await response.json();

        if (response.ok) {
            document.getElementById("message").innerText = data.message;
            message.textContent = 'SignUp successful!';
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
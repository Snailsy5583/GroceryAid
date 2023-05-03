const registerForm = document.getElementById('signup');
const registerEmail = document.getElementById('email');
const registerUsername = document.getElementById('username');
const registerPassword = document.getElementById('password');

const headers = {
    'Content-Type':'application/json'
};


const handleSubmit = async (e) =>{
    e.preventDefault();

    let bodyObj = {
        email: registerEmail.value,
        username: registerUsername.value,
        password: registerPassword.value
    };

    const response = await fetch("http://localhost:8080/api/v1/users/register", {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    }).catch(err => console.error(err.message));

    const responseArr = await response.json();

    if (response.status === 200) {
        window.location.replace(responseArr[0]);
    };
}

registerForm.addEventListener("submit", handleSubmit);
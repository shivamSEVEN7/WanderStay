// JavaScript to handle button clicks
document.getElementById('ownerSignUp').addEventListener('click', () => {
    alert('Redirecting to Owner Sign-Up page...');
    // Add redirection logic here
});

document.getElementById('userSignUp').addEventListener('click', () => {

});

document.getElementById('loginForm').addEventListener('submit', (event) => {
    event.preventDefault(); // Prevent form from submitting for now
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    alert(`Email: ${email}\nPassword: ${password}`);
    // Add login validation and submission logic here
});
/*Profile Page*/
document.getElementById('userSignUp').addEventListener('click', () => {

});
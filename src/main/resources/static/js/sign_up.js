function validateForm() {
	var fullname = document.getElementsByName("fullname")[0].value;
	var email = document.getElementsByName("email")[0].value;
	var username = document.getElementsByName("username")[0].value;
	var password = document.getElementsByName("password")[0].value;
	var confirmPassword = document.getElementsByName("confirm-password")[0].value;

	var errorMessage = document.getElementById("error-message");
	var passwordError = document.getElementById("password-error");

	errorMessage.style.display = "none";
	passwordError.style.display = "none";

	if (fullname === "" || email === "" || username === "" || password === "" || confirmPassword === "") {
		errorMessage.style.display = "block";
		return false;
	}

	if (password !== confirmPassword) {
		passwordError.style.display = "block";
		return false;
	}

	return true;
}
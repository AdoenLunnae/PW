
function isValid(val) {
    const hasNumber = /.*\d.*/;
    const hasLetter = /.*[A-Za-z].*/;
    const strongRegex = /^[A-Za-z0-9._\-]{7,}$/;
    const hasInvalidCharacters = /.*[^A-Za-z0-9._\-].*/;
    
    return hasNumber.test(val) && hasLetter.test(val) && strongRegex.test(val) && !hasInvalidCharacters.test(val);
}

function validatePassword() {
    const password = document.getElementById("password");
    if (isValid(password.value)) {
        document.getElementById("invalid-pass-message").className = "pass-error-message-off";
        return true;
    } else {
        document.getElementById("invalid-pass-message").className = "pass-error-message-on";
        return false;
    }
}

function passwordsMatch() {
    const password = document.getElementById("password");
    const password2 = document.getElementById("password2");
    document.getElementById("submit-button").disabled = true;
    if(password.value === password2.value) {
        document.getElementById("pass-match-message").className = "pass-error-message-off";
        return true;
    } else {
        document.getElementById("pass-match-message").className = "pass-error-message-on";
        return false;
    }
}

function checkPass(){
	document.getElementById("submit-button").disabled = true;
	const passIsValid = validatePassword();
	const passMatch = passwordsMatch(); 
    if(passIsValid && passMatch){
    	document.getElementById("submit-button").disabled = false;
    }
}

function isValid(val) {
    const hasNumber = /.*\d.*/;
    const hasLetter = /.*[A-Za-z].*/;
    const strongRegex = /^[A-Za-z0-9._\-]{7,}$/;
    //console.log(re.test(val))
    return hasNumber.test(val) && hasLetter.test(val) && strongRegex.test(val);
}

function validatePassword() {
    const password = document.getElementsByName("password")[0];
    if (isValid(password.value)) {
        document.getElementById("invalid-pass-message").style.visibility = "hidden";
        document.getElementById("invalid-pass-message").style.height = "0";
    } else {
        document.getElementById("invalid-pass-message").style.visibility = "visible";
        document.getElementById("invalid-pass-message").style.height = "auto";
    }
}

function passwordsMatch() {
    const password = document.getElementsByName("password")[0];
    const password2 = document.getElementsByName("password2")[0];
    if(password.value === password2.value) {
        document.getElementById("pass-match-message").style.visibility = "hidden";
        document.getElementById("pass-match-message").style.height = "0";
    } else {
        document.getElementById("pass-match-message").style.visibility = "visible";
        document.getElementById("pass-match-message").style.height = "auto";
    }
}
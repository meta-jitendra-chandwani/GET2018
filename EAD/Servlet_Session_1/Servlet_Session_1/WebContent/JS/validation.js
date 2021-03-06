/**
 * nameValidation - Validation of first and last name text input
 * using regex - which only accept A-Z and a-z as input in text field
 * check whether the length of input is greater than 2 and sastisfy regex or not.
 */
function nameValidation(Value) {
    var regex = /^[A-Z,a-z]+$/
    var checkName = document.getElementById(Value.id).value;
    var erromessage = document.getElementById(Value.id+"_error");
    checkName.length > 2 && regex.test(checkName) ? erromessage.style.visibility = "hidden" : erromessage.style.visibility = "visible";
}

/**
 * mailValidation - Validation of email text input
 * using regex - which only accept email as input in text field
 * check whether input sastisfy regex or not.
 */
function mailValidation() {
    var regex = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    var email = document.getElementById("email_id").value;
    var erromessage = document.getElementById("email_id_error");
    regex.test(email) ? erromessage.style.visibility = "hidden" : erromessage.style.visibility = "visible";
}

/**
 * validatePassword - Validation of passowrd input
 * using regex - which only accept atleast 1 Captial 1 small alphabet and 1 number and special character as input in text field
 * check whether input sastisfy regex or not.
 */
function validatePassword() {
    var password = document.getElementById("password_id").value;
    var confirmPassword = document.getElementById("password_repeat_id").value;
    var regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,20}$/;
    var errormessage = document.getElementById("password_id_error");
    var correctmessage = document.getElementById("password_id_correct");
    var passwordDoesntMatch = document.getElementById("password_doesnt_match");
    if (password == confirmPassword) {
        if (regex.test(password)) {
            errormessage.style.visibility = "hidden"
            passwordDoesntMatch.style.visibility = "hidden";
            correctmessage.style.visibility = "visible";
        } else {
            correctmessage.style.visibility = "hidden"
            passwordDoesntMatch.style.visibility = "hidden";
            errormessage.style.visibility = "visible";
        }
    } else {
        correctmessage.style.visibility = "hidden"
        errormessage.style.visibility = "hidden"
        passwordDoesntMatch.style.visibility = "visible";
    }
}
/**
 * showPassword - show password that user enter in text format
 */
function showPassword() {
    var showPassword = document.getElementById("password_id");
    showPassword.type === "password" ? showPassword.type = "text" : showPassword.type = "password";
}

/**
 * validatePassword - Validation of passowrd input
 * using regex - which only accept atleast 1 Captial 1 small alphabet and 1 number and special character as input in text field
 * check whether input sastisfy regex or not.
 */
function validateContact() {
    var contact = document.getElementById("contact_id").value;
    var errormessage = document.getElementById("contact_id_error");
    contact.length > 8 && (!isNaN(contact)) ? errormessage.style.visibility = "hidden" : errormessage.style.visibility = "visible";
}
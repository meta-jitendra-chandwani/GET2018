function nameValidation() {
    debugger;
    var regex = /^[A-Z,a-z]+$/
    var checkNAME = document.getElementById("first_name").value;
    var erromessage = document.getElementById("first_name_error");
    if (checkNAME.length > 2 && regex.test(checkNAME)) {
        erromessage.style.visibility = "hidden";
    }
    else {
        erromessage.style.visibility = "visible";
    }
}

function lastNameValidation() {
    debugger;
    var regex = /^[A-Z,a-z]+$/;
    var checkNAME = document.getElementById("last_name").value;
    var erromessage = document.getElementById("last_name_error");
    if (checkNAME.length > 2 && regex.test(checkNAME)) {
        erromessage.style.visibility = "hidden";
    }
    else {
        erromessage.style.visibility = "visible";
    }
}

function mailValidation() {
    debugger;
    var regex = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    var email = document.getElementById("email_id").value;
    var erromessage = document.getElementById("email_id_error");
    if (regex.test(email)) {
        erromessage.style.visibility = "hidden";
    } else {
        erromessage.style.visibility = "visible";
    }

}

function validatePassword() {
    debugger;
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


function showPassword() {
    var x = document.getElementById("password_id");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

function validateContact() {
    debugger;
    var contact = document.getElementById("contact_id").value;
    var errormessage = document.getElementById("contact_id_error");    
    if (contact.length > 8 && (!isNaN(contact))) {
        errormessage.style.visibility = "hidden";
    } else {
        errormessage.style.visibility = "visible";
    }
}

function registration() {
    debugger;
    var home = document.getElementById("homeSignUp");
    var name = document.getElementById("first_name");
    alert(name.value);
    home.innerHTML = name.value;
    alert(home.value);
}

function click(){

}
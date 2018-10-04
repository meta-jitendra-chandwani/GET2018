function addElement() {
    var form = document.getElementById("registration-form");
    var formElementCount = form.getElementsByClassName("flex-block").length;
    if (formElementCount > 8) {
        var element1 = form.getElementsByClassName("flex-block")[7];
        var element2 = form.getElementsByClassName("flex-block")[8];
        form.removeChild(element1);
        form.removeChild(element2);
    }
    var state = document.getElementById("state").value;
    if (state == "Haryana") {
        addZipCodeField();
        addRadioButtonField();
    }
    if (state == "Rajasthan") {
        addWebsiteField();
        addProjectDescriptionField();
    }
    if (state == "Maharashtra") {
        addZipCodeField();
        addProjectDescriptionField();
    }
}

function addWebsiteField() {
    var form = document.getElementById("registration-form");
    var submitButton = document.getElementById("submit-button");
    var parentDiv = document.createElement("div");
    parentDiv.setAttribute("class", "flex-block");
    var childDiv1 = document.createElement("div");
    childDiv1.setAttribute("class", "flex-item-right");
    var elementLabel = document.createTextNode("Website or domain name");
    childDiv1.appendChild(elementLabel);
    parentDiv.appendChild(childDiv1);
    var childDiv2 = document.createElement("div");
    childDiv2.setAttribute("class", "flex-item-left");
    var icon = document.createElement("i");
    icon.setAttribute("class", "fas fa-globe-americas");
    childDiv2.appendChild(icon);
    var websiteField = document.createElement("input");
    websiteField.setAttribute("type", "text");
    websiteField.setAttribute("id", "website");
    websiteField.setAttribute("name", "website");
    websiteField.setAttribute("required", "required");
    websiteField.setAttribute("placeholder", "Website or domain name");
    childDiv2.appendChild(websiteField);
    parentDiv.appendChild(childDiv2);
    form.insertBefore(parentDiv, submitButton);
}

function addProjectDescriptionField() {
    var form = document.getElementById("registration-form");
    var submitButton = document.getElementById("submit-button");
    var parentDiv = document.createElement("div");
    parentDiv.setAttribute("class", "flex-block");
    var childDiv1 = document.createElement("div");
    childDiv1.setAttribute("class", "flex-item-right");
    var elementLabel = document.createTextNode("Project Description");
    childDiv1.appendChild(elementLabel);
    parentDiv.appendChild(childDiv1);
    var childDiv2 = document.createElement("div");
    childDiv2.setAttribute("class", "flex-item-left");
    var icon = document.createElement("i");
    icon.setAttribute("id", "project-description-icon");
    icon.setAttribute("class", "fas fa-pen text-area-icon");
    childDiv2.appendChild(icon);
    var descriptionField = document.createElement("textarea");
    descriptionField.setAttribute("rows", 3);
    descriptionField.setAttribute("cols", 30);
    descriptionField.setAttribute("id", "project-description");
    descriptionField.setAttribute("name", "project-description");
    descriptionField.setAttribute("required", "required");
    descriptionField.setAttribute("placeholder", "Project Description");
    childDiv2.appendChild(descriptionField);
    parentDiv.appendChild(childDiv2);
    form.insertBefore(parentDiv, submitButton);
}

function addZipCodeField() {
    var form = document.getElementById("registration-form");
    var submitButton = document.getElementById("submit-button");
    var parentDiv = document.createElement("div");
    parentDiv.setAttribute("class", "flex-block");
    var childDiv1 = document.createElement("div");
    childDiv1.setAttribute("class", "flex-item-right");
    var elementLabel = document.createTextNode("Zip Code");
    childDiv1.appendChild(elementLabel);
    parentDiv.appendChild(childDiv1);
    var childDiv2 = document.createElement("div");
    childDiv2.setAttribute("class", "flex-item-left");
    var icon = document.createElement("i");
    icon.setAttribute("class", "fas fa-home");
    childDiv2.appendChild(icon);
    var zipcodeField = document.createElement("input");
    zipcodeField.setAttribute("type", "number");
    zipcodeField.setAttribute("id", "zip-code");
    zipcodeField.setAttribute("name", "zip-code");
    zipcodeField.setAttribute("maxlength", "6");
    zipcodeField.setAttribute("required", "required");
    zipcodeField.setAttribute("placeholder", "Zip Code");
    childDiv2.appendChild(zipcodeField);
    parentDiv.appendChild(childDiv2);
    form.insertBefore(parentDiv, submitButton);
}

function addRadioButtonField() {
    var form = document.getElementById("registration-form");
    var submitButton = document.getElementById("submit-button");
    var parentDiv = document.createElement("div");
    parentDiv.setAttribute("class", "flex-block");
    var childDiv1 = document.createElement("div");
    childDiv1.setAttribute("class", "flex-item-right");
    var elementLabel = document.createTextNode("Do you have hosting ?");
    childDiv1.appendChild(elementLabel);
    parentDiv.appendChild(childDiv1);
    var childDiv2 = document.createElement("div");
    childDiv2.setAttribute("class", "flex-radio-button");
    var label1 = document.createElement("label");
    var yesRadioButton = document.createElement("input");
    yesRadioButton.setAttribute("type", "radio");
    yesRadioButton.setAttribute("id", "hosting");
    yesRadioButton.setAttribute("name", "hosting");
    yesRadioButton.setAttribute("value", "yes");
    var yesLabel = document.createTextNode("Yes");
    label1.appendChild(yesRadioButton);
    label1.appendChild(yesLabel);
    var label2 = document.createElement("label");
    var noRadioButton = document.createElement("input");
    noRadioButton.setAttribute("type", "radio");
    noRadioButton.setAttribute("id", "hosting");
    noRadioButton.setAttribute("name", "hosting");
    noRadioButton.setAttribute("value", "no");
    var noLabel = document.createTextNode("No");
    label2.appendChild(noRadioButton);
    label2.appendChild(noLabel);
    childDiv2.appendChild(label1);
    childDiv2.appendChild(label2);
    parentDiv.appendChild(childDiv2);
    form.insertBefore(parentDiv, submitButton);
}


function validation() {
    var errorMessage = "";
    var returnValue = [];
    var index = 0;
    debugger
    returnValue[index++] = validateName();
    returnValue[index++] = validateEmail();
    returnValue[index++] = validatePhone();
    returnValue[index++] = validateCity();
    if (document.getElementById("state").value == "Haryana" || document.getElementById("state").value == "Maharashtra") {
        returnValue[index++] = validateZipCode();
    }
    var error = false;
    for (i = 0; i < index; i++) {
        if (!returnValue[i].status) {
            error = true;
            errorMessage += returnValue[i].id + " : " + returnValue[i].message + "\n";
        }
    }
    debugger;
    if (error) {
        alert(errorMessage);
        error = false;
        return false;
    }
    return true;
}

function validateName() {
    var re = /^[A-Za-z]+$/;
    var returnValue;
    var firstName = document.getElementById("first-name").value;
    var lastName = document.getElementById("last-name").value;
    if ((firstName.length > 2 && re.test(firstName)) && (lastName.length > 2 && re.test(lastName))) {
        returnValue = {
            status: true,
            id: null,
            message: null
        };
    } else {
        returnValue = {
            status: false,
            id: "Name",
            message: "Name is not Correct"
        };
    }
    return returnValue;
}

function validateEmail() {
    var re = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    var returnValue;
    var email = document.getElementById("email").value;
    if (re.test(email)) {
        returnValue = {
            status: true,
            id: null,
            message: null
        };
    } else {
        returnValue = {
            status: false,
            id: "Email",
            message: "Email id is not Correct"
        };
    }
    return returnValue;
}

function validatePhone() {
    var returnValue;
    var contact = document.getElementById("phone").value;
    if (contact.length > 8 && (!isNaN(contact))) {
        returnValue = {
            status: true,
            id: null,
            message: null
        };
    } else {
        returnValue = {
            status: false,
            id: "Phone",
            message: "Phone # is not Correct"
        };
    }
    return returnValue;
}

function validateCity() {
    var re = /^[A-Za-z]+$/;
    var returnValue;
    var city = document.getElementById("city").value;
    if (city.length > 2 && re.test(city)) {
        returnValue = {
            status: true,
            id: null,
            message: null
        };
    } else {
        returnValue = {
            status: false,
            id: "City",
            message: "City name is not Correct"
        };
    }
    return returnValue;
}

function validateZipCode() {
    debugger;
    var zipcode = document.getElementById("zip-code").value;
    var returnValue;
    if (zipcode.length == 6 && (!isNaN(zipcode))) {
        returnValue = {
            status: true,
            id: null,
            message: null
        };
    } else {
        returnValue = {
            status: false,
            id: "Zip Code",
            message: "Zip Code is not Correct"
        };
    }
    return returnValue;
}
function formValue() {
    var urlString = window.location;
    var url = new URL(urlString);
    var state = url.searchParams.get("state");
    document.getElementById("name").innerHTML = url.searchParams.get("first-name") + " " + url.searchParams.get("last-name");
    document.getElementById("email").innerHTML = url.searchParams.get("email");
    document.getElementById("phone").innerHTML = url.searchParams.get("phone");
    document.getElementById("address").innerHTML = url.searchParams.get("address");
    document.getElementById("city").innerHTML = url.searchParams.get("city");
    document.getElementById("state").innerHTML = state
    if (state == "Rajasthan") {
        document.getElementById("label-1").innerHTML = "Website or domain name";
        document.getElementById("label-2").innerHTML = "Project Description";
        document.getElementById("value-1").innerHTML = url.searchParams.get("website");
        document.getElementById("value-2").innerHTML = url.searchParams.get("project-description");
    }
    if (state == "Maharashtra") {
        document.getElementById("label-1").innerHTML = "Zip-Code";
        document.getElementById("label-2").innerHTML = "Project Description";
        document.getElementById("value-1").innerHTML = url.searchParams.get("zip-code");
        document.getElementById("value-2").innerHTML = url.searchParams.get("project-description");
    }
    if (state == "Haryana") {
        document.getElementById("label-1").innerHTML = "Zip-Code";
        document.getElementById("label-2").innerHTML = "Do you have hosting ?";
        document.getElementById("value-1").innerHTML = url.searchParams.get("zip-code");
        document.getElementById("value-2").innerHTML = url.searchParams.get("hosting");
    }
}
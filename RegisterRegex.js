var nameError = document.getElementById("name-error");
var passwordError = document.getElementById("password-error");
var mobileNoError = document.getElementById("mobileNo-error");
var aadharNoError = document.getElementById("aadharNo-error");
var addressError = document.getElementById("address-error");
var mailIdError = document.getElementById("mailId-error");
var text;
function nameValid() {
	var userName = document.getElementById("UserName").value;
	var nameValid = '^[A-Za-z]*$';
	if (userName === 0 || userName.trim() === "") {
		text = 'Name Cannot Be Empty';
		nameError.innerHTML = text;
		return false;
	}
	if (userName.length < 4) {
		text = 'Name Must Contain Greater Than 4 Characters';
		nameError.innerHTML = text;
		return false;
	}
	if (!userName.match(nameValid)) {
		text = 'Invalid Name';
		nameError.innerHTML = text;
		return false;
	}
	nameError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function passwordValidation() {
	var password = document.getElementById('Password').value;
	let passwordValidation = /^.[A-Za-z0-9]{1,}[@#$!%^&?><]{1,}.*$/;
	if (password === null || password.trim() === "") {
		text = "Password Cannot Be Empty";
		passwordError.innerHTML = text;
		return false;
	}
	if (!password.match(passwordValidation)) {
		text = "Password Should be more than 6 characters and Must Contain @";
		passwordError.innerHTML = text;
		return false;
	}
	passwordError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function mobileNoValidation1() {
	var mobileNo = document.getElementById("MobileNumber").value;
	let mobileNoValidation1 = "[6-9][0-9]{9}";
	if (mobileNo === 0) {
		text = 'Mobile Number Cannot Be Empty';
		mobileNoError.innerHTML = text;
		return false;
	}
	if (mobileNo.length < 10 || mobileNo.length > 10) {
		text = 'Mobile Number Must Conatin 10 Digits';
		mobileNoError.innerHTML = text;
		return false;
	}
	if (!mobileNo.match(mobileNoValidation1)) {
		text = 'Invalid Mobile Number';
		mobileNoError.innerHTML = text;
		return false;
	}
	mobileNoError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function aadharNoValidation() {
	var aadharNo = document.getElementById("AadharNumber").value;
	let aadharNoValidation = "\\d{12}";
	if (aadharNo === 0) {
		text = 'Aadhar Number Cannot Be Empty';
		aadharNoError.innerHTML = text;
		return false;
	}
	if (aadharNo.length < 12 || aadharNo.length > 12) {
		text = 'Aadhar Number Must Conatin 12 Digits';
		aadharNoError.innerHTML = text;
		return false;
	}
	if (!aadharNo.match(aadharNoValidation)) {
		text = 'Invalid Aadhar Number';
		aadharNoError.innerHTML = text;
		return false;
	}
	aadharNoError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function mailIdValidation() {
	var mailId = document.getElementById("MailId").value;
	let mailIdValidation = "^(.+){5,50}[a-z,.-A-Z0-9\s]";
	if (mailId === 0) {
		text = ' Mail Id Cannot Be Empty';
		mailIdError.innerHTML = text;
		return false;

	}
	if (mailId.length < 5 || mailId.length > 50) {
		text = ' Mail Id Conatin minimum 5 and maximum 50 Characters';
		mailIdError.innerHTML = text;
		return false;
	}
	if (!mailId.match(mailIdValidation)) {
		text = 'Invalid Mail Id';
		mailIdError.innerHTML = text;
		return false;
	}
	mailIdError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function addressValidation1() {
	var address = document.getElementById("Address").value;
	let addressValidation1 = "^(.+){10,500}[a-z,.-A-Z0-9s$\]";
	if (address === 0) {
		text = ' Address Cannot Be Empty and Must Include  ,.-numbers,a-zA-Z ';
		addressError.innerHTML = text;
		return false;

	}
	if (address.length < 10 || address.length > 500) {
		text = ' Address  Must Conatin minimum 10 and maximum 500 Characters';
		addressError.innerHTML = text;
		return false;
	}
	if (!address.match(addressValidation1)) {
		text = 'Invalid Address';
		addressError.innerHTML = text;
		return false;
	}
	addressError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}





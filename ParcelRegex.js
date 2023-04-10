var receiverNameError = document.getElementById("name-error");
var senderMobileNoError = document.getElementById("senderMobileNo-error");
var receiverMobileNoError = document.getElementById("receiverMobileNo-error");
var senderAddressError = document.getElementById("senderAddress-error");
var receiverAddressError = document.getElementById("receiverAddress-error");
var weightError = document.getElementById("weight-error");
var kmsError = document.getElementById("kms-error");
var text;
function regexValid() {
	var receiverName = document.getElementById("ReceiverName").value;
	var nameValidation = '^[A-Za-z]*$';
	if (receiverName === 0 || receiverName.trim() === "") {
		text = 'Name Cannot Be Empty';
		receiverNameError.innerHTML = text;
		return false;
	}
	if (receiverName.length < 4) {
		text = 'Name Must Contain Greater Than 4 Characters';
		receiverNameError.innerHTML = text;
		return false;
	}
	if (!receiverName.match(nameValidation)) {
		text = 'Invalid Name';
		receiverNameError.innerHTML = text;
		return false;
	}
	receiverNameError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function mobileNoValidation1() {
	var senderMobileNo = document.getElementById("SenderMobileNumber").value;
	let mobileNoValidation1 = "[6-9][0-9]{9}";
	if (senderMobileNo === 0) {
		text = 'Mobile Number Cannot Be Empty';
		senderMobileNoError.innerHTML = text;
		return false;
	}
	if (senderMobileNo.length < 10 || senderMobileNo.length > 10) {
		text = 'Mobile Number Must Conatin 10 Digits';
		senderMobileNoError.innerHTML = text;
		return false;
	}
	if (!senderMobileNo.match(mobileNoValidation1)) {
		text = 'Invalid Mobile Number';
		senderMobileNoError.innerHTML = text;
		return false;
	}
	senderMobileNoError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function mobileNoValidation2() {
	var receiverMobileNo = document.getElementById("ReceiverMobileNumber").value;
	let mobileNoValidation2 = "[6-9][0-9]{9}";
	if (receiverMobileNo === 0) {
		text = 'Mobile Number Cannot Be Empty';
		receiverMobileNoError.innerHTML = text;
		return false;
	}
	if (receiverMobileNo.length < 10 || receiverMobileNo.length > 10) {
		text = 'Mobile Number Must Conatin 10 Digits';
		receiverMobileNoError.innerHTML = text;
		return false;
	}
	if (!receiverMobileNo.match(mobileNoValidation2)) {
		text = 'Invalid Mobile Number';
		receiverMobileNoError.innerHTML = text;
		return false;
	}
	receiverMobileNoError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function addressValidation1() {
	var senderAddress = document.getElementById("SenderAddress").value;
	let addressValidation1 = "^(.+){10,500}[a-z,.-A-Z0-9\s]";
	if (senderAddress === 0) {
		text = 'Sender Address Cannot Be Empty';
		senderAddressError.innerHTML = text;
		return false;
	}
	if (senderAddress.length < 10 || senderAddress.length > 500) {
		text = 'Sender Address  Must Conatin minimum 10 and maximum 500 Characters';
		senderAddressError.innerHTML = text;
		return false;
	}
	if (!senderAddress.match(addressValidation1)) {
		text = 'Invalid Address';
		senderAddressError.innerHTML = text;
		return false;
	}
	senderAddressError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function addressValidation2() {
	var receiverAddress = document.getElementById("ReceiverAddress").value;
	let addressValidation2 = "^(.+){10,500}[a-z,.-A-Z0-9\s]";
	if (receiverAddress === 0) {
		text = 'Reciever Address Cannot Be Empty';
		receiverAddressError.innerHTML = text;
		return false;
	}
	if (receiverAddress.length < 10 || receiverAddress.length > 500) {
		text = 'Reciever Address  Must Conatin minimum 10 and maximum 500 Characters';
		receiverAddressError.innerHTML = text;
		return false;
	}
	if (!receiverAddress.match(addressValidation2)) {
		text = 'Invalid Address';
		receiverAddressError.innerHTML = text;
		return false;
	}
	receiverAddressError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}



function parcelWeightValidation() {
	var weight = document.getElementById("ParcelWeight").value;
	if (weight <= 0) {
		text = 'Months  Cannot Enter Zero Value and Cannot Enter Negative Values';
		weightError.innerHTML = text;
		return false;
	}
	weightError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function kmsValidation() {
	var kms = document.getElementById("Kms").value;
	if (kms <= 0) {
		text = 'Months  Cannot Enter Zero Value and Cannot Enter Negative Values';
		kmsError.innerHTML = text;
		return false;
	}
	kmsError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}





















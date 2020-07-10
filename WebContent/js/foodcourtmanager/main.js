function accountConfirmationForm() {
	var table = document.getElementById("user_list")
	if (document.getElementById("account_prompt").style.display === "none") {
		for(var i = 1, row; row = table.rows[i]; i++) {
			if (row.cells[0].children[0].checked == false) {
				row.style.display = "none";
			}
		}
		document.getElementById("account_prompt").style.display = "block";
		document.getElementById("account_main_buttons").style.display = "none";
		document.getElementById("account_remove_buttons").style.display = "";
	}
	else {
		for(var i = 1, row; row = table.rows[i]; i++) {
			row.style.display = "";
		}
		document.getElementById("account_prompt").style.display = "none";
		document.getElementById("account_main_buttons").style.display = "";
		document.getElementById("account_remove_buttons").style.display = "none";
	}
}

function newAccountForm() {
	if (document.getElementById("account_add_form").style.display === "none") {
		document.getElementById("account_add_form").style.display = "";
		document.getElementById("account_add_prompt").style.display = "";
		document.getElementById("user_list").style.display = "none";
		document.getElementById("account_main_buttons").style.display = "none";
		document.getElementById("account_add_buttons").style.display = "";
	}
	else {
		document.getElementById("account_add_form").style.display = "none";
		document.getElementById("account_add_prompt").style.display = "none";
		document.getElementById("user_list").style.display = "";
		document.getElementById("account_main_buttons").style.display = "";
		document.getElementById("account_add_buttons").style.display = "none";
	}
}

function accountEditForm(displayid) {
	if (document.getElementById("account_edit_form").style.display === "none") {
		document.getElementById("account_edit_form").style.display = "";
		document.getElementById("account_edit_prompt").style.display = "";
		document.getElementById("user_list").style.display = "none";
		document.getElementById("account_id_edit").value = displayid;
		document.getElementById("account_main_buttons").style.display = "none";
		document.getElementById("account_edit_buttons").style.display = "";
	}
	else {
		document.getElementById("account_edit_form").style.display = "none";
		document.getElementById("account_edit_prompt").style.display = "none";
		document.getElementById("user_list").style.display = "";
		document.getElementById("account_main_buttons").style.display = "";
		document.getElementById("account_edit_buttons").style.display = "none";
	}
}

function vendorConfirmationForm() {
	var table = document.getElementById("vendor_list")
	if (document.getElementById("vendor_prompt").style.display === "none") {
		for(var i = 1, row; row = table.rows[i]; i++) {
			if (row.cells[0].children[0].checked == false) {
				row.style.display = "none";
			}
		}
		document.getElementById("vendor_prompt").style.display = "block";
		document.getElementById("vendor_main_buttons").style.display = "none";
		document.getElementById("vendor_remove_buttons").style.display = "";
	}
	else {
		for(var i = 1, row; row = table.rows[i]; i++) {
			row.style.display = "";
		}
		document.getElementById("vendor_prompt").style.display = "none";
		document.getElementById("vendor_main_buttons").style.display = "";
		document.getElementById("vendor_remove_buttons").style.display = "none";
	}
}

function newVendorForm() {
	if (document.getElementById("vendor_add_form").style.display === "none") {
		document.getElementById("vendor_add_form").style.display = "";
		document.getElementById("vendor_add_prompt").style.display = "";
		document.getElementById("vendor_list").style.display = "none";
		document.getElementById("vendor_main_buttons").style.display = "none";
		document.getElementById("vendor_add_buttons").style.display = "";
	}
	else {
		document.getElementById("vendor_add_form").style.display = "none";
		document.getElementById("vendor_add_prompt").style.display = "none";
		document.getElementById("vendor_list").style.display = "";
		document.getElementById("vendor_main_buttons").style.display = "";
		document.getElementById("vendor_add_buttons").style.display = "none";
	}
}
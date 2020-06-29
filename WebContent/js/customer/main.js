function addToShoppingCart(mealID, URI, quantity) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	$('#orderSuccessModal').modal();
	    }
	};
	xhttp.open("GET", URI + "?op=add&mealID=" + mealID + "&quantity=" + quantity, true);
	xhttp.send();
}
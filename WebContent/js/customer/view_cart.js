function removeFromShoppingCart(mealID, URI, quantity) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	        $("#item" + mealID).remove();
			$("#eta").text()
	    }
	};
	xhttp.open("GET", URI + "?op=remove&mealID=" + mealID, true);
	xhttp.send();
}
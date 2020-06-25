function addToShoppingCart(mealID, URI) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      alert("added to cart");
	    }
	};
	xhttp.open("GET", URI + "?mealID=" + mealID, true);
	xhttp.send();
}
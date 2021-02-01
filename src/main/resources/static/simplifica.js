
function getFormData() {
	var one = document.getElementById("myForm").elements.namedItem("one").value;
	var two = document.getElementById("myForm").elements.namedItem("two").value;
	var three = document.getElementById("myForm").elements.namedItem("three").value;
	var four = document.getElementById("myForm").elements.namedItem("four").value;
	var five = document.getElementById("myForm").elements.namedItem("five").value;
	var six = document.getElementById("myForm").elements.namedItem("six").value;

	getCareer(one, two, three, four, five, six);

}

function getCareer(one, two, three, four, five, six) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	       // Typical action to be performed when the document is ready:
	       var bracketCareer = JSON.parse(xhttp.response);

	       document.getElementById("Career").innerHTML = bracketCareer[0];
	    }
	};
	var url = encodeURI("/convert?one=" + one + "&two=" + two + "&three=" + three + "&four=" + four + "&five=" + five + "&six=" + six);
	xhttp.open("GET", url, true);
	xhttp.send();
}
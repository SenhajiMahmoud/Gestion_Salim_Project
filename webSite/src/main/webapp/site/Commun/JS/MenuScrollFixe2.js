var header = document.querySelector("#siteWrapper header #nav-bar");

function scrolled(){
	
	var windowHeight = document.body.clientHeight,
		currentScroll = document.body.scrollTop || document.documentElement.scrollTop;
	var s = "50";
	header.className = (currentScroll >= s) ? "fixed" : "";
	
}

addEventListener("scroll", scrolled, false);
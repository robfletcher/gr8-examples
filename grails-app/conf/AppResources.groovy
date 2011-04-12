modules = {
	
	modernizr {
		resource url: "js/libs/modernizr-1.7.min.js", disposition: "head"
	}
	
	gr8 {
		resource url: "css/style.css"
		resource url: "css/handheld.css", attrs: [media: "handheld"]
	}
	
	"infinite-scroll" {
		dependsOn "jquery"
		resource url: "js/plugins/infinite-scroll.js"
	}
	
	twitter {
		dependsOn "modernizr", "gr8", "infinite-scroll"
	}
	
}
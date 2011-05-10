modules = {
	
	boilerplate {
		resource url: "css/style.css"
		resource url: "css/handheld.css", attrs: [media: "handheld"]
	}
	
	gr8 {
		dependsOn "modernizr", "boilerplate"
		resource url: "css/gr8.less" ,attrs:[rel: "stylesheet/less", type: "css"], bundle: "bundle_gr8"
	}
	
	ajaxify {
		dependsOn "jquery"
		resource "js/plugins/ajaxify.js"
	}
	
	facebox {
		dependsOn "jquery"
		resource "js/plugins/facebox/facebox.js"
		resource "js/plugins/facebox/facebox.css"
	}
	
	"infinite-scroll" {
		dependsOn "jquery"
		resource "js/plugins/infinite-scroll.js"
	}
	
	raphael {
		dependsOn "jquery"
		resource url: "js/libs/raphael-min.js", disposition: "head"
	}

	"star-rating" {
		dependsOn "jquery"
		resource "js/plugins/star-rating.js"
	}

	twitter {
		dependsOn "gr8", "infinite-scroll"
		resource "js/twitter.js"
	}

	graphs {
		dependsOn "gr8", "raphael"
        resource url: "js/graphs.js", disposition: "head"
	}
	
	rating {
		dependsOn "gr8", "star-rating"
		resource "js/rating.js"
	}
	
	basket {
		dependsOn "gr8", "facebox"
		resource "js/basket.js"
	}
	
	list {
		dependsOn "gr8", "ajaxify", "jquery-ui"
		resource "js/list.js"
	}
	
}
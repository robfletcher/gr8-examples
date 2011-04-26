modules = {
	
	modernizr {
		resource url: "js/libs/modernizr-1.7.min.js", disposition: "head"
	}
	
	boilerplate {
		resource url: "css/style.css"
		resource url: "css/handheld.css", attrs: [media: "handheld"]
	}
	
	"infinite-scroll" {
		dependsOn "jquery"
		resource "js/plugins/infinite-scroll.js"
	}
	
	twitter {
		dependsOn "modernizr", "boilerplate", "infinite-scroll"
		resource url: "css/twitter.less" ,attrs:[rel: "stylesheet/less", type: "css"], bundle: "bundle_twitter"
	}
	
	polls {
		dependsOn "modernizr", "boilerplate"
		resource url: "css/polls.less" ,attrs:[rel: "stylesheet/less", type: "css"], bundle: "bundle_polls"
	}
	
}
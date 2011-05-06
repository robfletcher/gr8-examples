modules = {
	
	modernizr {
		resource url: "js/libs/modernizr-1.7.min.js", disposition: "head"
	}
	
	boilerplate {
		resource url: "css/style.css"
		resource url: "css/handheld.css", attrs: [media: "handheld"]
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

	visualize {
		dependsOn "jquery"
		resource "js/plugins/visualize/visualize.jQuery.js"
		resource "js/plugins/visualize/css/visualize.css"
		resource "js/plugins/visualize/css/visualize-light.css"
	}
	
	"star-rating" {
		dependsOn "jquery"
		resource "js/plugins/star-rating.js"
	}

    index {
        dependsOn "modernizr", "boilerplate"
        resource url: "css/index.less" ,attrs:[rel: "stylesheet/less", type: "css"], bundle: "bundle_index"
    }
	
	twitter {
		dependsOn "modernizr", "boilerplate", "infinite-scroll"
		resource "js/twitter.js"
		resource url: "css/twitter.less" ,attrs:[rel: "stylesheet/less", type: "css"], bundle: "bundle_twitter"
	}

	graphs {
		dependsOn "modernizr", "boilerplate", "visualize"
        resource "js/graphs.js"
		resource url: "css/graphs.less" ,attrs:[rel: "stylesheet/less", type: "css"], bundle: "bundle_twitter"
	}
	
	polls {
		dependsOn "modernizr", "boilerplate"
		resource url: "css/polls.less" ,attrs:[rel: "stylesheet/less", type: "css"], bundle: "bundle_polls"
	}

	rating {
		dependsOn "modernizr", "boilerplate", "star-rating"
		resource "js/rating.js"
		resource url: "css/album.less" ,attrs:[rel: "stylesheet/less", type: "css"], bundle: "bundle_rating"
		resource url: "css/rating.less" ,attrs:[rel: "stylesheet/less", type: "css"], bundle: "bundle_rating"
	}
	
	basket {
		dependsOn "modernizr", "boilerplate", "facebox"
		resource "js/basket.js"
		resource url: "css/basket.less" ,attrs:[rel: "stylesheet/less", type: "css"], bundle: "bundle_basket"
	}
	
	list {
		dependsOn "modernizr", "boilerplate", "ajaxify"
		resource "js/list.js"
		resource url: "css/list.less" ,attrs:[rel: "stylesheet/less", type: "css"], bundle: "bundle_list"
	}
	
}
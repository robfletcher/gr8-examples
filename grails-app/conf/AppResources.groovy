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

	visualize {
		dependsOn "jquery"
		resource "js/plugins/visualize/visualize.jQuery.js"
		resource "js/plugins/visualize/css/visualize.css"
		resource "js/plugins/visualize/css/visualize-light.css"
	}

    index {
        dependsOn "modernizr", "boilerplate"
        resource url: "css/index.less" ,attrs:[rel: "stylesheet/less", type: "css"], bundle: "bundle_index"
    }
	
	scroll {
		dependsOn "modernizr", "jquery", "boilerplate", "infinite-scroll"
		resource "js/scroll.js"
		resource url: "css/scroll.less" ,attrs:[rel: "stylesheet/less", type: "css"], bundle: "bundle_scroll"
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

	forms {
		dependsOn "modernizr", "boilerplate"
		resource url: "css/forms.less" ,attrs:[rel: "stylesheet/less", type: "css"], bundle: "bundle_forms"
	}
	
}
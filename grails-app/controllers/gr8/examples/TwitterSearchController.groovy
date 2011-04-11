package gr8.examples

import grails.converters.*
import groovyx.net.http.*

class TwitterSearchController {

    def index = {
		def query = params.query ?: "#gr8conf"
		def page = params.int("page") ?: 1
		def http = new RESTClient("http://search.twitter.com/search.json")
		def response = http.get(query: [q: query, rpp: 10, page: page], contentType: "application/json")
		[results: response.data.results, query: query]
	}
}

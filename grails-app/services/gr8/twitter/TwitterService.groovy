package gr8.twitter

import groovyx.net.http.*

class TwitterService {
	
	static transactional = false
	
	private final RESTClient http = new RESTClient("http://search.twitter.com/search.json")
	
	def search(String q, int page = 1) {
		def response = http.get(query: [q: q, rpp: 10, page: page], contentType: "application/json")
		response.data.results
	}
	
}
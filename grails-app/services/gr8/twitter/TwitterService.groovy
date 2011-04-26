package gr8.twitter

import groovyx.net.http.*
import net.sf.json.JSONArray
import net.sf.json.JSONObject

class TwitterService {
	
	static transactional = false
	
	private final RESTClient http = new RESTClient("http://search.twitter.com/search.json")
	
	Collection<JSONObject> search(String q, int page = 1, int resultsPerPage = 10) {
		def response = http.get(query: [q: q, rpp: resultsPerPage, page: page], contentType: "application/json")
		JSONArray.toCollection(response.data.results)
	}
	
}
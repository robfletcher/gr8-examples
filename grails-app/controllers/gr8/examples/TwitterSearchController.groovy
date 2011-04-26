package gr8.examples

class TwitterSearchController {
	
	def twitterService

    def index = {
		def q = params.q ?: "#gr8conf"
		def page = params.int("page") ?: 1
		
		def results = twitterService.search(q, page)
		[results: results, q: q, page: page]
	}
}

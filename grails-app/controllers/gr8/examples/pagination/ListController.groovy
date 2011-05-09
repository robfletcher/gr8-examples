package gr8.examples.pagination

import gr8.examples.*

class ListController {
	
	def albums = {
		params.max = params.max ? Math.min(params.int("max"), 25) : 3
		[albums: Album.list(params), total: Album.count()]
	}
	
}
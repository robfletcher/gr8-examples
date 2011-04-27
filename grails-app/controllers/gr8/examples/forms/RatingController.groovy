package gr8.examples.forms

class RatingController {

    def index = {
		def album = Album.findByTitle("Up From Below")
		def related = Album.list() - album
		[album: album, related: related]
	}

	def rate = {
		
	}

}

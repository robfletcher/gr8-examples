package gr8.examples.forms

import javax.servlet.http.*
import static javax.servlet.http.HttpServletResponse.*

class RatingController {

    def album = {
		def album = Album.read(params.id)
		if (!album) {
			response.sendError SC_NOT_FOUND
			return
		}
	
		def model = [album: album]
		model.rating = Rating.findByAlbumAndUserToken(album, userToken)
		model.related = Album.list() - album
		model
	}

	def rate = {
		def album = Album.read(params.id)
		if (!album) {
			response.sendError SC_NOT_FOUND
			return
		}
		
		def cookie = request.cookies.find { it.name == "user-token" }
		
		def rating = Rating.findByAlbumAndUserToken(album, userToken)
		if (!rating) {
			rating = new Rating(album: album, userToken: userToken, score: params.int("score"))
		}
		
		rating.score = params.int("score")
		if (!rating.save()) {
			def message = rating.errors.allErrors.collect {
				message error: it
			}.join(", ")
			response.sendError SC_CONFLICT, message
			return
		}
		
		if (request.xhr) {
			render contentType: "text/plain", text: "ok"
		} else {
			redirect action: "album", id: album.id
		}
	}
	
	private String getUserToken() {
		def cookie = request.cookies.find { it.name == "user-token" }
		if (!cookie) {
			def token = UUID.randomUUID().toString()
			cookie = new Cookie("user-token", token)
			response.addCookie(cookie)
		}
		cookie.value
	}

}

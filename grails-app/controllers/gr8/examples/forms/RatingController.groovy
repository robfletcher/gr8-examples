package gr8.examples.forms

import gr8.examples.*
import javax.servlet.http.*
import static javax.servlet.http.HttpServletResponse.*

class RatingController {

	def beforeInterceptor = {
		params.album = Album.read(params.id)
		if (!params.album) {
			response.sendError SC_NOT_FOUND
			return false
		}
	}

    def album = {
		def model = [album: params.album]
		model.rating = Rating.findByAlbumAndUserToken(params.album, userToken)
		model.related = Album.list(max: 5) - params.album
		model
	}

	def rate = {
		def rating = Rating.findByAlbumAndUserToken(params.album, userToken)
		if (!rating) {
			rating = new Rating(album: params.album, userToken: userToken, score: params.int("score"))
		}
		
		rating.score = params.int("score")
		if (!rating.save()) {
			response.sendError SC_CONFLICT, errorMessage(rating)
			return
		}
		
		if (request.xhr) {
			render contentType: "text/plain", text: "Thanks!"
		} else {
			redirect action: "album", id: params.album.id
		}
	}

	private String getUserToken() {
		def cookie = request.cookies.find { it.name == "user-token" }
		if (!cookie) {
			def token = UUID.randomUUID().toString()
			cookie = new Cookie("user-token", token)
			cookie.path = "/"
			response.addCookie(cookie)
		}
		cookie.value
	}

	private String errorMessage(domainInstance) {
		domainInstance.errors.allErrors.collect {
			message error: it
		}.join(", ")
	}

}

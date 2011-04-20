package gr8.examples

import javax.servlet.http.*
import static javax.servlet.http.HttpServletResponse.*

class VoteController {
	
	def pollService
	
	def beforeInterceptor = {
		request.poll = Poll.read(params.id)
		if (!request.poll) {
			response.sendError SC_NOT_FOUND
			false
		}
	}

    def poll = {
		if (pollService.hasUserVoted(request.poll, request)) redirect action: "results", id: request.poll.id
		else [poll: request.poll]
	}
	
	def results = {
		[poll: request.poll]
	}
	
	def cast = {
		if (pollService.hasUserVoted(request.poll, request)) {
			response.sendError(SC_FORBIDDEN)
			return
		} 
		def token = pollService.getOrCreateUserToken(request, response)
		def vote = new Vote(poll: request.poll, token: token, answer: params.int("answer")).save()
		if (!vote) {
			def message = vote.errors.collect { message(error: it) }.join(", ")
			response.sendError(SC_CONFLICT, message)
		} else {
			response.addCookie new Cookie("${Vote.name}.$request.poll.id", token)
			redirect action: "results", id: request.poll.id
		}
	}
	
}

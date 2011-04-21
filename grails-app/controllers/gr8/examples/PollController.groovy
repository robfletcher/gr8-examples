package gr8.examples

import javax.servlet.http.*
import static javax.servlet.http.HttpServletResponse.*

class PollController {
	
	def pollService
	
	def list = {
		[polls: Poll.list(params)]
	}
	
    def show = {
		withPoll { poll ->
			if (pollService.hasUserVoted(request.poll, request)) {
				redirect action: "results", id: poll.id
			} else {
				[poll: poll]
			}
		}
	}
	
	def results = {
		withPoll { poll ->
			[poll: poll]
		}
	}
	
	def vote = {
		withPoll { poll ->
			if (pollService.hasUserVoted(poll, request)) {
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
	
	private withPoll(Closure closure) {
		def poll = Poll.read(params.id)
		if (poll) {
			closure(poll)
		} else {
			response.sendError SC_NOT_FOUND
		}
	}
	
}

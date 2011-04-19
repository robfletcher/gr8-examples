package gr8.examples

import javax.servlet.http.*
import static javax.servlet.http.HttpServletResponse.*

class VoteController {
	
	def beforeInterceptor = {
		request.poll = Poll.read(params.id)
		if (!request.poll) {
			response.sendError(SC_NOT_FOUND)
			false
		}
	}

    def poll = {
		def cookie = request.cookies.find { it.name == "${Vote.name}.$request.poll.id" }
		if (cookie) redirect action: "results", id: request.poll.id
		else [poll: request.poll]
	}
	
	def results = {
		[poll: request.poll]
	}
	
	def cast = {
		def cookie = request.cookies.find { it.name == "${Vote.name}.$request.poll.id" }
		if (cookie) {
			response.sendError(SC_FORBIDDEN)
			return
		} 
		def token = UUID.randomUUID().toString()
		def vote = new Vote(poll: request.poll, token: token, answer: params.int("answer")).save()
		if (!vote) {
			def message = vote.errors.collect { message(error: it) }.join(", ")
			response.sendError(SC_CONFLICT, message)
		} else {
			response.addCookie new Cookie("${Vote.name}.$request.poll.id", params.answer)
			redirect action: "results", id: request.poll.id
		}
	}
	
}

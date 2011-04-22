package gr8.examples

import javax.servlet.http.*
import static javax.servlet.http.HttpServletResponse.*

class PollController {

	static defaultAction = "latest"

	def pollService

	def latest = {
		def id = Poll.withCriteria(uniqueResult: true) {
			projections {
				property "id"
			}
			order "dateCreated", "desc"
			maxResults 1
		}
		redirect action: "show", id: id
	}

	def list = {
		[polls: Poll.list(params)]
	}

	def show = {
		withPoll { poll ->
			if (pollService.hasUserVoted(poll, request)) {
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
			Poll.withTransaction { tx ->
				def token = pollService.getOrCreateUserToken(request, response)
				def vote = new Vote(poll: poll, token: token, answer: params.int("answer"))
				if (!vote.save()) {
					tx.setRollbackOnly()
					def message = vote.errors.allErrors.collect { message(error: it) }.join(", ")
					response.sendError(SC_CONFLICT, message)
				} else {
					response.addCookie new Cookie("${Vote.name}.$poll.id", token)
					redirect action: "results", id: poll.id
				}
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

package gr8.examples

import grails.plugin.spock.ControllerSpec
import static javax.servlet.http.HttpServletResponse.*

class PollControllerSpec extends ControllerSpec {

	def "a user who has already voted is redirected from show to results"() {
		given:
		def poll = new Poll(id: 1)
		mockDomain Poll, [poll]

		and:
		controller.pollService = Mock(PollService)
		controller.pollService.hasUserVoted(poll, _) >> true

		when:
		controller.params.id = poll.id
		controller.show()

		then:
		redirectArgs.action == "results"
		redirectArgs.id == poll.id
	}

	def "a user cannot vote more than once on a poll"() {
		given:
		def poll = new Poll(id: 1)
		mockDomain Poll, [poll]

		and:
		controller.pollService = Mock(PollService)
		controller.pollService.hasUserVoted(poll, _) >> true

		when:
		controller.params.id = poll.id
		controller.params.answer = 0
		controller.vote()

		then:
		controller.response.status == SC_FORBIDDEN
	}

}

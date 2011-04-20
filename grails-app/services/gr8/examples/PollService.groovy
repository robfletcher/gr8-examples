package gr8.examples

import javax.servlet.http.*

class PollService {

    static transactional = false

    boolean hasUserVoted(Poll poll, HttpServletRequest request) {
		def token = getUserToken(request)
		if (token) {
			Vote.withCriteria(uniqueResult: true) {
				projections {
					rowCount()
				}
				eq "poll", poll
				eq "token", token
			}
		} else {
			false
		}
	}
	
	String getOrCreateUserToken(HttpServletRequest request, HttpServletResponse response) {
		def token = getUserToken(request)
		if (!token) {
			token = UUID.randomUUID().toString()
			def cookie = new Cookie("usertoken", token)
			response.addCookie(cookie)
		}
		token
	}
	
	String getUserToken(HttpServletRequest request) {
		def cookie = request.cookies.find { it.name == "usertoken" }
		cookie?.value
	}
}

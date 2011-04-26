package gr8.examples.graph

import org.apache.commons.lang.StringEscapeUtils

class TwitterGraphController {

	def twitterService

	def users = {
		def q = params.q ?: "#gr8conf"
		def results = twitterService.search(q, 1, 100)

		def users = results.countBy {
			def user = [:]
			user.name = it.from_user
			user.image = it.profile_image_url
			user
		}

		[q: q, users: users]
	}

	def clients = {
		def q = params.q ?: "#gr8conf"
		def results = twitterService.search(q, 1, 100)

		def clients = results.countBy {
			StringEscapeUtils.unescapeHtml(it.source)
		}

		[q: q, clients: clients]
	}
}


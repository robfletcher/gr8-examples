package gr8.examples.lightbox

import gr8.examples.*
import org.apache.commons.collections.CollectionUtils
import static javax.servlet.http.HttpServletResponse.*

class BasketController {
	
	static final BASKET_KEY = "gr8.examples.lightbox.Basket"
	
	def show = {
		use(CollectionUtils) {
			def model = [basket: basket.cardinalityMap, total: basket.sum { it.price }]
			if (request.xhr) {
				render template: "basket", model: model
			} else {
				model
			}
		}
	}
	
	def add = {
		def album = Album.read(params.id)
		if (!album) {
			response.sendError SC_NOT_FOUND
		}
		
		basket << album
		
		if (request.xhr) {
			forward action: "show"
		} else {
			redirect action: "show"
		}
	}
	
	def clear = {
		basket.clear()
		if (request.xhr) {
			forward action: "show"
		} else {
			redirect action: "show"
		}
	}
	
	private Collection<Album> getBasket() {
		def basket = session[BASKET_KEY]
		if (basket == null) {
			basket = []
			session[BASKET_KEY] = basket
		}
		basket
	}
	
}
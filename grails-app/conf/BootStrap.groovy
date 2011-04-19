import gr8.examples.*

class BootStrap {

    def init = { servletContext ->
		def poll = new Poll(question: "What is your favourite browser?")
		poll.answers = ["Firefox", "Google Chrome", "Internet Explorer", "Konqueror", "Opera", "Lynx", "Safari", "Other"]
		poll.save(failOnError: true, flush: true)
    }

    def destroy = {
    }
}

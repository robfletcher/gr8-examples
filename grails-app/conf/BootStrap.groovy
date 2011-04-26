import gr8.examples.*

class BootStrap {

    def init = { servletContext ->
		createPoll("What is your favourite Groovy technology?", ["Gaelyk", "Geb", "GPars", "Grails", "Spock", "Other"])
		createPoll("What is your favourite browser?", ["Firefox", "Google Chrome", "Internet Explorer", "Konqueror", "Opera", "Lynx", "Safari", "Other"])
		createPoll("What language do you use most in your day-to-day job?", ["Ada", "C++", "C#", "Clojure", "Erlang", "Groovy", "Java", "Perl", "Python", "Ruby", "Scala", "Other"])
    }

    def destroy = {
    }

	private void createPoll(String question, List<String> answers) {
		def poll = new Poll(question: question, answers: answers)
		poll.save(failOnError: true)
	}
}

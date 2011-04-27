import gr8.examples.Poll
import gr8.examples.backport.CountBy
import gr8.examples.forms.Album

class BootStrap {

    def init = { servletContext ->
		createPoll("What is your favourite Groovy technology?", ["Gaelyk", "Geb", "GPars", "Grails", "Spock", "Other"])
		createPoll("What is your favourite browser?", ["Firefox", "Google Chrome", "Internet Explorer", "Konqueror", "Opera", "Lynx", "Safari", "Other"])
		createPoll("What language do you use most in your day-to-day job?", ["Ada", "C++", "C#", "Clojure", "Erlang", "Groovy", "Java", "Perl", "Python", "Ruby", "Scala", "Other"])

		new Album(title: "Up From Below", artist: "Edward Sharpe & the Magnetic Zeros", cover: new URI("/images/albums/album-01.jpg"), tracks: ["40 Day Dream", "Janglin", "Up From Below", "Carries On", "Jade", "Home", "Desert Song", "Black Water", "I Come In Please", "Simplest Love", "Kisses Over Babylon", "Brother", "Om Nashi Me"]).save(failOnError: true)
		new Album(title: "Alexander", artist: "Alexander", cover: new URI("/images/albums/album-02.jpg")).save(failOnError: true)
		new Album(title: "Another Man's Treasure", artist: "Ima Robot", cover: new URI("/images/albums/album-03.jpg")).save(failOnError: true)
		new Album(title: "The Wild Hunt", artist: "The Tallest Man on Earth", cover: new URI("/images/albums/album-04.jpg")).save(failOnError: true)

		// Groovy 1.8 feature backport
		Collection.mixin(CountBy)
    }

    def destroy = {
    }

	private void createPoll(String question, List<String> answers) {
		def poll = new Poll(question: question, answers: answers)
		poll.save(failOnError: true)
	}
}

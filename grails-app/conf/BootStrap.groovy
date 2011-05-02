import gr8.examples.Poll
import gr8.examples.backport.CountBy
import gr8.examples.forms.Album

class BootStrap {

    def init = { servletContext ->
		createPoll("What is your favourite Groovy technology?", ["Gaelyk", "Geb", "GPars", "Grails", "Spock", "Other"])
		createPoll("What is your favourite browser?", ["Firefox", "Google Chrome", "Internet Explorer", "Konqueror", "Opera", "Lynx", "Safari", "Other"])
		createPoll("What language do you use most in your day-to-day job?", ["Ada", "C++", "C#", "Clojure", "Erlang", "Groovy", "Java", "Perl", "Python", "Ruby", "Scala", "Other"])

		new Album(title: "Up From Below", artist: "Edward Sharpe & the Magnetic Zeros", cover: new URI("/images/albums/album-01.jpg"), tracks: ["40 Day Dream", "Janglin'", "Up From Below", "Carries On", "Jade", "Home", "Desert Song", "Black Water", "I Come In Please", "Simplest Love", "Kisses Over Babylon", "Brother", "Om Nashi Me"], price: 7.99).save(failOnError: true)
		new Album(title: "Alexander", artist: "Alexander", cover: new URI("/images/albums/album-02.jpg"), tracks: ["Let's Win!", "Awake My Body", "Truth", "In The Twilight", "Bad Bad Love", "Old Friend", "A Million Years", "Remember Our Heart", "Glimpses", "Let's Make A Deal Not To Make A Deal"], price: 8.83).save(failOnError: true)
		new Album(title: "Another Man's Treasure", artist: "Ima Robot", cover: new URI("/images/albums/album-03.jpg"), tracks: ["INtro", "Ruthless", "Rough Night", "Life is Short", "Sail With Me", "Pass It On", "Shine Shine", "Swell", "Greenback Boogie", "Victory", "Peru", "Life is Short (extended ice cream truck edit)"], price: 8.93).save(failOnError: true)
		new Album(title: "The King Is Dead", artist: "The Decemberists", cover: new URI("/images/albums/album-04.jpg"), tracks: ["Don't Carry It All", "Calamity Song", "Rise To Me", "Rox In The Box", "January Hymn", "Down By The Water", "All Arise!", "June Hymn", "This Is Why We Fight", "Dear Avery"], price: 7.99).save(failOnError: true)
		new Album(title: "Helplessness Blues", artist: "Fleet Foxes", cover: new URI("/images/albums/album-05.jpg"), tracks: ["Montezuma", "Bedouin Dress", "Sim Sala Bim", "Battery Kinzie", "The Plains / Bitter Dancer", "Helplessness Blues", "The Cascades", "Lorelai", "Someone You'd Admire", "The Shrine / An Argument", "Blue Spotted Tail", "Grown Ocean"], price: 7.99).save(failOnError: true)

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

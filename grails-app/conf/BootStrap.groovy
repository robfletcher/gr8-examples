import gr8.examples.backport.CountBy
import gr8.examples.*

class BootStrap {

    def init = { servletContext ->
		new Album(title: "Up From Below", artist: "Edward Sharpe & the Magnetic Zeros", cover: new URI("/images/albums/album-01.jpg"), tracks: ["40 Day Dream", "Janglin'", "Up From Below", "Carries On", "Jade", "Home", "Desert Song", "Black Water", "I Come In Please", "Simplest Love", "Kisses Over Babylon", "Brother", "Om Nashi Me"], price: 7.99).save(failOnError: true)
		new Album(title: "Alexander", artist: "Alexander", cover: new URI("/images/albums/album-02.jpg"), tracks: ["Let's Win!", "Awake My Body", "Truth", "In The Twilight", "Bad Bad Love", "Old Friend", "A Million Years", "Remember Our Heart", "Glimpses", "Let's Make A Deal Not To Make A Deal"], price: 8.83).save(failOnError: true)
		new Album(title: "Another Man's Treasure", artist: "Ima Robot", cover: new URI("/images/albums/album-03.jpg"), tracks: ["INtro", "Ruthless", "Rough Night", "Life is Short", "Sail With Me", "Pass It On", "Shine Shine", "Swell", "Greenback Boogie", "Victory", "Peru", "Life is Short (extended ice cream truck edit)"], price: 8.93).save(failOnError: true)
		new Album(title: "The King Is Dead", artist: "The Decemberists", cover: new URI("/images/albums/album-04.jpg"), tracks: ["Don't Carry It All", "Calamity Song", "Rise To Me", "Rox In The Box", "January Hymn", "Down By The Water", "All Arise!", "June Hymn", "This Is Why We Fight", "Dear Avery"], price: 7.99).save(failOnError: true)
		new Album(title: "Helplessness Blues", artist: "Fleet Foxes", cover: new URI("/images/albums/album-05.jpg"), tracks: ["Montezuma", "Bedouin Dress", "Sim Sala Bim", "Battery Kinzie", "The Plains / Bitter Dancer", "Helplessness Blues", "The Cascades", "Lorelai", "Someone You'd Admire", "The Shrine / An Argument", "Blue Spotted Tail", "Grown Ocean"], price: 7.99).save(failOnError: true)
		new Album(title: "Contra", artist: "Vampire Weekend", cover: new URI("/images/albums/album-06.jpg"), tracks: ["Horchata", "White Sky", "Holiday", "California English", "Taxi Cab", "Run", "Cousins", "Giving Up The Gun", "Diplomat's Son", "I Think Ur A Contra"], price: 4.29).save(failOnError: true)
		new Album(title: "High Violet", artist: "The National", cover: new URI("/images/albums/album-07.jpg"), tracks: ["Terrible Love", "Sorrow", "Anyone's Ghost", "Little Faith", "Afraid Of Everyone", "Bloodbuzz Ohio", "Lemonworld", "Runaway", "Conversation 16", "England", "Vanderlyle Crybaby Geeks"], price: 7.99).save(failOnError: true)
		new Album(title: "Primary Colours", artist: "The Horrors", cover: new URI("/images/albums/album-08.jpg"), tracks: ["Mirror's Image", "Three Decades", "Who Can Say", "Do You Remember", "New Ice Age", "Scarlet Fields", "I Only Think Of You", "I Can't Control Myself", "Primary Colours", "Sea Within A Sea"], price: 6.29).save(failOnError: true)
		new Album(title: "LP4", artist: "Ratatat", cover: new URI("/images/albums/album-09.jpg"), tracks: ["Bilar", "Drugs", "Neckbrace", "We Can't Be Stopped", "Bob Gandhi", "Mandy", "Mahalo", "Party With Children", "Sunblocks", "Bare Feast", "Grape Juice City", "Alps"], price: 8.83).save(failOnError: true)
		new Album(title: "Brothers", artist: "The Black Keys", cover: new URI("/images/albums/album-10.jpg"), tracks: ["Everlasting Light", "Next Girl", "Tighten Up", "Howlin' For You", "She's Long Gone", "Black Mud", "The Only One", "Too Afraid To Love You", "Ten Cent Pistol", "Sinister Kid", "The Go Getter", "I'm Not The One", "Unknown Brother", "These Days"], price: 4.99).save(failOnError: true)

		// Groovy 1.8 feature backport
		Collection.mixin(CountBy)
    }

    def destroy = {
    }
}

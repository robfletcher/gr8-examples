package gr8.examples.forms

class Rating {

    String userToken
    int score

	static belongsTo = [album: Album]

    static constraints = {
        userToken blank: false, unique: "album"
        score range: 1..5
    }
}

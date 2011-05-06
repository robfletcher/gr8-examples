package gr8.examples

class Rating {

    String userToken
    int score

	static belongsTo = [album: Album]

    static constraints = {
        userToken blank: false, unique: "album"
        score range: 1..5
    }

	static Double average(Album album) {
		Rating.withCriteria(uniqueResult: true) {
			projections {
				avg "score"
			}
			eq "album", album
		}
	}
}

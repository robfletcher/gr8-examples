package gr8.examples.forms

class Album {

	String title
	String artist
	URI cover
	List<String> tracks

	static hasMany = [tracks: String]

    static constraints = {
		title blank: false
		artist blank: false
    }

	@Override
	String toString() {
		"$title by $artist"
	}

}

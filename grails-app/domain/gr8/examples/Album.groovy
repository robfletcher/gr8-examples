package gr8.examples

import org.apache.commons.lang.builder.*

class Album {

	String title
	String artist
	URI cover
	List<String> tracks
	Double price

	static hasMany = [tracks: String]

    static constraints = {
		title blank: false, unique: "artist"
		artist blank: false
		price scale: 2
    }

	@Override
	String toString() {
		"$title by $artist"
	}
	
	static transients = ["averageRating"]

	Double getAverageRating() {
		Rating.average(this)
	}
	
	@Override
	int hashCode() {
		new HashCodeBuilder(17, 37).append(title).append(artist).toHashCode()
	}
	
	@Override
	boolean equals(other) {
		if (!(other instanceof Album)) return false
		if (this.is(other)) return true
		new EqualsBuilder().append(title, other.title).append(artist, other.artist).isEquals()
	}

}

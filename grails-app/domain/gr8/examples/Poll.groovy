package gr8.examples

class Poll {
	
	String question
	List<String> answers
	Date dateCreated
	
	static hasMany = [answers: String]

    static constraints = {
		question blank: false
		answers minSize: 2
    }

	static namedQueries = {
		previous { Poll poll ->
			lt "dateCreated", poll.dateCreated
			order "dateCreated", "desc"
		}
		next { Poll poll ->
			gt "dateCreated", poll.dateCreated
			order "dateCreated", "asc"
		}
	}
}

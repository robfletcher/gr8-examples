package gr8.examples

class Poll {
	
	String question
	List<String> answers
	
	static hasMany = [answers: String]

    static constraints = {
		question blank: false
		answers minSize: 2
    }
}

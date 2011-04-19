package gr8.examples

class Vote {
	
	String token
	Poll poll
	int answer
	
    static constraints = {
		answer min: 0
    }
}

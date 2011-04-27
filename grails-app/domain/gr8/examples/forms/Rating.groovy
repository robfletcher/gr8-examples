package gr8.examples.forms

class Rating {

    String userToken
    int rating

    static constraints = {
        userToken blank: false, unique: true
        rating range: 1..5
    }
}

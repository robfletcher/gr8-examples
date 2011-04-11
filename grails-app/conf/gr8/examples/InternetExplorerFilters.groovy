package gr8.examples

class InternetExplorerFilters {

    def filters = {
        all(controller: "*", action: "*") {
            afterView = {
                response.setHeader("X-UA-Compatible", "IE=edge,chrome=1")
            }
        }
    }
    
}

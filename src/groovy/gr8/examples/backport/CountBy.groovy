package gr8.examples.backport

/**
 * Created by IntelliJ IDEA.
 * User: rob
 * Date: 26/04/2011
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */
@Category(Collection)
class CountBy {

	Map<Object, Integer> countBy(Closure closure) {
		def result = [:].withDefault { 0 }
		each {
			def key = closure(it)
			result[key]++
		}
		result
	}

}

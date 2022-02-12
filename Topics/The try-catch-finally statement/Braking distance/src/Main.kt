import java.lang.ArithmeticException
import kotlin.Exception

fun calculateBrakingDistance(v1: String, a: String): Int {
    // write your code here
    val v2 = 0
    try {
        return (v2 * v2 - v1.toInt() * v1.toInt()) / (2 * a.toInt())
    } catch (e: ArithmeticException) {
        println("The car does not slow down!")
        return -1
    } catch (e: NumberFormatException) {
        println(e.message)
        return -1
    } catch (e: Exception) {
        println(e.message)
        return -1
    }
}
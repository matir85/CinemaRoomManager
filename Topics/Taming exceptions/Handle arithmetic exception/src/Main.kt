fun main() {
    // put your code here
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    if (b == 0) println("Division by zero, please fix the second argument!")
    else println(a / b)
}
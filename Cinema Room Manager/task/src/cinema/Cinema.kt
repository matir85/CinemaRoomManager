package cinema
import java.util.*

fun main() {
    // write your code here
    val scanner = Scanner(System.`in`)
    println("Enter the number of rows:")
    val row = scanner.nextInt()
    println("Enter the number of seats in each row:")
    val eachRow = scanner.nextInt()
    val roomSize = Array(row) { Array(eachRow) { 'S' } }
    println()
    var busy = 0
    var currentIncome = 0
    var buy = false
    do {
        val yourChoice = menu()
        if (yourChoice == 1) {
            println()
            showRoom(row, eachRow, roomSize)
            println()
        }
        if (yourChoice == 2) {
            do {
                try {
                println()
                println("Enter a row number:")
                val youRow = scanner.nextInt()
                println("Enter a seat number in that row:")
                val youEachRow = scanner.nextInt()
                if (roomSize[youRow - 1][youEachRow - 1] == 'B') {
                    println("That ticket has already been purchased!")
                } else {
                    if (row * eachRow <= 60) {
                        println("Ticket price: $10")
                        currentIncome += 10
                        println()
                    } else {
                        val half = row / 2
                        if (youRow > half) {
                            println("Ticket price: $8")
                            currentIncome += 8
                            println()
                        } else {
                            println("Ticket price: $10")
                            currentIncome += 10
                            println()
                        }
                    }
                    roomSize[youRow - 1][youEachRow - 1] = 'B'
                    busy++
                    buy = true
                }
            } catch (e: IndexOutOfBoundsException) {
                println()
                println("Wrong input!")
                }
            } while (!buy)
            buy = false
        }
        if (yourChoice == 3) {
            val percent = 100 / (row.toFloat() * eachRow.toFloat()) * busy
            println("Number of purchased tickets: $busy")
            println("Percentage: ${String.format("%.2f", percent)}%")
            println("Current income: $$currentIncome")
            println("Total income: $${totalIncome(row, eachRow)}")
            println()
        }
    } while (yourChoice != 0)
}
fun menu(): Int {
    println("1. Show the seats")
    println("2. Buy a ticket")
    println("3. Statistics")
    println("0. Exit")
    return readLine()!!.toInt()
}
fun showRoom(row: Int, eachRow: Int, room: Array<Array<Char>>) {
    println("Cinema:")
    print(" ")
    for (i in 1..eachRow) print(" $i")
    println()
    for (i in 0 until row) {
        println("${i + 1} ${room[i].joinToString(" ")}")
    }
}
fun totalIncome(row: Int, eachRow: Int): Int {
    return if (row * eachRow <= 60) {
        row * eachRow * 10
    } else {
        val half = row / 2
        (half * eachRow * 10) + ((row - half) * eachRow * 8)
    }
}
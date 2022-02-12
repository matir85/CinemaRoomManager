import kotlin.Exception

fun parseCardNumber(cardNumber: String): Long {
    if (cardNumber[4] != cardNumber[9] && cardNumber[9] != cardNumber[14]) {
        throw Exception()
    }
    val (a, b, c, d) = cardNumber.split(" ")
    if (a.length != 4 || b.length != 4 || c.length != 4 || d.length != 4 ) {
        throw Exception()
    }
    if (cardNumber.length != 19) {
        throw Exception()
    }
    if (cardNumber.lastIndex.equals(" ")) {
        throw Exception()
    }
    val card = cardNumber.replace(" ", "")
    if (card.matches("[^0-9]".toRegex())) {
        throw NumberFormatException()
    }


    return card.toLong()
}
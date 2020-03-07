package es.ams.typesystem

/**
 * Let function. Together with a safe-call operator, evaluate an expressión, check the result for null and store the result.
 *
 */
class Ejem1LetFunction {
}

fun doSomething(text: String){
    println("Doing something with '${text}'")
}

fun returnString(msg: String): String? {
    return when(msg){
        "A" -> "is A"
        "B" -> "is B"
        else -> null
    }
}

fun main() {

    println("=== EJEM 1")
    val text1: String = "This is a text one"
    text1?.let { doSomething(it) }

    val text2: String? = null
    text2?.let { doSomething(it) }
    println()

    println("=== EJEM 2")
    returnString("A")?.let { doSomething(it) }
    returnString("")?.let { doSomething(it) }
    println()

}

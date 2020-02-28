package es.ams.range

import java.util.*

fun example1(): Unit {
    println("--- Ejemplo TreeMap ---")
    val binaryReps = TreeMap<Char, String>()
    for(c in 'A'..'F'){
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for( (letter, binary) in binaryReps ){
        println("$letter = $binary")
    }
    println()
}

fun example2(): Unit {
    println("--- Ejemplo ArrayList ---")
    val lst = arrayListOf<String>("10","11","1001")
    for( (index, element) in lst.withIndex() ){
        println("$index = $element")
    }
    println()
}

fun example3(): Unit {

    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

    fun isNotDigit(c: Char) = c !in '0'..'9'

    println("--- Operators in !in ---")
    println("isLetter('q')=${isLetter('q')}")
    println("isLetter('6')=${isLetter('6')}")
    println("isNotDigit('x')=${isNotDigit('x')}")
    println("isNotDigit('6')=${isNotDigit('6')}")
    println()

}

fun example4(): Unit {

    fun recognize(c: Char): String = when(c){
        in '0'..'9' -> "Digit"
        in 'a'..'z' -> "Letter"
        else -> "??"
    }

    println("--- Operator in con when --")
    println("recognize('q')=${recognize('q')}")
    println("recognize('5')=${recognize('5')}")
    println("recognize('*')=${recognize('*')}")
    println()

}

fun main() {
    example1()

    example2()

    example3()

    example4()
}

package es.ams.typesystem

import java.lang.NullPointerException

/**
 * Not null assertions !!
 */

fun msgToUpperCaseAssertions(msg: String?) {
    val msgAux = msg!! // if msg is null then throw NullPointerException
    println("==>>${msgAux.length}")
}


fun main() {

    println("=== EJEM1")
    msgToUpperCaseAssertions("test")
    try{
        msgToUpperCaseAssertions(null)

    }catch(ex: NullPointerException){
        println("Exception=${ex.message}")
    }
    println()

}

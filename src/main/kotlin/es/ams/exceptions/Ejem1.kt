package es.ams.exceptions

import java.io.BufferedReader
import java.io.StringReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

fun example1(): Unit {

    fun fPercentaje(number: Int): Int {
        val percentaje = if(number in 0..100){
            number
        }else{
            throw IllegalArgumentException("A percentaje value must be between 0 and 100: $number")
        }
        return percentaje
    }

    println("--- Exception/Expressions --- ")
    println("fPercentaje(40)=${fPercentaje(40)}")
    try{
        println("fPercentaje(400)=${fPercentaje(400)}")

    }catch(ex: IllegalArgumentException){
        println("Exception=${ex.message}")
    }
    println()

}

fun example2(): Unit {

    fun readNumber(reader: BufferedReader): Int? {
        try{
            val line = reader.readLine()
            return Integer.parseInt(line)
        }catch(e: NumberFormatException){
            return null
        }finally {
            reader.close()
        }
    }

    println("--- try/catch/finally ---")
    val bufferReaderInt = BufferedReader(StringReader("123456"))
    println("readNumber(bufferReader)=${readNumber(bufferReaderInt)}")

    val bufferReaderString = BufferedReader(StringReader("qwerty"))
    println("readNumber(bufferReaderString)=${readNumber(bufferReaderString)}")
    println()
}


fun example3(): Unit {

    fun readNumber(reader: BufferedReader): Int? {
        val number = try{
            Integer.parseInt(reader.readLine())
        }catch(e: NumberFormatException){
            null
        }finally {
            reader.close()
        }
        return number
    }

    println("--- try/catch/finally (Expression)---")
    val bufferReaderInt = BufferedReader(StringReader("123456"))
    println("readNumber(bufferReader)=${readNumber(bufferReaderInt)}")

    val bufferReaderString = BufferedReader(StringReader("qwerty"))
    println("readNumber(bufferReaderString)=${readNumber(bufferReaderString)}")
    println()
}

fun main() {
    example1()

    example2()

    example3()
}

package es.ams.function.extensionfunction

import java.lang.StringBuilder
import es.ams.function.extensionfunction.Ejem1ExtensionFunction.lastChar as extensionFunction1
import es.ams.function.extensionfunction.Ejem1ExtensionFunction.lastChar2 as extensionFunction2
import es.ams.function.extensionfunction.Ejem1ExtensionFunction.stringlastchar as stringlastchar
import es.ams.function.extensionfunction.Ejem1ExtensionFunction.sblastChar as sblastChar

/**
 * Extension function: it's a function that can be called as a member of a class but es defined outside of it.
 */
object Ejem1ExtensionFunction{
    //  Receiver type           =  Receiver Object
    fun String.lastChar(): Char =  this.get(this.length - 1)

    fun String.lastChar2(): Char =  get(length - 1)

    fun <T> Collection<T>.joinToString(
            separator: String = "-",
            prefix: String = "#",
            postfix: String = "#"
    ): String{
        val result = StringBuilder(prefix)

        for((index, element) in this.withIndex()){
            if(index > 0) result.append(separator)
            result.append(element)
        }

        result.append(postfix)
        return result.toString()
    }

    // Extension properties
    val String.stringlastchar: Char
        get() = this.get(length - 1)

    var StringBuilder.sblastChar: Char
        get() = get(length - 1)
        set(value: Char) {
            this.setCharAt(length - 1, value)
        }

    fun start1(): Unit {
        println("-- Extension Function --")
        println("lastChar()=${"ExtensionFunction".lastChar()}")
        println("lastChar2()=${"ExtensionFunction".lastChar2()}")
        println()
    }

    fun start2(): Unit {
        val list = listOf<Int>(1, 2, 3)
        println("1 Collection.joinToString()=${list.joinToString()}")
        println("2 Collection.joinToString()=${list.joinToString(separator = "*", prefix = "#", postfix = "#")}")
        println()
    }


}

fun example1(): Unit {
    Ejem1ExtensionFunction.start1()

    println("-- Extension Function/import --")
    println("extensionFunction1()=${"ExtensionFunction".extensionFunction1()}")
    println("extensionFunction2()=${"ExtensionFunction".extensionFunction2()}")
    println()

    println("--- Extension Function/parametric function")
    Ejem1ExtensionFunction.start2()
}

fun example2(): Unit {
    println("-- Extension properties --")

    println("\"ExtensionProperties\".stringlastchar=${"ExtensionProperties".stringlastchar}")

    val sb = StringBuilder("StringBuilderExtensionProperties")
    sb.sblastChar = '!'
    println("sb=${sb}")

    println()
}

fun main() {
    example1()
    example2()
}

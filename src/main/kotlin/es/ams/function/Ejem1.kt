package es.ams.function

import java.lang.StringBuilder

fun example1(): Unit {
    println("--**-- Collections --**--")

    val setInt: HashSet<Int>  = hashSetOf<Int>(1, 7, 53)
    println("Set<Int>=${setInt}")
    println("Set<Int>.max()=${setInt.max()}")

    val list: List<String> = listOf("1", "2", "3")
    println("List<String>=${list}")
    println("List<String>.first()=${list.first()}")
    println("List<String>.last()=${list.last()}")

    val hash: HashMap<Int, String> = hashMapOf( 1 to "one", 2 to "two", 3 to "three")
    println("HashMap<Int, String>=${hash}")
    println("HashMap<Int, String>.entries=${hash.entries}")
    println("HashMap<Int, String>.keys=${hash.keys}")
    println("HashMap<Int, String>.values=${hash.values}")
    println()
}

fun example2(): Unit {

    fun <T> joinToString(
            collection: Collection<T>,
            separator: String,
            prefix: String,
            postfix: String
    ): String{
        val result = StringBuilder(prefix)

        for((index, element) in collection.withIndex()){
            if(index > 0) result.append(separator)
            result.append(element)
        }

        result.append(postfix)
        return result.toString()
    }

    val list = listOf<Int>(1,2,3,4)
    println("1 joinToString=${joinToString(list, ", ", "{", "}")}")
    println("2 joinToString=${joinToString(collection = list, separator = ", ", prefix = "{", postfix =  "}")}")
    println()

}

fun example3(): Unit {

    fun <T> joinToString(
            collection: Collection<T>,
            separator: String = "-",
            prefix: String = "#",
            postfix: String = "#"
    ): String{
        val result = StringBuilder(prefix)

        for((index, element) in collection.withIndex()){
            if(index > 0) result.append(separator)
            result.append(element)
        }

        result.append(postfix)
        return result.toString()
    }

    val list = listOf<Int>(1,2,3)
    println("1 joinToString=${joinToString(list)}")
    println("2 joinToString=${joinToString(collection = list)}")
    println()

}

fun main() {
    example1()

    example2()

    example3()
}

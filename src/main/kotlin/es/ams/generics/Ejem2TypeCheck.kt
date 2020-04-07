package es.ams.generics


fun example1TypeCast(): Unit {

    fun printSum(collection: Collection<*>): Unit{
        val listInt = collection as? List<Int> ?: throw IllegalArgumentException("Parameter illegal")
        println("${listInt.sum()}")
    }

    println("----- Example1 -----")
    val listInt = (1..10).toList()
    val listString = ('a' ..'z').toList()
    printSum(listInt)
//    printSum(listString) // throw IllegalArgumentException
    println("")

    fun printSum2(collection: Collection<Int>): Unit{
        val listInt = collection as? List<Int> ?: throw IllegalArgumentException("Parameter illegal")
        println("${listInt.sum()}")
    }

    printSum2(listInt)
    println("")
}

fun main() {
    example1TypeCast()
}

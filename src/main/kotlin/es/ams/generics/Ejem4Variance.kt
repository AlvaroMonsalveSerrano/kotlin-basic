package es.ams.generics


fun example1CopyList(): Unit {

    fun<T> copyData(
            source: MutableList<T>,
            destination: MutableList<T>): Boolean{
        return destination.addAll(source)
    }

    val listIntSource = mutableListOf<Int>(1,2,3,4)
    val listIntDestination = mutableListOf<Int>()
    println("----- Example1: Generic function-----")
    copyData(listIntSource, listIntDestination)
    println("listIntDestination=${listIntDestination}")
    println()

    val listStringSource = mutableListOf<String>("a","b","c","d")
    val listStringDestination = mutableListOf<String>()
    copyData(listStringSource, listStringDestination)
    println("listStringDestination=${listStringDestination}")
    println()

}

fun example2CopyList(): Unit {

    fun<T: R, R> copyData(
            source: MutableList<T>,
            destination: MutableList<R>): Boolean{
        return destination.addAll(source)
    }

    val listIntSource = mutableListOf<Int>(1,2,3,4)
    val listIntDestination = mutableListOf<Int>()
    println("----- Example2: Generic Function -----")
    copyData(listIntSource, listIntDestination)
    println("listIntDestination=${listIntDestination}")
    println()

    val listStringSource = mutableListOf<String>("a","b","c","d")
    val listStringDestination = mutableListOf<String>()
    copyData(listStringSource, listStringDestination)
    println("listStringDestination=${listStringDestination}")
    println()

}


fun example3CopyList(): Unit {

    fun<T> copyData(
            source: MutableList<out T>,
            destination: MutableList<T>): Boolean{
        return destination.addAll(source)
    }

    val listIntSource = mutableListOf<Int>(1,2,3,4)
    val listIntDestination = mutableListOf<Int>()
    println("----- Example2: Generic Function -----")
    copyData(listIntSource, listIntDestination)
    println("listIntDestination=${listIntDestination}")
    println()

    val listStringSource = mutableListOf<String>("a","b","c","d")
    val listStringDestination = mutableListOf<String>()
    copyData(listStringSource, listStringDestination)
    println("listStringDestination=${listStringDestination}")
    println()

}



fun main() {
    example1CopyList()
    example2CopyList()
    example3CopyList()
}

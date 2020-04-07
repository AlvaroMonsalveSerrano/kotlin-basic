package es.ams.generics

import java.lang.reflect.Array.get
import java.util.*


fun example1Generics(): Unit {

    // Extension function
    fun <T> List<T>.mySlice(indices: IntRange): List<T> {
        return this.slice(indices)
    }

    val listInt = (1..10).toList()
    val listString = ('a'..'z').toList()

    println("----- Example1 -----")
    println("listInt[1..2]=${listInt.mySlice(1..2)}")
    println("listString[10..15]=${listString.mySlice(10..15)}")
    println()


    // Extension function
    fun <T> List<T>.myFilter(predicate: (T) -> Boolean): List<T>{
        return this.filter(predicate)
    }

    val lstString = listOf("C", "D")
    val listName = listOf("A", "B", "C", "D", "E")

    println("listName.myFilter { it !in  lstString}=${listName.myFilter { it !in  lstString}}" )
    println()

    // Extension properties
    class ExampleClass(){
        val <T> List<T>.lastIndex: Int
            get() = size - 1
    }

}


fun example2GenericsTypeConstraint(): Unit {

    // T = type parameter
    // Number = Upper bound
    fun <T : Number> operationDivide(elem: T): Double{
        return (elem.toDouble() / 2.0)
    }

    println("----- Example2 -----")
    println("operationDivide(5)=${operationDivide(5)}")
    println("operationDivide(5.0)=${operationDivide(5.0)}")
    println()

}

fun example3GenericsTypeParametersNonNull(): Unit {

    class Entity<T>{
        fun process(value: T){
            println("Value to String=${value?.toString()}")
        }
    }

    val entityString = Entity<String?>()
    val entityInt = Entity<Int?>()
    val entityDouble = Entity<Double?>()

    println("----- Example3 -----")
    entityString.process("test")
    entityString.process(null)
    entityInt.process(0)
    entityInt.process(null)
    entityDouble.process(8.0)
    entityDouble.process(null)
    println()

}

fun main() {
    example1Generics()
    example2GenericsTypeConstraint()
    example3GenericsTypeParametersNonNull()
}

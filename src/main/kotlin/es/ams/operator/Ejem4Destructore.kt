package es.ams.operator

import es.ams.lambdas.listPersonLC

fun example1Destructure(): Unit {

    data class Point(val x: Int, val y: Int)

    println("---- Example ----")
    val point1 = Point(3,5)
    val (valueX, valueY) = point1
    println("Point1=${point1}")
    println("valueX=${valueX}")
    println("valueY=${valueY}")
    println()

}

fun example2Destructure(): Unit {

    data class Person(val name:String, val firstName: String)

    fun splitName(fullName: String): Person{
        val (valueName, valueFirstName) = fullName.split('.', limit = 2)
        return Person(valueName, valueFirstName)
    }

    println("---- Example2 ----")
    val fullName = "AName.AFirstName"
    println("Person=${splitName(fullName)}")
    println()

}

fun example3DestructureLoop(): Unit {

    data class Person(val name:String, val firstName: String)

    fun printPerson(mapPerson: Map<String, Person>): Unit {
        for ( (valueName, valueFirstName) in mapPerson){
            println("Collection Person=> name:${valueName}, person:${valueFirstName}")
        }
    }


    val person1 = Person("NameA","FirstNameA")
    val person2 = Person("NameB","FirstNameB")
    val person3 = Person("NameC","FirstNameC")
    val mapPerson = mapOf( "alfa" to person1, "beta" to person2, "gamma" to person3 )
    println("---- Example3 ----")
    printPerson(mapPerson)

}

fun main() {
    example1Destructure()
    example2Destructure()
    example3DestructureLoop()
}

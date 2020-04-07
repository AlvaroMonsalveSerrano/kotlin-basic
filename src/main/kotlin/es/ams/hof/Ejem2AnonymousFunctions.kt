package es.ams.hof


fun example1AnonymousFunction1(): Unit {

    data class Person(val name: String, val age: Int)

    val dataPerson = listOf(
            Person("A", 20),
            Person("B", 25),
            Person("C", 30)
    )

    fun findPerson1(lstPerson: List<Person>): Unit {
        lstPerson.forEach (
            fun (person){
                if(person.name == "B") return // Return to Anonymous function
                println("${person.name} is not B")
            }
        )
    }

    println("---- Example 1 ----")
    println("findPerson1: ")
    findPerson1(dataPerson)
    println()

}

fun main() {
    example1AnonymousFunction1()
}

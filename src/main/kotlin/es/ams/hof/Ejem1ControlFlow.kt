package es.ams.hof

fun example1ControlFlow(): Unit {

    data class Person(val name :String, val age:Int)

    val dataPerson = listOf(
            Person("A", 20),
            Person("B", 25),
            Person("C", 30)
            )

    fun findPerson1(lstPerson: List<Person>): Unit{
        lstPerson.forEach { it ->
            if(it.name == "B"){
                println("Found!")
                return // Return to findPerson1
            }
        }
        println("B don't exist in List<Person>")
    }

    println("---- Example 1 ----")
    print("findPerson1: ")
    findPerson1(dataPerson)
    println()


    fun findPerson2(lstPerson: List<Person>): Unit{
        lstPerson.forEach label@ { it ->
            // Return from the lambda expression. It is like a break
            if(it.name == "B") return@label
        }
        println("B don't exist in List<Person>")
    }
    print("findPerson2: ")
    findPerson2(dataPerson)
    println()


    fun findPerson3(lstPerson: List<Person>): Unit{
        lstPerson.forEach { it ->
            // Return from the lambda expression. It is like a break
            if(it.name == "B") return@forEach
        }
        println("B don't exist in List<Person>")
    }
    print("findPerson3: ")
    findPerson3(dataPerson)
    println()
}

fun main() {
    example1ControlFlow()
}

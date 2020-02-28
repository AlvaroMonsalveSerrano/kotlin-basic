package es.ams.classes


class PersonEjem1(
        val name: String,
        var isMarried: Boolean)

fun main() {
    val personEjem1 = PersonEjem1("Name", true)
    println("Person1=[${personEjem1.name}-${personEjem1.isMarried}]")
    personEjem1.isMarried = false
    println("Person1=[${personEjem1.name}-${personEjem1.isMarried}]")
}

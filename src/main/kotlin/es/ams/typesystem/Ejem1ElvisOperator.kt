package es.ams.typesystem

/**
 * Elvis operator, ?:
 */


data class EmployeeEO(val name: String, val manager: EmployeeEO?)

fun msgToUpperCase(msg: String?) =
        msg?.toUpperCase() ?: "default"

fun getNameManager(employee: EmployeeEO) =
        employee?.manager?.name ?: throw IllegalArgumentException("Error")

fun main() {

    println("=== EJEM 1")
    println("msg1=${msgToUpperCase("testing")}")
    println("msg2=${msgToUpperCase(null)}")
    println()

    println("=== EJEM 2")
    val manager = EmployeeEO("manager1", null)
    val employee1 = EmployeeEO("employee1", manager)
    val employee2 = EmployeeEO("employee1", null)
    println("${getNameManager(employee1)}")
    try{
        println("${getNameManager(employee2)}")
    } catch (ex: java.lang.IllegalArgumentException) {
        println(ex.message)
    }

}

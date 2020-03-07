package es.ams.typesystem

/**
 * Safe call operator "?."
 */

fun printToUpperCase( msg: String?){
    val msgToUpper = msg?.toUpperCase()
    println("msg=${msgToUpper}")
    println()
}

data class EmployeeTS(val name: String, val manager: EmployeeTS?)

fun nameManager(employee: EmployeeTS): String? = employee.manager?.name

fun main() {

    println("=== Safe call operator ===")
    printToUpperCase("test")
    printToUpperCase(null)
    println()

    val manager1 = EmployeeTS("ManagerAlfa", null)
    val employee1 = EmployeeTS("Employee1", manager1)

    println("Name Manager=${nameManager(manager1)}")
    println("Employee=${nameManager(employee1)}")
    println()

}

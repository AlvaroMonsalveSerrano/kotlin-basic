package es.ams.typesystem

/**
 * Safe casts operator as?
 */

data class EmployeeSC(val name: String, val lastName: String){

    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? EmployeeSC ?: return false

        return name == otherPerson.name &&
                lastName == otherPerson.lastName
    }

}


fun main() {

    val employeeSC1 = EmployeeSC("name1", "lastName1")
    val employeeSC2 = EmployeeSC("name2", "lastName2")

    println("employeeSC1.equals(employeeSC2)=${employeeSC1.equals(employeeSC2)}")
    println("employeeSC1.equals(employeeSC1)=${employeeSC1.equals(employeeSC1)}")
    println("employeeSC1.equals(66)=${employeeSC1.equals(66)}")
    println("employeeSC1.equals('66')=${employeeSC1.equals("66")}")
    println()

}

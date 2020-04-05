package es.ams.operator

import es.ams.lambdas.Person
import kotlin.reflect.KProperty


fun example1DelegatePropertie(): Unit {

    class Delegate{
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "$thisRef, thank you for delegating '${property.name}' to me!"
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("$value has been assigned to '${property.name}' in $thisRef.")
        }
    }

    class Example1Delegate{
        var p: String by Delegate()
    }

    val example = Example1Delegate()
    println("----- Example1 -----")
    println("Init=${example.p}")
    example.p = "TestValue"
    println()

}

fun example2DelegateFunction(): Unit{

    data class Email(val name: String)

    class PersonDelegateFunction(val name: String){
        private var _emails: List<Email>? = null

        // Function delegate
        fun loadEmails(person: PersonDelegateFunction): List<Email> {
            return listOf(
                    Email(person.name + "@domain1.es"),
                    Email(person.name + "@domain2.es")
                    )
        }

        val emails: List<Email>
            get() {
                if(_emails == null){
                    _emails = loadEmails(this)
                }
                return _emails!!
            }
    }

    println("---- Example2 ----")
    val person1 = PersonDelegateFunction("Person1")
    println("name=${person1.name}")
    println("Emails=${person1.emails}")
    println()

}

fun example3DelegateFunction(): Unit{

    data class Email(val name: String)
    class PersonDelegateFunction(val name: String){

        // Function delegate
        fun loadEmails(person: PersonDelegateFunction): List<Email> {
            return listOf(
                    Email(person.name + "@domain1.es"),
                    Email(person.name + "@domain2.es")
            )
        }

        // Best
        val emails by lazy { loadEmails(this) }

    }

    println("---- Example3 ----")
    val person1 = PersonDelegateFunction("Person1")
    println("name=${person1.name}")
    println("Emails=${person1.emails}")
    println()

}

fun main() {
    example1DelegatePropertie()
    example2DelegateFunction()
    example3DelegateFunction()
}

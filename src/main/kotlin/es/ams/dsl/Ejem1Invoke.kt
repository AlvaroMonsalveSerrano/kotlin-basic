package es.ams.dsl

import java.lang.StringBuilder

/**
 * Objects callable as functions.
 *
 */
fun example1Invoke(): Unit {

    class Greeter(val greeting: String){
        operator fun invoke(name: String){
            println("Greeting=${greeting} Name=${name}")
        }
    }

    val obj1 = Greeter("Test1")

    println("----- Example1 -----")
    obj1("ParamInvoke")
    println()

}

interface MyFuntion2<in X, in Y, out Z>{

    operator fun invoke(p1:X, p2: Y): Z

}

fun example2Invoke(): Unit {

    class SpecialFunction(): MyFuntion2<Int, Int, String>{
        override fun invoke(p1: Int, p2: Int): String {
            return StringBuilder()
                    .append(p1)
                    .append("+")
                    .append(p2)
                    .append("=")
                    .append((p1+p2).toString())
                    .toString()
        }
    }

    println("----- Example2 -----")
    val objectFunctionSum = SpecialFunction()
    println("Suma=>${objectFunctionSum(p1 =2,p2=3)}")
    println()

}

fun example3Invoke(): Unit {

    data class Issue(
            val id:String,
            val project: String,
            val type: String,
            val priority: String,
            val description: String
    )

    class ImportantIssuesPredicative(val project: String): (Issue) -> Boolean{
        override fun invoke(p1: Issue): Boolean {
            return p1.project == project && p1.isImportant()
        }

        private fun Issue.isImportant(): Boolean{
            return this.type == "BUG" && this.priority == "Critical"
        }
    }

    val issue1 = Issue(id = "1", project = "project1", type = "PBI", priority = "Medium", description = "description1")
    val issue2 = Issue(id = "2", project = "project2", type = "PBI", priority = "High", description = "description1")
    val issue3 = Issue(id = "3", project = "project1", type = "BUG", priority = "Critical", description = "description1")
    val listIssues = listOf(issue1, issue2, issue3)

    val predicate = ImportantIssuesPredicative("project1")

    println("----- Exemple3 -----")
    val result = listIssues.filter(predicate)
    println("Result->${result}")
    println()

}

fun main() {
    example1Invoke()
    example2Invoke()
    example3Invoke()
}

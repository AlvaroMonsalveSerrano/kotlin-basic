package es.ams.generics

/**
 * Los tipos genéricos son eliminados en tiempo de ejecución, es decir, si tienes un tipo genérico, no se puede encintrar
 * el tipo cunado se crea la instancia del objeto.
 *
 * Para poder realizar esas verificaciones se utiliza una función inline y definir el tipo como reified.
 *
 */

fun example1Reified(): Unit {

    class Utils{
        inline fun <reified T> isMyA(value: Any) = value is T
    }

    println("----- Example1 -----")
    println("Utils().isMyA<String>(\"abc\")=${Utils().isMyA<String>("abc")}")
    println("Utils().isMyA<String>(123)=${Utils().isMyA<String>(123)}" )
    println()

}

fun example2Reified(): Unit {

    class Utils{
        inline fun <reified T> Iterable<*>.filterInstance(): List<T>{
            val destination = mutableListOf<T>()
            for(element in this){
                if(element is T){
                    destination.add(element)
                }
            }
            return destination
        }

        fun example2(): Unit {
            val listElem = listOf("a","b",1,2,3,"c")

            println("${listElem.filterInstance<String>()}")
            println()
        }
    }

    println("----- Example2 -----")
    Utils().example2()
    println()

}

fun main() {
    example1Reified()
    example2Reified()
}

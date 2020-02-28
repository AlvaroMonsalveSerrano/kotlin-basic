package es.ams.range

fun example1(num: Int): Unit =
        when{
            num % 2 == 0 -> println("Pair")
            else -> println("Odd")
        }

fun example2(num: Int): String =
        when{
            num % 15 == 0 -> "FizzBuzz "
            num % 3 == 0 -> "Fizz "
            num % 5 == 0 -> "Buzz "
            else -> "$num "
        }

fun main() {

    println("--- EJEMPLO1 ---")
    for(index in 1..20){
        example1(index)
    }
    println()

    println("--- EJEMPLO2 ---")
    for(index in 1..100){
        println(example2(index))
    }
    println()

    println("--- EJEMPLO3 ---")
    for(index in 100 downTo 1 step 2){
        println(example2(index))
    }
}

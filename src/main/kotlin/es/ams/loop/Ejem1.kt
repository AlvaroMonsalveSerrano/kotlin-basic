package es.ams.loop

fun example1(): Unit {
    var index = 0
    while (index < 5){
        println("Index=${index}")
        index++
    }
    println()

    do{
        index--
        println("Index=${index}")
    }while(index> 0)
}

fun main() {
    example1()
}

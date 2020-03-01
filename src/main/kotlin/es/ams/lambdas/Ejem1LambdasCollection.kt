package es.ams.lambdas

data class Person(
        val name: String,
        val age: Int)

fun example1() {
    val listPerson = listOf<Person>( Person("Peter", 20), Person("Ann", 30))
    println("1 - Max=${listPerson.maxBy { it.age } }")
    println("2 - Max=${listPerson.maxBy(Person::age)}")
    println("3 - Max=${listPerson.maxBy{p:Person -> p.age} }")
    println()
}

fun example2() {
    val sum = {x: Int, y: Int -> x + y}
    println("sum(4,5)=${sum(4,5)}")
    println()

    val sum2 = { x: Int, y: Int ->
        println("...Sum2(x=$x, y=$y)")
        x + y
    }
    println("sum2(4,5)=${sum2(4,5)}")
    println()
}

fun example3() {
    fun printResponse(response: Collection<String>){
        var okExecute = 0
        var clientError = 0
        var serverError = 0
        response.forEach{
            if( it.startsWith("2") ){
                okExecute++
            }else if( it.startsWith("4")){
                clientError++
            }else if( it.startsWith("5")){
                serverError++
            }
        }
        println("Response: ok, $okExecute; client, $clientError; server, $serverError")
    }

    val responseList = listOf<String>("200 OK", "400 error1", "500 error3", "501 error", "403 error")
    printResponse(responseList)
    println()
}

fun example4(){

    fun function() = println("Hello world from function")
    run(::function)
    println()

}

fun example5(){
    val helperPerson = ::Person

    val person1 = helperPerson("NamePerson", 40)
    println("person=${person1}")
    println()
}

fun main() {
    example1()
    example2()
    example3()
    example4()
    example5()
}

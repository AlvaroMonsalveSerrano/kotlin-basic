package es.ams.lambdas

fun exampleF1(){

    val listInt = listOf<Int>(1,2,3,4,5)
    val result1 = listInt.filter { it % 2 == 0 }
    println("result1=$result1")

    val result2 = listInt.map { it * it }
    println("result2=$result2")

    val listPerson = listOf<Person>( Person("Person1", 20), Person("Person2", 21), Person("Person3", 22))
    val result3 = listPerson.filter { it.age <= 21  }
    println("Result3=${result3}")

    val result4 = listPerson.map { it.name  }
    println("Result4=${result4}")

    val result5 = listPerson.filter { it.age >= 21 }.map { it.name }
    println("Result5=${result5}")

    val result6 = listPerson.filter { it.age >= 21 }.map (Person::name)
    println("Result6=${result6}")

    val result7 = listPerson.filter { it.age == listPerson.maxBy (Person::age)!!.age }
    println("Result7=${result7}")
    println()

}

fun exampleF2(){

    val listPerson = listOf<Person>( Person("Person1", 20), Person("Person2", 21),
            Person("Person3", 42), Person("Person4", 21))

    val club20 = { p: Person -> p.age < 30 }
    println("listPerson.club20=${listPerson.all(club20)}")
    println("!listPerson.club20=${!listPerson.all(club20)}")
    println("listPerson.find=${listPerson.find(club20)}")
    println("listPerson.groupBy=${listPerson.groupBy{it.age}}")

    println()

}

fun exampleF3(){

    data class Book(val title: String, val authors: List<String>)
    val listBook = listOf<Book>(
            Book("Title1", listOf("author11", "author12")),
            Book("Title2", listOf("author21", "author22")),
            Book("Title3", listOf("author31"))
    )
    println("--- Example flatMap ---")
    println("listBook=${listBook}")
    val result1 = listBook.flatMap{it.authors}
    println("listPerson.groupBy=${result1}")



    println()

}

fun main() {
    exampleF1()

    exampleF2()

    exampleF3()
}

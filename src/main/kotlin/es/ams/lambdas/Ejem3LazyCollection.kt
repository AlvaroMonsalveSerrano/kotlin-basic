package es.ams.lambdas

val listPersonLC = listOf<Person>(
        Person("Person1", 20),
        Person("APerson2", 21),
        Person("Person3", 22)
)

fun example1LC(){

    val resultFilter1 = listPersonLC
            .asSequence()
            .map(Person::name)
            .filter { it.startsWith("A") }
            .toList()

    println("Person start with 'A'=${resultFilter1}")
    println()

}

fun example2LC(){

    val listInt = listOf<Int>(1,2,3,4,5)
            .asSequence()
            .map { print("map($it) "); it * it }
            .filter { print("filter($it) "); it % 2 == 0 }
            .toList()
    println("listInt=${listInt}")
    println()

}

fun example3LC(){

    val listPerson = listOf<Person>(
            Person("Person1", 20),
            Person("Per2", 31),
            Person("Person3", 22))

    val result1 = listPerson
            .asSequence()
            .map(Person::name)
            .filter { it.length > 4  }
            .toList()
    println("result1=${result1}")

    // First filter, reduces the number of transformations
    val result2 = listPerson
            .asSequence()
            .filter { it.name.length > 4  }
            .map(Person::name)
            .toList()
    println("result2=${result2}")
    println()

}

fun example4LC(){

    println("---- Generate Sequence ----")
    val naturalNumbers = generateSequence (0){ it + 1 }
    val numberTo100 = naturalNumbers.takeWhile { it <= 100 }

    println("naturalNumbers=${naturalNumbers}")
    println("result1=${numberTo100}")
    println("result1=${numberTo100.sum()}")
    println("result1=${numberTo100.average()}")
    println()
}

fun main() {
    example1LC()
    example2LC()
    example3LC()
    example4LC()
}

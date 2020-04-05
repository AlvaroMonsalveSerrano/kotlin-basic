package es.ams.operator


fun example1Comparison(): Unit {

    class Point(val x: Int, val y: Int){
        override fun equals(other: Any?): Boolean {
            // The operator '===' can't be overloaded
            if(other === this) return true
            if(other !is Point) return false
            return (other.x == x && other.y == y)
        }
    }

    val point1 = Point(10, 10)
    val point2 = Point(10, 10)
    val point3 = Point(20, 20)

    println("--- Example1 ---")
    println("point1==point2 -> ${point1==point2}")
    println("point1==point2 -> ${point1.equals(point2)}")
    println("point1==point3 -> ${point1==point3}")
    println("point1==point3 -> ${point1.equals(point3)}")
    println()

}

fun example2Comparison(): Unit {

    class Person(val firsName: String, val lastName: String): Comparable<Person>{
        override fun compareTo(other: Person): Int {
            return compareValuesBy(this, other, Person::firsName, Person::lastName)
        }
    }

    val person1 = Person("a", "aa")
    val person2 = Person("b", "bb")

    println("--- Example2 ---")
    println("person1 < person2=${person1 < person2}")
    println("person1 > person2=${person1 > person2}")
    println("person1 == person2=${person1 == person2}")
    println("person1 == person1=${person1 == person1}")
    println()
}


fun main() {
    example1Comparison()
    example2Comparison()
}

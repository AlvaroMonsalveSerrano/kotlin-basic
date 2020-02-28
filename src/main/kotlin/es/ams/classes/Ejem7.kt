package es.ams.classes

class A1{
    val value: String
    init {
        value = "Default"
    }
}


class A2 constructor(pvalue: String){
    val value: String

    init{
        value = pvalue
    }
}

class B private constructor(val value: String){

    companion object{
        fun factory(num: Int): B{
            return when{
                num == 1 -> B(num.toString()+ "private1")
                num == 2 -> B(num.toString()+ "private2")
                else -> B("Factory")

            }
        }
    }

}

fun main() {
    val vA: A1 = A1()
    println("valueA1=${vA.value}")
    println()

    val vA2: A2 = A2("test")
    println("valueA2=${vA2.value}")
    println()

    val vB1: B = B.factory(1)
    println("valueB1=${vB1.value}")
    val vB2: B = B.factory(2)
    println("valueB2=${vB2.value}")
    val vB3: B = B.factory(3)
    println("valueB3=${vB3.value}")
    println()
}

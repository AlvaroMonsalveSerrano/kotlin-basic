package es.ams.classes

open class Father{
    val param1Value: String
    val param2Value: String

    constructor(param1: String){
        param1Value = param1
        param2Value = ""
    }

    constructor(param1: String, param2: String){
        param1Value = param1
        param2Value = param2
    }

    fun operation1(): String {
        return param1Value.plus("-").plus(param2Value)
    }
}

class Son(name:String, address: String): Father(name, address){

    override fun toString(): String {
        return "Son()".plus(param1Value).plus("#").plus(param2Value)
    }
}

fun main() {
    val father = Father("father")
    println("Father=${father.operation1()}")
    println()

    val son = Son("name", "address")
    println("Son=${son}")
    println()
}

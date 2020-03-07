package es.ams.typesystem

fun <T> doSomething(t: T) {
    println("hashCode=${t?.toString()}")
}

class Entity1(val name: String) {
    override fun toString(): String {
        return "Entity1(name='$name')"
    }
}

class Entity2(val name: String) {
    override fun toString(): String {
        return "Entity2(name='$name')"
    }
}

class Entity3(val name: String)

fun main() {

    val entity1 = Entity1("entity1")
    val entity2 = Entity2("entity2")
    val entity3 = Entity3("entity3")

    doSomething(entity1)
    doSomething(entity2)
    doSomething(entity3)

}

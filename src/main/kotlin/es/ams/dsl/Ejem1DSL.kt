package es.ams.dsl

fun example1DSL(): Unit {

    open class Tag(val name: String){

        private val children = mutableListOf<Tag>()

        protected fun <T:Tag> doInit(child: T, init: T.() -> Unit){
            child.init()
            children.add(child)
        }

        override fun toString(): String {
            return "<${name}>${children.joinToString("") }</${name}>"
        }
    }

    class TD: Tag("td") {}

    class TR : Tag("tr") {
        fun td(init: TD.() -> Unit) = doInit(TD(), init)
    }

    class TABLE: Tag("table") {
        fun tr(init: TR.() -> Unit) = doInit(TR(), init)
    }

    fun table(init: TABLE.() -> Unit) = TABLE().apply(init)

    fun createTableOneRow() =
            table {
                tr{
                    td{

                    }
                }
            }

    fun createTableTwoRow() =
            table {
                for(i in 1..2){
                    tr{
                        td{

                        }
                    }
                }
            }

    println("----- Example1 -----")
    println(createTableOneRow())
    println()
    println(createTableTwoRow())
    println()

}

fun main() {

    example1DSL()

}

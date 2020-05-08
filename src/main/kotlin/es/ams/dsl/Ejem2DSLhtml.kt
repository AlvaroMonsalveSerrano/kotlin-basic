package es.ams.dsl.html

    @DslMarker
    annotation class HtmlTagDSL

    abstract class Element{
        abstract fun render(builder: StringBuilder, indent: String): Unit
    }

    class TextElement(
            val text: String
    ): Element(){

        override fun render(builder: StringBuilder, indent: String) {
            builder.append("${indent}${text}")
        }
    }

    @HtmlTagDSL
    open abstract class Tag(
            val name: String
    ): Element(){

        val children = mutableListOf<Element>()
        val attributes = hashMapOf<String, String>()


        protected fun <T: Element> doInit(child: T, init: T.() -> Unit): T{
            child.init()
            children.add(child)
            return child
        }

        override fun render(sbuilder: StringBuilder, indent: String): Unit {
            sbuilder.append("${indent}<${name}${renderAtributtes()}>\n")
            for(child in children){
                child.render(builder = sbuilder, indent = "    ")
            }
            sbuilder.append("${indent}</${name}>\n")
        }

        private fun renderAtributtes(): String {
            val builder = StringBuilder()
            for( (nameAttribute, valueAttribute) in attributes){
                builder.append(" ${nameAttribute}=\"${valueAttribute}\"")
            }
            return builder.toString()
        }

        override fun toString(): String {
            val builder = StringBuilder()
            render(builder, "")
            return builder.toString()
        }
    }


    abstract class TagWithText(name: String): Tag(name){
        operator fun String.unaryPlus(){
            children.add( TextElement(this) )
        }
    }


    open class BodyTag(
            val nameTag: String
    ): TagWithText(nameTag){

        fun table(init: Table.() -> Unit): Table = doInit(Table(), init)

        fun hr(init: Hr.() -> Unit): Hr = doInit(Hr(), init)

        fun hd(init: Hd.() -> Unit): Hd = doInit(Hd(), init)

        fun a(href: String, init: A.() -> Unit) {
            val a = doInit(A(), init)
            a.href = href
        }

    }

    class Head():Tag("head"){}

    class Body():BodyTag("body"){}

    class Table(): BodyTag("table")

    class Hr():BodyTag("hr"){}

    class Hd(): BodyTag("hd")

    class A(): BodyTag("a"){
        var href: String
            get() = attributes["href"]!!
            set(value) {
                attributes["href"] = value
            }

    }


    class Html():Tag("html"){

        fun head(init: Head.() -> Unit): Head = doInit( Head(), init)

        fun body(init: Body.() -> Unit): Body = doInit( Body(), init)

    }

    fun html(init: Html.() -> Unit): Html = Html().apply(init)

    fun createHtml(): Html  =
        html{
            head{}
            body{
                a("http://wwww.domain.es"){}
                table{
                    for(i in 1..2){
                        hr{
                            hd{
                                +"Esto es una ejemplo"
                            }
                        }
                    }
                }
            }
        }




fun main() {
    println(createHtml())
}

package es.ams.others


fun main(args: Array<String>) {

    // Varargs
    val listParam = listOf("args: ", *args)
    println(listParam)

    // Infix notation
    val map = mapOf<Int, String>( 1 to ("one"), 2 to "two", 3.to("three") )
    println(map)

    val kotlinLogo = """| //
                       .|//
                       .|/ \
                       """
    println(kotlinLogo.trimMargin("."))

    val price = """${'$'}99.9"""
    println(price)

}

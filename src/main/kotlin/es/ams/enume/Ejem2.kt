package es.ams.enume

enum class ColorEjem2(
        val r: Int,
        val g: Int,
        val b: Int){

    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b

}

fun main() {
    println("Rojo=${ColorEjem2.RED.rgb()}")
    println("Amarillo=${ColorEjem2.YELLOW.rgb()}")
    println("Azul=${ColorEjem2.BLUE.rgb()}")
    println("Naranja=${ColorEjem2.ORANGE.rgb()}")
}

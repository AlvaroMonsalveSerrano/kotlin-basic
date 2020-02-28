package es.ams.enume

enum class Color{
    RED, ORANGE, YELLOW, GREEN, BLUE,  VIOLET
}

fun getColor(color: Color) =
    when(color) {
        Color.BLUE -> "Azul"
        Color.GREEN -> "Verde"
        Color.ORANGE -> "Naranja"
        Color.RED -> "Rojo"
        Color.VIOLET -> "Violeta"
        Color.YELLOW -> "Amarillo"
    }

fun main() {
    println(getColor(Color.RED))
    println(getColor(Color.YELLOW))
    println(getColor(Color.YELLOW))
    println(getColor(Color.RED))
}


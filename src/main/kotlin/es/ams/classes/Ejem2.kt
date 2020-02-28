package es.ams.classes

class Ejem2Rectangule(
        val height: Int,
        val width: Int) {
    val isSquare: Boolean
        get(){
            return height == width
        }
}

fun main() {
    val rectangule1 = Ejem2Rectangule(2,2)
    println("Rectangule1=[${rectangule1.height}${rectangule1.width}] isSquare=${rectangule1.isSquare}")

    val rectangule2 = Ejem2Rectangule(2,4)
    println("Rectangule2=[${rectangule2.height}${rectangule2.width}] isSquare=${rectangule2.isSquare}")
}

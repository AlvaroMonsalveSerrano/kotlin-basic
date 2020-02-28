package es.ams.enume

import java.lang.Exception
import es.ams.enume.Color.*

fun mix(c1: Color, c2: Color) =
        when( setOf(c1, c2)){
            setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
            setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
            else -> throw Exception("Dirty color")
        }

fun mixOptimizable(c1: Color, c2: Color) =
        when{
            (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
            (c1 == YELLOW && c2 == BLUE) || (c1 == BLUE && c2 == YELLOW ) -> GREEN
            else -> throw Exception("Dirty color")
        }

fun main() {
    println("Mix1=${mix(Color.RED, Color.YELLOW)}")
    println("Mix2=${mix(Color.YELLOW, Color.BLUE)}")
    println()
    println("MixOptimizable1=${mixOptimizable(Color.RED, Color.YELLOW)}")
    println("MixOptimizable2=${mixOptimizable(Color.YELLOW, Color.BLUE)}")
    println()
}

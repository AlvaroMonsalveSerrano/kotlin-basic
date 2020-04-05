package es.ams.operator

import java.lang.IndexOutOfBoundsException
import java.time.LocalDate


fun example1ColecctionRanges(): Unit {

    data class MutablePoint(var x: Int, var y: Int)

    operator fun MutablePoint.set(index: Int, value: Int){
        when(index){
            0 -> x = value
            1 -> y = value
            else -> throw IndexOutOfBoundsException("Invalid coordinate: $index ")
        }
    }

    operator fun MutablePoint.get(index: Int ): Int{
        when(index){
            0 -> return x
            1 -> return y
            else -> throw IndexOutOfBoundsException("Invalid coordinate: $index ")
        }
    }

    val point1 = MutablePoint(10, 10)
    val point2 = MutablePoint(20, 20)

    println("---- Example1 ----")
    println("point1=${point1}")
    println("point2=${point2}")
    point1[0] = 15
    point1[1] = 15
    println("point1=${point1}")
    println()
    println("point1-> [x=${point1[0]}, y=${point1[1]}]")
    println()

}


fun example2CollectionIn(): Unit {

    data class Point(val x: Int, val y: Int)

    data class Rectangule(val upperLeft: Point, val lowerRight: Point)

    operator fun Rectangule.contains(point: Point): Boolean{
        return point.x in upperLeft.x until lowerRight.x &&
               point.y in upperLeft.y until lowerRight.y
    }

    val point1 = Point(2, 2)
    val point2 = Point(5,5)
    val rectangule1 = Rectangule(point1, point2)

    val pointIn = Point(3,3)
    val pointOut = Point(10, 10)

    println("---- Ejemplo2 ----")
    println("pointIn in rectangule?=${rectangule1.contains(pointIn)}")
    println("pointOut in rectangule?=${rectangule1.contains(pointOut)}")
    println()

}


fun example3RangeTo(): Unit {

    val now = LocalDate.now()
    val vacation = now .. now.plusDays(10)

    println("---- Ejem3 ----")
    println("1 week vacation?=${now.plusWeeks(1) in vacation}")
    println("3 week vacation?=${now.plusWeeks(3) in vacation}")
    println()

}

fun example4RangeIterator(): Unit {

    operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> = object : Iterator<LocalDate>{

        var current = start

        override fun hasNext(): Boolean =
            current <= endInclusive

        override fun next(): LocalDate = current.apply {
            current = plusDays(1)
        }
    }

    println("---- Ejem4 ----")
    val newYear = LocalDate.ofYearDay(2020, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for(dayOff in daysOff){
        println("day=${dayOff}")
    }

}

fun main() {
    example1ColecctionRanges()
    example2CollectionIn()
    example3RangeTo()
    example4RangeIterator()
}

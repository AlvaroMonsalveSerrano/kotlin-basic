package es.ams.operator

fun example1(): Unit {

    /**
     * Operator, expression -> Function name:
     *
     *  a * b -> times
     *  a / b -> div
     *  a % b -> mod
     *  a + b -> plus
     *  a - b -> minus
     *
     *  +a -> unaryPlus
     *  -a -> unaryMinus
     *  !a -> not
     *  ++a, a++ -> inc
     *  --a, a-- -> dec
     *
     */
    data class Point(val x: Int, val y: Int){
        operator fun plus(other: Point): Point {
            return Point(x + other.x, y + other.y)
        }

        operator fun times(other: Point): Point{
            return Point(x * other.x, y * other.y)
        }

        operator fun times(num: Int): Point {
            return Point( x * num, y * num)
        }

        operator fun minus(other: Point): Point{
            return Point(x - other.x, y - other.y)
        }

        operator fun inc(): Point {
            return Point(x + 1 , y + 1)
        }

        operator fun unaryMinus(): Point {
            return Point(-x, -y)
        }
    }

    val point1 = Point(10, 10)
    val point2 = Point(20, 20)
    println("---- Example1 ----")
    println("point1 + point2=${point1 + point2}")
    println("point1.plus(point2)=${point1.plus(point2)}")
    println()
    println("point1 * point2=${point1 * point2}")
    println("point1.times(point2)=${point1.times(point2)}")
    println()
    println("point1 * 2=${point1 * 2}")
    println("point1.times(2)=${point1.times(2)}")
    println()
    println("point1 - point2=${point1 - point2}")
    println("point1.minus(point2)=${point1.minus(point2)}")
    println()

    var pointAux1 = Point(10, 10)
    println("++pointAux1=${++pointAux1}")
    println("pointAux1.inc()=${pointAux1.inc()}")
    println()

    var pointAux2 = Point(10, 10)
    println("--pointAux2=${-pointAux2}")
    var pointAux22 = Point(10, 10)
    println("pointAux2.unaryMinus()=${pointAux22.unaryMinus()}")
    println()


}

fun example2(): Unit {

    /**
     * Operator, expression -> Function name:
     *
     *  a * b -> times
     *  a / b -> div
     *  a % b -> mod
     *  a + b -> plus
     *  a - b -> minus
     */
    data class PointBase(val x: Int, val y: Int)

    operator fun PointBase.plus(other: PointBase): PointBase {
        return PointBase(x + other.x + 100, y + other.y + 100)
    }

    operator fun PointBase.times(other: PointBase): PointBase {
        return PointBase(x * other.x + 100, y * other.y + 100)
    }

    operator fun PointBase.times(num: Int): PointBase {
        return PointBase( x * num, y * num)
    }

    operator fun PointBase.minus(other: PointBase): PointBase {
        return PointBase(x - other.x, y - other.y)
    }

    val point1 = PointBase(10, 10)
    val point2 = PointBase(20, 20)
    println("---- Example2 ----")
    println("point1 + point2=${point1 + point2}")
    println("point1.plus(point2)=${point1.plus(point2)}")
    println()
    println("point1 * point2=${point1 * point2}")
    println("point1.times(point2)=${point1.times(point2)}")
    println()
    println("point1 * 2=${point1 * 2}")
    println("point1.times(2)=${point1.times(2)}")
    println()
    println("point1 - point2=${point1 - point2}")
    println("point1.minus(point2)=${point1.minus(point2)}")
    println()

}

fun example3(): Unit {

    data class PointBase(var x: Int, var y: Int){
        operator fun plusAssign(other: PointBase): Unit {
            x += other.x
            y += other.y
        }
    }

    val point1 = PointBase(10, 10)
    val point2 = PointBase(20, 20)
    println("---- Example3 ----")
    point1 += point2
    println("point1 += point2=${point1}")
    point1.plusAssign(point2)
    println("point1.plusAssign(point2)=${point1}")
    println()

}

fun example4(): Unit {

    data class PointBase4(var x: Int, var y: Int)

    operator fun PointBase4.plusAssign(other: PointBase4): Unit {
        x += other.x
        y += other.y
    }

    val point1 = PointBase4(10, 10)
    val point2 = PointBase4(20, 20)
    println("---- Example4 ----")
    point1 += point2
    println("point1 += point2=${point1}")
    point1.plusAssign(point2)
    println("point1.plusAssign(point2)=${point1}")
    println()

}

fun main() {
    example1()
    example2()
    example3()
    example4()
}

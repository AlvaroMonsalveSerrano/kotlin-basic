package es.ams.ifwhen

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e
        return n.value
    }
    if (e is Sum) {
        return eval(e.left) + eval(e.right)
    }
    throw IllegalArgumentException("Unknown expression")
}


fun eval2(e: Expr): Int =
        if (e is Num) {
            e.value
        } else if (e is Sum) {
            eval2(e.left) + eval2(e.right)
        } else {
            throw IllegalArgumentException("Unknown expression")
        }

fun eval3(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> eval3(e.left) + eval3(e.right)
            else -> throw IllegalArgumentException("Unknown expression")
        }

fun main() {
    println("1+4=${eval(Sum(Num(1), Num(4)))}")
    println("1+4=${eval2(Sum(Num(1), Num(4)))}")
    println("1+4=${eval3(Sum(Num(1), Num(4)))}")
}

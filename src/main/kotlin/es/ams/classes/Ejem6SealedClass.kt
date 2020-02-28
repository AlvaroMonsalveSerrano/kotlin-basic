package es.ams.classes

sealed class Expr{
    class Num(val value:Int): Expr()
    class Sum(val left: Expr, val right: Expr): Expr()
}

fun evalSum(exp: Expr): Int =
        when(exp){
            is Expr.Num -> exp.value
            is Expr.Sum -> evalSum(exp.left) + evalSum(exp.right)
        }


fun main() {
    val expr = Expr.Sum( Expr.Num(4), Expr.Num(7) )
    println("(4+7)=${evalSum(expr)}")
    println()
}

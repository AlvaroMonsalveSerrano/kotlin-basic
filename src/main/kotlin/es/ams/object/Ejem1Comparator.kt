package es.ams.`object`

object IntegerComparator: Comparator<Int>{
    override fun compare(o1: Int?, o2: Int?): Int {
        return o1!!.compareTo(o2!!)
    }
}


fun main() {
    val intComparator = IntegerComparator
    println("compare(2,3)=${intComparator.compare(2,3)}")
    println()

    val listInt = listOf<Int>(7,9,33,55)
    val sortListInt = listInt.sortedWith(intComparator)
    println("sortListInt=${sortListInt}")
    println()
}

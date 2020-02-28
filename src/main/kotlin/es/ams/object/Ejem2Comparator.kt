package es.ams.`object`

data class User(
        val id:Int,
        val name: String){

    object IdComparator: Comparator<User>{
        override fun compare(o1: User?, o2: User?): Int {
            return o1!!.id.compareTo(o2!!.id)
        }
    }
}

fun main() {

    val user1 = User(1, "user1")
    val user2 = User(2, "user2")
    val user3 = User(3, "user3")
    val user4 = User(4, "user4")

    val listUser = listOf<User>(user4, user1, user3, user2)
    println("listUser=${listUser}")
    val sortListUser = listUser.sortedWith(User.IdComparator)
    println("sortListUser=${sortListUser}")
    println()

}

package es.ams.classes

class UserClass private constructor(val name: String){

    companion object{
        fun newUserClass(pName: String): UserClass {
            return UserClass(pName)
        }

        fun newuserClassWithSuffix(pName: String): UserClass {
            return UserClass(pName.plus("_Suffix"))
        }
    }

    override fun toString(): String {
        return "UserClass(name='$name')"
    }

}


class PersonClass private constructor(val name: String) {

    companion object Loader{
        fun newUserClass(pName: String): PersonClass {
            return PersonClass(pName)
        }

        fun newUserClassWithSuffix(pName: String): PersonClass {
            return PersonClass(pName.plus("_Suffix"))
        }
    }

    override fun toString(): String {
        return "PersonClass(name='$name')"
    }

}

interface LoadBook {
    fun createDefaultBook(): BookClass
}

class BookClass private constructor(val name: String) {

    companion object Loader: LoadBook{

        override fun createDefaultBook(): BookClass {
            return BookClass("DefaultNameBook")
        }

        fun newBookClass(pName: String): BookClass {
            return BookClass(pName)
        }

        fun newBookClassWithSuffix(pName: String): BookClass {
            return BookClass(pName.plus("_Suffix"))
        }
    }

    override fun toString(): String {
        return "PersonClass(name='$name')"
    }

}

fun main() {
    val user1: UserClass = UserClass.newUserClass("nameUser")
    println("user1=${user1}")
    val user2: UserClass = UserClass.newuserClassWithSuffix("nameUser")
    println("user2=${user2}")
    println()


    val person1: PersonClass = PersonClass.Loader.newUserClass("nameUser")
    println("Person1=${person1}")
    val person2: PersonClass = PersonClass.Loader.newUserClassWithSuffix("nameUser")
    println("Person2=${person2}")
    println()

    val book1: BookClass = BookClass.Loader.newBookClass("nameUser")
    println("Book1=${book1}")
    val book2: BookClass = BookClass.Loader.newBookClassWithSuffix("nameUser")
    println("Book2=${book2}")
    val book3: BookClass = BookClass.Loader.createDefaultBook()
    println("Book3=${book3}")
    println()

}

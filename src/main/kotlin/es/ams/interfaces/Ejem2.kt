package es.ams.interfaces

interface User{
    val name: String
}

class UserBusiness(
        override  val name: String
): User{

    override fun toString(): String {
        return "UserBusiness(name='$name')"
    }
}

class UserSport(val nameSport: String): User{
    override val name: String
        get() = "UserSport"

    override fun toString(): String {
        return "UserSport(nameSport='$nameSport')"
    }
}

class UserFolk(): User{
    override val name: String = "Peter"
        get() = "$field"

    var address: String = "Default"
        get() = "${field}"
        set(value: String){
            field = value
        }

    override fun toString(): String {
        return "UserFolk() name=${name} address=${address}"
    }
}

fun main() {

    val userBusiness = UserBusiness("nameUserBusiness")
    println("userBusiness=${userBusiness}")
    println("userBusiness.name=${userBusiness.name}")
    println()

    val userSport = UserSport("UserSportConstructor")
    println("userSport=${userSport.name}")
    println("userSport=${userSport.nameSport}")
    println("userSport=${userSport}")
    println()

    val userFolk = UserFolk()
    println("userFolk.name=${userFolk.name}")
    println("userFolk.address=${userFolk.address}")
    println("userFolk=${userFolk}")
    userFolk.address = "MyAddress"
    println("userFolk.address=${userFolk.address}")
    println()

}

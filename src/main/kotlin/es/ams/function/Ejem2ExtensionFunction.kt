package es.ams.function

data class User(val id: Int, val name: String, val address: String)

fun User.validateSave(){
    fun validate (value: String, fieldName: String){
        if(value.isEmpty()){
            throw IllegalArgumentException("User='${id}' empty field '${fieldName}'")
        }
    }
    validate(name, "name")
    validate(address, "address")

}

fun saveUser(user: User){
    fun validate (value: String, fieldName: String){
        if(value.isEmpty()){
            throw IllegalArgumentException("User='${user.id}' empty field '${fieldName}'")
        }
    }
    validate(user.name, "name")
    validate(user.address, "address")
    println("Saved")
}


fun exampleSaveUser1(): Unit {
    println("--- Function ---")
    val user1 = User(id = 1, name = "Name", address = "Address")
    saveUser(user1)

    try{
        val user2 = User(id = 1, name = "", address = "Address")
        saveUser(user2)

    }catch(ex: java.lang.IllegalArgumentException){
        println(ex.message)
    }
    println()
}

fun exampleSaveUser2(): Unit {
    println("--- Extension function ---")
    val user1 = User(id = 1, name = "Name", address = "Address")
    user1.validateSave()
    saveUser(user1)

    try{
        val user2 = User(id = 1, name = "", address = "Address")
        user2.validateSave()
        saveUser(user2)

    }catch(ex: java.lang.IllegalArgumentException){
        println(ex.message)
    }
    println()

}

fun main() {
    exampleSaveUser1()

    exampleSaveUser2()
}

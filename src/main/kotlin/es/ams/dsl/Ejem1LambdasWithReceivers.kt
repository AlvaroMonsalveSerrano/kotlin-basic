package es.ams.dsl

fun example1LambdaWithReceivers(): Unit {

    // Function with lambda
    fun buildString(
            builderAction: (StringBuilder) -> Unit
    ):String{
        val sb = StringBuilder()
        builderAction(sb)
        return sb.toString()
    }

    val s = buildString {
        it.append("Hello, ")
        it.append("World! ")
    }

    println("----- Example1 -----")
    println("1.- Function Lambda=${s}")
    println()

    // Lambda with receiver
    fun buildStringReceiver(
            builderAction: StringBuilder.() -> Unit
    ): String{
        val s = StringBuilder()
        s.builderAction()
        return s.toString()
    }

    val r = buildStringReceiver{
        this.append("Hello, ")
        this.append("World! ")
    }

    println("2.- Function Lambda receiver=${r}")
    println()

}

fun example2LambdaWithReceivers(): Unit {

    data class Account(
            val id: Int,
            val amount: Int,
            val result: Int,
            val status: String
    )

    fun calculate30(
            init: Account,
            func: (Account) -> Account): Account{
        val account = init.copy(amount = 30)
        return func(account)
    }

    println("----- Example2 -----")
    val account1 = Account(id = 1, amount = 0, result = 0, status = "INIT")
    val CTE = 3

    val fLambda = calculate30(account1){
        it.copy( result = (it.amount * 6) * CTE, status = "END"  )
    }

    println("1.- Account30 (lambda function)=${fLambda}")
    println()

    fun calculate30Receiver(
            init: Account,
            func: Account.() -> Account
    ): Account{
        val account = init.copy(amount = 30)
        return account.func()
    }

    val fLReceiver = calculate30Receiver(account1){
        this.copy(result = (this.amount * 6) * CTE, status = "END" )
    }

    println("2.- Account30Receiver(lambda with receiver)=${fLReceiver}")
    println()

}

fun main() {
    example1LambdaWithReceivers()
    example2LambdaWithReceivers()
}

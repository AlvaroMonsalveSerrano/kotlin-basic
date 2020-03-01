package es.ams.lambdas

import kotlin.text.StringBuilder


fun example1With(){

    println("---- Function With ----")

    fun alphabet(): String{
        val result = StringBuilder()
        for(letter in 'A'..'Z'){
            result.append(letter)
        }
        result.append("\nThe Alphabet!")
        return result.toString()
    }

    println("Alphabet=${alphabet()}")
    println()

    fun alphabetWith(): String{
        val stringBuilder = StringBuilder()
        // Argument:1, StringBuilder; 2, function lambda
        return with(stringBuilder){
            for(letter in 'A'..'Z'){
                this.append(letter)
            }
            this.append("\nThe alphabet with function With")
            this.toString()
        }
    }

    println("Alphabet=${alphabetWith()}")
    println()

}

fun example1Apply(){

    println("---- Function Apply ----")
    fun aphabetApply(): String{
        // Argument: StringBuilder; return, StringBuilder
        return StringBuilder().apply {
            for(letter in 'A'..'Z'){
                append(letter)
            }
            append("The alphabet with function Apply")
        }.toString()
    }

    println("Alphabet=${aphabetApply()}")
    println()

}

fun main() {
    example1With()
}

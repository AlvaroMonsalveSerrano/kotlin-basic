package es.ams.lambdas

import java.io.BufferedReader
import java.io.FileReader

fun example1HOF(): Unit {

    class UtilFile{

        fun readFirstLineFromFile(path:String): String {
            val classLoader: ClassLoader = UtilFile().javaClass.classLoader
            val pathAux = classLoader.getResource(path)!!.path!!

            // 'use' function to management resources
            BufferedReader(FileReader( pathAux )).use {br ->
                return br.readLine()
            }
        }

    }

    val path ="file1hof.txt"
    println("==>>${UtilFile().readFirstLineFromFile(path)}")
    println()

}

fun main() {
    example1HOF()
}

package es.ams.classes

abstract class Animated{

    abstract fun animate()

    open fun start(){
        println("Start")
    }

    open fun stop(){
        println("Stop")
    }

}

class Film1: Animated(){
    override fun animate() {
        println("Do film1")
    }
}

class Film2: Animated(){
    override fun animate() {
        println("Do film2")
    }
}


fun main() {
    val film1: Film1 = Film1()
    film1.start()
    film1.animate()
    film1.stop()
    println("")

    val film2: Film2 = Film2()
    film2.start()
    film2.animate()
    film2.stop()
    println("")
}

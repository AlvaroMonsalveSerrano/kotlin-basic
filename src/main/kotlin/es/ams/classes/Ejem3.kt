package es.ams.classes

interface Clickable{
    fun click(): Unit
}

open class RichButton: Clickable{

    // Open function
    override fun click() {
        println("RichButton.click()")
    }

    // This function is final.
    fun disable(){
        println("RichButton.disable()")
    }

    // Overrride in subclasses.
    open fun animate(){
        println("RichButton.animate()")
    }

    final fun action(){
        println("Do somethig.")
    }
}

class RichButtonHierarchy(): RichButton() {
    override fun animate() {
        super.animate()
        println("[**] RichButtonHierarchy.animate()")
    }

    override fun click() {
        super.click()
        println("[**] RichButtonHierarchy.click()")
    }
}

fun main() {
    val btn1: RichButtonHierarchy = RichButtonHierarchy()
    btn1.animate()
    btn1.click()
    btn1.disable()
    btn1.action()
}

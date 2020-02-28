package es.ams.interfaces

interface Clickable{
    fun click(): Unit
    fun showOff(): Unit = println("Clickable")
}

interface Focusable{
    fun setFocus(b: Boolean): Unit = println("I ${ if(b) "got" else "lost" } focus")

    fun showOff(): Unit = println("Focusable")
}

class Button: Clickable, Focusable {
    override fun click() {
        println("Btn clickable")
    }

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main() {
    val btn: Button = Button()
    btn.click()
    btn.showOff()
}

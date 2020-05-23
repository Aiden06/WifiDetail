package spices

abstract sealed class Spice(val name: String, val spiciness: String = "mild", color : SpiceColor) :
        SpiceColor by color {
    val heat: Int
        get() {return when(spiciness){
            "mild" -> 1
            "medium" -> 3
            "spicy" -> 5
            "very spicy" -> 7
            "extremely spicy" -> 10
            else -> 0}
        }

    init {
        println("$name, $spiciness")
    }

    fun makeSalt(){}

    abstract fun prepareSpice()
}

interface Grinder{
    fun grind()
}

class Curry(name: String, spiciness: String, spiceColor: SpiceColor = YellowSpiceColor) :
        Spice(name, spiciness, spiceColor),
        Grinder{
    override fun prepareSpice(){

    }

    override fun grind() {
        TODO("Not yet implemented")
    }
}

interface SpiceColor{
    var color : Color
}

object YellowSpiceColor : SpiceColor{
    override var color: Color = Color.YELLOW
}

data class SpiceContainer(var spice: Spice) {
    val label:String = spice.name
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00);
}

fun main(){
    val curry = Curry(name = "curry", spiciness = "spicy")
    println(curry.color)

    val curryContainer = SpiceContainer(curry)
    println(curryContainer.label)
}
package spice

class Spice(private val name: String, private val spiceness: String = "mild") {
    val heat: Int
        get() {return when(spiceness){
            "mild" -> 1
            "medium" -> 3
            "spicy" -> 5
            "very spicy" -> 7
            "extremely spicy" -> 10
            else -> 0}
        }

    init {
        println("$name, $spiceness")
    }

    fun makeSalt(){}
}
fun main(){
    println(whatShouldIDoToday(readLine()!!))
}

fun whatShouldIDoToday(mood: String, weather: String="Sunny", temperature: Int=24) : String{
    return when{
        isHappy(mood, weather) -> "go for a walk"
        isSad(mood, weather, temperature) -> "stay in bed"
        isHot(temperature) -> "go swimming"
        else -> "Stay home and read."
    }
}

fun isHappy(mood: String, weather: String) = mood == "happy" && weather == "Sunny"
fun isSad(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0
fun isHot(temperature: Int) = temperature > 35

import kotlin.math.absoluteValue

enum class Directions{
    NORTH, SOUTH, EAST, WEST, START, END
}

class Game{
    var path = mutableListOf(Directions.START)
    var x = 0
    var y = 0
    val width = 4
    val height = 4
    val map = Array(width) { arrayOfNulls<String>(height) }

    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val east = { path.add(Directions.EAST) }
    val west = { path.add(Directions.WEST) }
    val end = { path.add(Directions.END)
        println("Game Over")
        println(path)
        path.clear()
        false
    }

    fun move(where: ()-> Boolean){
        where()
        updateLocation(where)
    }

    fun makeMove(direction: String?){
        when(direction){
            "n"     -> move(north)
            "s"     -> move(south)
            "e"     -> move(east)
            "w"     -> move(west)
            else    -> move(end)
        }
    }


    init {
        map[0][0] = "00"
        map[0][1] = "01"
        map[0][2] = "02"
        map[0][3] = "03"
        map[1][1] = "11"
        map[1][2] = "12"
        map[1][3] = "13"
        map[2][1] = "21"
        map[2][2] = "22"
        map[2][3] = "23"
        map[3][1] = "31"
        map[3][2] = "32"
        map[3][3] = "33"
    }

    fun updateLocation(where: () -> Boolean){
        when(where){
            north -> y = (y+3).rem(height)
            south -> y = (y+1).rem(height)
            east -> x = (x+3).rem(width)
            west ->  x = (x+1).rem(width)
            else -> {}
        }
        println(map[x][y])
    }
}

fun main()
{
    /*
    val game = Game()
    println(game.path)
    game.north()
    game.east()
    game.south()
    game.west()
    game.end()
    println(game.path)
    */

    val game2 = Game()
    while (true){
        print("Enter a direction: n/s/e/w:")
        readLine()?.let { game2.makeMove(it) }
    }
}
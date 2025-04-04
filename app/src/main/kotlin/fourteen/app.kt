package fourteen

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun readInput(filename: String): List<String> = Path("14.txt").readLines()
val lines = readInput("");

data class Coordinate(val x: Int, val y: Int)
data class Robot(val pos: Coordinate, val velocity: Coordinate)

val robots: MutableList<Robot> = mutableListOf()
fun main(){
    for (line in lines){
        val values = line
            .filterNot { it == 'p' || it == '=' }
            .replace(Regex(".(?=v)"), ",")
            .filterNot { it == 'v' }
            .split(',')
        robots.add(Robot(Coordinate(values[0].toInt(), values[1].toInt()), Coordinate(values[2].toInt(), values[3].toInt())))
    }

}


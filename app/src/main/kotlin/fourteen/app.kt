package fourteen

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun readInput(filename: String): List<String> = Path("14.txt").readLines()
val lines = readInput("\"3.txt\"");
val grid: MutableList<MutableList<Char>> = lines.map { it.toMutableList() }.toMutableList()
var starts: MutableList<Pair<Int, Int>> = mutableListOf()


data class Coordinate(val x: Int, val y: Int)
data class Robot(val pos: Coordinate, val velocity: Coordinate)

val robots: MutableList<Robot> = mutableListOf()
fun main(){
    for (line in lines){

        var g = line.filterNot { it == 'p' }
        var s = g.filterNot { it == '=' }
        val output = s.replace(Regex(".(?=v)"), ",")
        var f = output.filterNot { it == 'v' }
        var values = f.split(',')
        robots.add(Robot(Coordinate(values[0].toInt(), values[1].toInt()), Coordinate(values[2].toInt(), values[3].toInt())))
    }
    for (robot in robots){
        println(robot.pos.x + robot.pos.y)
        println(robot.velocity.x + robot.velocity.y)
    }

}


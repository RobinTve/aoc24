package fourteen

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun readInput(filename: String): List<String> = Path("14.txt").readLines()
val lines = readInput("");

data class Coordinate(var x: Int, var y: Int)
data class Robot(val pos: Coordinate, val velocity: Coordinate)

val robots: MutableList<Robot> = mutableListOf()
val grid = Array(103) { CharArray(101) { '0' } }
var part2Seconds = 0
fun main(){
    for (line in lines){
        val values = line
            .filterNot { it == 'p' || it == '=' }
            .replace(Regex(".(?=v)"), ",")
            .filterNot { it == 'v' }
            .split(',')
        robots.add(Robot(Coordinate(values[0].toInt(), values[1].toInt()), Coordinate(values[2].toInt(), values[3].toInt())))
    }
    for (robots in robots){
        grid[robots.pos.y][robots.pos.x] ++
    }

    moveRobots(1000)
    var leftQuad = ""
    var rightQuad = ""

    for ((index, row) in grid.withIndex()) {
        if (index == grid.size / 2) continue

        leftQuad += row.joinToString("").substring(0, (row.size - 1) / 2)
        rightQuad += row.joinToString("").substring((row.size + 1) / 2, row.size)
    }

    println(leftQuad.length)
    println(rightQuad.length)

    fun sumDigits(s: String) = s.sumOf { it.digitToInt() }

    val lef = leftQuad.substring(0, (leftQuad.length) / 2)
    val laf = leftQuad.substring((leftQuad.length + 1) / 2, leftQuad.length)
    val ref = rightQuad.substring(0, (rightQuad.length) / 2 )
    val raf = rightQuad.substring((rightQuad.length+ 1)/ 2, rightQuad.length)

    val toplef = sumDigits(lef)
    val botlef = sumDigits(laf)
    val topright = sumDigits(ref)
    val botright = sumDigits(raf)
    println("Part 1:")
    println(toplef * botlef * topright * botright)
    println("Part 2:")
    println(part2Seconds)
}

fun moveRobots(n: Int){

    val height = grid.size
    val width = grid[0].size

    while(!checkOverlap(grid)) {

        part2Seconds++

        for (robot in robots) {

            grid[robot.pos.y][robot.pos.x]--

            val newX = (robot.pos.x + robot.velocity.x + width) % width
            val newY = (robot.pos.y + robot.velocity.y + height) % height

            robot.pos.x = newX
            robot.pos.y = newY

            grid[newY][newX]++
        }
    }
}

fun checkOverlap(grid: Array<CharArray>): Boolean {
    for (row in grid) {
        for (cell in row) {
            if (cell > '1') {
                return false
            }
        }
    }
    return true
}


fun part1(n: Int){

    val height = grid.size
    val width = grid[0].size

    repeat(n) {
        for (robot in robots) {
            grid[robot.pos.y][robot.pos.x]--

            val newX = (robot.pos.x + robot.velocity.x + width) % width
            val newY = (robot.pos.y + robot.velocity.y + height) % height

            robot.pos.x = newX
            robot.pos.y = newY

            grid[newY][newX]++
        }
    }
}
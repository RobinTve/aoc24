package org.example

import java.io.File
import java.io.InputStream
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.io.path.readLines
import kotlin.math.abs


//fun readInput(filename: String): List<String> = Path("3.txt").readLines()
//
//fun main() {
//    val lines = readInput("\"3.txt\"");
//    val grid: MutableList<MutableList<Char>> = lines.map { it.toMutableList() }.toMutableList()
//
//    var startX = 0;
//    var startY = 0
//    var direction = "up"
//    var visited = 1;
//
//    val height = grid.size
//    val width = grid[0].size
//    val obstacles: MutableSet<Pair<Int, Int>> = mutableSetOf<Pair<Int, Int>>()
//
//    grid.forEach { println(it.joinToString("")) }
//    var pos = 0 to 0
//    grid.forEachIndexed {y, s ->
//        s.forEachIndexed{x, c ->
//            if(c == '#'){
//                obstacles.add(x to y)
//            }
//            if(c == '^'){
//                pos = x to y
//            }
//        }
//    }
//
//
//    val dirs: List<Pair<Int, Int>> = listOf(
//        0 to -1,
//        1 to 0,
//        0 to 1,
//        -1 to 0
//    )
//    var currentDir : Pair<Int, Int> = dirs[0]
//
//    fun turnRight(){
//        val i = (dirs.indexOf(currentDir) + 1) % dirs.size
//        currentDir = dirs[i]
//    }
//
//    fun nextPos(): Pair<Int, Int> =
//        (pos.first + currentDir.first) to (pos.second + currentDir.second)
//
//    fun stepForward(){
//        pos = nextPos()
//    }
//
//    val visiteds: MutableSet<Pair<Int, Int>> = mutableSetOf(pos)
//
//    while(pos.first in 0 .. width && pos.second in 0 .. height){
//        visiteds += pos;
//        val next = nextPos()
//        if(next in obstacles){
//            turnRight()
//        } else{
//            stepForward()
//        }
//    }
//    println(visiteds.size)
//
//
//
//
//










//    for ((y, row) in grid.withIndex()) {
//        for ((x, char) in row.withIndex()) {
//            if (char == '^') {
//                startX = x
//                startY = y
//                break
//            }
//        }
//    }


//    for(i in 1..60) {
//        if (direction == "up") {
//            if (startY - 1 < 0) break
//            println("niufkjnsaa")
//            if (grid[startY-1][startX] == '#') {
//                direction = "right"
//                grid[startY][startX] = 'x'
//                if (startX + 1 >= grid[0].size) break
//                startX++;
//                visited++;
//            } else{
//            grid[startY][startX] = 'x'
//            startY--
//            visited++;
//            }
//        }
//        if (direction == "right") {
//            if (grid[startY][startX+1] == '#') {
//                direction = "down"
//                grid[startY][startX] = 'x'
//                startY++;
//                visited++;
//            }else {
//                if (startX + 1 >= grid[0].size) break
//                grid[startY][startX] = 'x'
//                startX++
//                visited++;
//            }
//        }
//        if (direction == "down") {
//            if (startY + 1 == grid.size) break
//            if (grid[startY+1][startX] == '#') {
//                direction = "left"
//                grid[startY][startX] = 'x'
//                startX--;
//                visited++;
//            }else {
//                grid[startY][startX] = 'x'
//                startY++
//                visited++;
//            }
//        }
//        if (direction == "left") {
//            if (grid[startY][startX-1] == '#') {
//                direction = "up"
//                grid[startY][startX] = 'x'
//                startY--;
//                visited++;
//            }else {
//                grid[startY][startX] = 'x'
//                startX--
//                visited++;
//            }
//        }
//    }
//    println(startY)
//    println(startX)
//    println(visited)
//    grid.forEach { println(it.joinToString("")) }
//}



//fun main() {
//
//
//    val input = "5910927 0 1 47 261223 94788 545 7771"
//    val inputList = input.split(" ").filter { it.isNotEmpty() }  // Remove empty strings
//
//    var k = 0
//
//    fun blink(n: Int, lista: List<String>): List<String> {
//        val newResult = mutableListOf<String>()
//
//        if (n == k) {
//            return lista
//        }
//
//        for (number in lista) {
//            if (number == "0") {
//                newResult.add("1")
//            } else if (number.length % 2 == 0) {
//                val leftPart = number.substring(0, number.length / 2)
//                val rightPart = number.substring(number.length / 2)
//
//                if (rightPart.isNotEmpty()) {
//                    newResult.add(leftPart)
//                    newResult.add(rightPart.toLong().toString())  // Convert safely
//                } else {
//                    newResult.add(leftPart)
//                    println("fdsds")
//                }
//            } else {
//                val result = (number.toLong() * 2024).toString()
//                newResult.add(result)
//            }
//        }
//
//        k++
//        return blink(n, newResult.filter { it.isNotEmpty() })
//    }
//
//    println(blink(75, inputList).size)
//}
var cou = 0;
fun check(n: Pair<Int, Int>) {
    val visitedPaths: MutableList<Pair<Int, Int>> = mutableListOf()
    if(grid[n.first][n.second] == '9' && !visitedPaths.contains(n.first to n.second)){
        cou++
        visitedPaths.add(n.first to n.second)
    }
    checkForPath(n)
}

fun checkForPath(n: Pair<Int, Int>) {

    if (n.first < 0 || n.first >= grid.size || n.second < 0 || n.second >= grid[0].size) {
        return
    }


    println("Current: ${grid[n.first][n.second]} at (${n.first}, ${n.second})")

    //right
    if (n.second + 1 < grid[0].size && grid[n.first][n.second + 1] == grid[n.first][n.second] + 1) {
        val nextPos = n.first to (n.second + 1)
        check(nextPos)
    }

    //left
    if (n.second - 1 >= 0 && grid[n.first][n.second - 1] == grid[n.first][n.second] + 1) {
        val nextPos = n.first to (n.second - 1)
        check(nextPos)
    }

    // down
    if (n.first + 1 < grid.size && grid[n.first + 1][n.second] == grid[n.first][n.second] + 1) {
        val nextPos = (n.first + 1) to n.second
        check(nextPos)
    }

    // up
    if (n.first - 1 >= 0 && grid[n.first -1][n.second] == grid[n.first][n.second] + 1) {
        val nextPos = (n.first -1) to n.second
        check(nextPos)
    }
}

fun readInput(filename: String): List<String> = Path("3.txt").readLines()
val lines = readInput("\"3.txt\"");
val grid: MutableList<MutableList<Char>> = lines.map { it.toMutableList() }.toMutableList()
var starts: MutableList<Pair<Int, Int>> = mutableListOf()
fun main() {


    for (line in lines){
        for (i in 0..line.length-1){
            if(line[i] == '0'){
                starts.add(lines.indexOf(line) to i)
            }
        }
    }






    var paths = 0



    for (start in starts){
        check(start)
        paths += cou
        cou = 0;

    }
    println(paths)


}
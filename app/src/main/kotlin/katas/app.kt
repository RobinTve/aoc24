package katas

fun kata1() {
    val input = listOf("w", "o", "r", "l", "d", "", "h", "e", "l", "l", "o", "", "s","a", "y")
    var words = ""
    for (chars in input){
        if (chars.isEmpty()){
            words += " "
        }
        words += chars;
    }
    var wordList = words.split(" ").reversed()
    var result = ""
    for (words in wordList){
        result += words
        result += " "
    }
    var resultList = mutableListOf("")
    for (chars in result){
        resultList.add(chars.toString())
    }
    println(resultList)
}


fun kata2(){
    val input = listOf(10, 7, 5, 8, 11, 9)
    var buy = input[0]
    var profit = 0

    for(i in input.indices){
        if(buy > input[i]){
            buy = input[i];
        }

        profit = Math.max(profit, input[i] - buy);
    }
    println(profit)

}

fun kata3(){
    fun findFib(n: Int): Int {
        var list = mutableListOf(0, 1)
        for(i in 1..n){
            list.addLast(list[i] + list[i-1])
        }
        return list[n];
    }

    println(findFib(4))
}

fun kata4(){
    var input = "race a car"
    val re = Regex("[^A-Za-z0-9 ]")
    input = re.replace(input, "")
    input = input.replace(" ", "").lowercase()

    if(input == input.reversed()){
        println(true)
    }
    else{
        println(false)
    }
}

fun kata5(){
    var stack = mutableListOf<Int>()

    fun push(n: Int){
        stack.addLast(n)
    }
    fun top(): Int {
        if(stack.isNotEmpty()){
            return stack.last()
        }
        return 0
    }
    fun pop(){
        stack.removeLast()
    }

    push(3)
    pop()

    fun getMin(): Int {
        return stack.min()
    }

    println(getMin())
}

    fun insertionSort(arr: IntArray) {
        for (i in 1 until arr.size) {
            val currentElement = arr[i]
            var j = i - 1

            while (j >= 0 && arr[j] > currentElement) {
                arr[j + 1] = arr[j]
                j--
            }
            arr[j + 1] = currentElement
        }
    }
    fun main() {
        kata1()
        kata2()
        kata3()
        kata4()
        kata5()

        //Kata 6
        val arr = intArrayOf(64, 33, 25, 12, 22, 11, 90)
        println(arr.joinToString())

        insertionSort(arr)

        println(arr.joinToString())
    }


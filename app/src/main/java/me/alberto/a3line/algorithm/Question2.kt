package me.alberto.a3line.algorithm

fun rotate(input: Array<Int>, num: Int = 3): ArrayList<Int> {
    val numbers = input.copyOf().toMutableList()
    var rotatedNums = arrayListOf<Int>()
    if (numbers.size == 1) {
        return numbers as ArrayList<Int>
    }

    for (i in 1..num) {
        val temp = arrayListOf<Int>()
        if (rotatedNums.isEmpty()) {
            temp.addAll(numbers)
        } else {
            temp.addAll(rotatedNums)
        }
        rotatedNums = arrayListOf()
        val firstItem = temp.first()
        temp.removeAt(0)
        rotatedNums.addAll(temp)
        rotatedNums.add(firstItem)
        println(i)
    }
    println(rotatedNums.toString())
    return rotatedNums

}
package me.alberto.a3line.algorithm

fun afterDays(cells: ArrayList<Int>, days: Int): ArrayList<Int> {
    var output = arrayListOf<Int>()

    for (i in 1..days) {
        val temp = arrayListOf<Int>()
        if (output.isEmpty()) {
            temp.addAll(cells)
        } else {
            temp.addAll(output)
        }
        //Clear for new data
        output = arrayListOf()

        for (position in cells.indices) {
            val previous = temp.getOrNull(position - 1) ?: 0
            val next = temp.getOrNull(position + 1) ?: 0

            if (previous == next) {
                output.add(0)
            } else {
                output.add(1)
            }
        }
    }

    return output
}
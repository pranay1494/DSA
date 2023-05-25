package gojek.merginginterval

import java.util.*

class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val list = arrayListOf<Intervals>()
        val stack = Stack<Intervals>()

        if (intervals.size == 0) return arrayOf()

        intervals.forEachIndexed { index, ints ->
            list.add(Intervals(
                    low = intervals[index][0],
                    high = intervals[index][1],
            ))
        }

        list.sortWith(Comparator.comparingInt{
            it.low
        })

        stack.push(list[0])

        for (i in 1 until list.size){
            val previousData = stack.peek()
            val nextData = list[i]

            if (previousData.high >= nextData.low){
                previousData.high = Math.max(nextData.high,previousData.high)
            } else{
                stack.push(nextData)
            }
        }

        val ans = Array<IntArray>(stack.size){ intArrayOf() }
        var i = 0
        while (stack.isEmpty().not()){
            val data = stack.pop()
            val array = intArrayOf(data.low,data.high)
            ans[i] = array
            println(data)
            i++
        }

        return ans
    }
}

data class Intervals(var high: Int, val low: Int)

fun main() {
    val a = MergeIntervals()
    println(a.merge(arrayOf(intArrayOf(1, 4), intArrayOf(4,5))))
}
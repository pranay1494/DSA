package gojek.slidingwindow

class BestTimetoBuyandSellStock {
    fun maxProfit(prices: IntArray): Int {
        var min = Int.MAX_VALUE
        var ans = 0
        prices.forEachIndexed { index, value ->
            if (prices[index] <= min){
                min = prices[index]
            } else {
                ans = Math.max(ans,prices[index]-min)
            }
        }
        return ans
    }
}

fun main() {
    val a = BestTimetoBuyandSellStock()
    println(a.maxProfit(intArrayOf(7,6,4,3,1)))
}
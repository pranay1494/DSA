package gojek.slidingwindow

import kotlin.math.min

class MinimumSizeSubarraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var sum = 0
        var ans = Integer.MAX_VALUE

        var start = 0

        nums.forEachIndexed{ index, value ->
            sum+= value

            while (sum >= target){
                ans = min(ans,index-start+1)
                sum -= nums[start]
                start++
            }
        }
        // with the current example as ans was not updated as threshold was not reached we need to specially check the ans value and return 0.
        return if (ans == Integer.MAX_VALUE) 0 else ans
    }
}

fun main() {
    val a = MinimumSizeSubarraySum()
    val aa = intArrayOf(1,1,1,1,1,1,1,1)

    print(a.minSubArrayLen(11, aa))
}
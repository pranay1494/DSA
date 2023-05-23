package gojek.slidingwindow

class FruitInbasket {
    fun totalFruit(fruits: IntArray): Int {
        var ans = -1
        var start = 0;
        val map = hashMapOf<Int,Int>()

        fruits.forEachIndexed { end, value ->
            map[value] = map.getOrDefault(value,0) + 1

            while (map.size > 2){
                val data = fruits[start]
                val prev = map.put(data, map[data]!! - 1)
                if (prev == 1){
                    map.remove(data)
                }
                start++
            }
            if (map.size == 2){
                ans = Math.max(ans,end-start + 1)
            }
        }
        return if (ans == -1) fruits.size else ans
    }
}

fun main() {
    val a = FruitInbasket()
    val arr = intArrayOf(1,2,3,2,2)

    print(a.totalFruit(arr))
}
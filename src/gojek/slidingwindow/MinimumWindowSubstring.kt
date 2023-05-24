package gojek.slidingwindow

class MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {
        if (s.isEmpty() || s.length<t.length) return ""

        val map = hashMapOf<Char,Int>()

        t.forEach { map[it] = map.getOrDefault(it,0) + 1 }
        var count = map.size
        var start = 0
        var i = 0
        var ans = Integer.MAX_VALUE

        s.forEachIndexed { end, value ->
            if (map.containsKey(value)){
                map[value] = map[value]!! - 1
                if (map[value] == 0){
                    count--
                }
            }

            while (count == 0){
                if (end-i+1 < ans){
                    ans = end-i+1
                    start = i
                }

                if (map.containsKey(s[i])){
                    map[s[i]] = map[s[i]]!! + 1
                    if (map[s[i]]!! > 0){
                        count++
                    }
                }
                i++
            }
        }

        if (ans == Int.MAX_VALUE) return ""

        return s.substring(start,start+ans)
    }
}

fun main() {
    val a = MinimumWindowSubstring()
    println(a.minWindow("a","b"))
}
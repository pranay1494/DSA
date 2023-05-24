package gojek.slidingwindow

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var ans = 0

        val map = hashMapOf<Char,Int>()

        s.forEachIndexed { end, value ->
            val data = map.put(value, end)
            if (data!=null && data>=start){
                start = data + 1
            }
            ans = Math.max(ans,end-start+1)
        }
        return ans
    }
}

fun main() {
    val a = LongestSubstringWithoutRepeatingCharacters()
    print(a.lengthOfLongestSubstring("abcabcbb"))
}
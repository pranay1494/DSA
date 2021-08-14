package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * check following TC's
 * abba
 * dvdf
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters repeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println("args = " + repeatingCharacters.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int ans = 0;
        Map<Character,Integer> indices = new HashMap<>();

        if (s.isEmpty()) return 0;

        for (int end = 0; end < s.length(); end++) {
            Integer index = indices.put(s.charAt(end), end);
            if (index != null && index >= start){
                start = index + 1;
            }
            ans = Math.max(ans,end - start + 1);
        }
        return ans;
    }
}

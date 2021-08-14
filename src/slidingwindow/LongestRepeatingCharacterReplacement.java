package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement characterReplacement = new LongestRepeatingCharacterReplacement();
        System.out.println("args = " + characterReplacement.characterReplacement("",1));
    }

    public int characterReplacement(String s, int k) {
        int start = 0;
        Map<Character,Integer> frequencies = new HashMap<>();
        int maxChar = 0;
        int ans = 0;
        for (int end = 0; end < s.length(); end++) {
            frequencies.put(s.charAt(end),frequencies.getOrDefault(s.charAt(end),0) + 1);
            maxChar = Math.max(maxChar,frequencies.get(s.charAt(end)));
            while(end - start + 1 - maxChar > k){
                frequencies.put(s.charAt(start),frequencies.get(s.charAt(start)) - 1);
                start++;
            }
            ans = Math.max(ans,end- start + 1);
        }
        return ans;
    }
}

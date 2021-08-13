package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1#
 */
public class LongestSubstringwithKDistinctCharacters {
    public static void main(String[] args) {
        LongestSubstringwithKDistinctCharacters characters = new LongestSubstringwithKDistinctCharacters();
        System.out.println("args = " + characters.longestkSubstr("aaaaaa",2));
    }

    private int longestkSubstr(String input, int k){
        Map<Character,Integer> frequency = new HashMap<>();
        int start = 0;
        int ans = -1;

        if (isDistinctAvailable(input) < k) return -1;  //  <------tricky corner case  - >characters.longestkSubstr("aaaaaa",2)

        for (int end = 0; end < input.length(); end++) {
            frequency.put(input.charAt(end), frequency.getOrDefault(input.charAt(end),0)+1);
            while(frequency.size() > k){
                // shrink
                if (frequency.get(input.charAt(start)) == 1){
                    frequency.remove(input.charAt(start));
                }else{
                    frequency.put(input.charAt(start), frequency.get(input.charAt(start)) - 1);
                }
                start++;
            }
            ans = Math.max(ans,end - start + 1);
        }
        return ans;
    }

    int isDistinctAvailable(String s){
        Map<Character,Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            frequency.put(s.charAt(i),1);
        }
        return frequency.size();
    }
}

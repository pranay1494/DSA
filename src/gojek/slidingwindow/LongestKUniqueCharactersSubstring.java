package gojek.slidingwindow;

import java.util.HashMap;

public class LongestKUniqueCharactersSubstring {

    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0;
        int ans = -1;
        for (int end = 0; end < s.length(); end++) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end),0) + 1);
            while (map.size() > k){
                Integer data = map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                if (data.equals(1)){
                    map.remove(s.charAt(start));
                }
                start++;
            }
            if (map.size() == k){
                ans = Math.max(ans,end-start+1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        LongestKUniqueCharactersSubstring a = new LongestKUniqueCharactersSubstring();
        System.out.println("args = " + a.longestkSubstr("aaaa",2));
    }
}

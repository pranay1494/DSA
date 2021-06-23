package anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagrams {

    public static void main(String[] args) {
        AllAnagrams anagrams = new AllAnagrams();
        System.out.println("args = " + anagrams.findAnagrams("abab","ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> answer = new ArrayList<>();

        if(s.length()<p.length()){
            return answer;
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (isAnagram(s.substring(i , i+p.length()), p)){
                answer.add(i);
            }
        }
        return answer;
    }

    private boolean isAnagram(String s, String t) {

        if (s.length()!=t.length()) return false;

        int[] count = new int[256];
        Arrays.fill(count,0);

        for (int i = 0; i < s.length() ; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a'] --;
        }

        for (int j : count) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

}

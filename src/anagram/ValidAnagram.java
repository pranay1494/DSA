package anagram;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println("args = " +  validAnagram.isAnagram("anagram","nagaram"));
    }

    public boolean isAnagram(String s, String t) {

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

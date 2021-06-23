package anagram;

import java.util.Arrays;

/**
 * find permutation  of string in other string
 */
public class PermutationInString {
    public static void main(String[] args) {
        PermutationInString permutation = new PermutationInString();
        System.out.println("args = " + permutation.checkInclusion("ab","eidboaoo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() >s2.length()) return false;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (isAnagram(s1,s2.substring(i,i+s1.length()))){
                return true;
            }
        }
        return false;
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

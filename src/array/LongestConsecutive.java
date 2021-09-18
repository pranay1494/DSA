package array;

import java.util.HashSet;

/**
 * add all the data to the set
 * check if it is the first element of the subsequence by checking num - 1 is not present in set
 * stating from there check every element if it is present in set
 * calculate max window length
 */

public class LongestConsecutive {

    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        System.out.println("args = " + longestConsecutive.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num - 1)){
                int currentWindow = 1;
                int k = num + 1;
                while (set.contains(k)){
                    k++;
                    currentWindow++;
                }
                ans = Math.max(ans,currentWindow);
            }
        }
        return ans;
    }
}

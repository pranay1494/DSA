package slidingwindow;


public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum sum = new MinimumSizeSubarraySum();
        System.out.println("args = " + sum.minSubArrayLen(7, new int[]{2, 1, 5, 2, 3, 2}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = -1;
        int windowSum = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];
            end = i;

            //shrink
            while (windowSum >= target) {
                ans = Math.min(end - start + 1, ans);
                windowSum -= nums[start];
                start++;
            }

        }
        if (ans == Integer.MAX_VALUE) {
            return 0;
        }
        return ans;
    }
}

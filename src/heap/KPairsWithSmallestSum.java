package heap;

import java.util.*;

/**
 * add all the elements of nums1 with 0th element of num2 initially and keep track of num2 index seen
 * after getting a smallest pair out of PQ add next pair to PQ with that same element from num1 but next elemeent of num2
 * since both the arrays are sorted there wont bee any discrepency of other pair being thee smallest if the earlier element itself was not thee smallest.
 */
public class KPairsWithSmallestSum {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{};
        int k = 2;
        KPairsWithSmallestSum smallestSum = new KPairsWithSmallestSum();
        System.out.println("args = " + smallestSum.kSmallestPairs(nums1,nums2,k));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums2.length == 0) return ans;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] + a[1])));
        for (int i = 0; i < nums1.length && i < k; i++) {
            queue.add(new int[]{nums1[i],nums2[0],0});
        }
        while(!queue.isEmpty() && k>0){
            int[] data = queue.poll();
            int index = data[2];
            k--;
            ans.add(Arrays.asList(data[0],data[1]));
            if (index + 1 >= nums2.length){
                continue;
            }
            queue.add(new int[]{data[0],nums2[index + 1],index+1});
        }

        return ans;
    }
}

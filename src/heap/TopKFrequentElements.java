package heap;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int nums[]  = new int[]{1,1,1,2,2,3};
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] ints = topKFrequentElements.topKFrequent(nums, 2);
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> values  = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[1]-a[1]);

        for (int i = 0; i < nums.length; i++) {
            if (!values.containsKey(nums[i])){
                values.put(nums[i],1);
            }else {
                Integer integer = values.get(nums[i]);
                integer = integer+1;
                values.put(nums[i],integer);
            }
        }

        for (Map.Entry entry:values.entrySet()){
            queue.add(new int[]{(int)entry.getKey(),(int)entry.getValue()});
        }
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}

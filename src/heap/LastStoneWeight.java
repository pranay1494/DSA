package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight  = new LastStoneWeight();
        int weight = lastStoneWeight.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
        System.out.println("args = " + weight);
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b-a);

        for (int i = 0; i < stones.length; i++) {
            queue.add(stones[i]);
        }

        int ans = 0;

        while(!queue.isEmpty()){
            Integer first = queue.poll();
            if (!queue.isEmpty()){
                Integer second = queue.poll();
                int weight = first - second;
                if (weight != 0 ) queue.add(weight);
            }else{
                ans = first;
                break;
            }
        }
        return ans;
    }
}

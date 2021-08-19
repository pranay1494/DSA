package merginginterval;

import java.util.*;

/**
 * https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
 */

public class MinimumPlatforms {
    public static void main(String[] args) {
        System.out.println("args = " + findPlatform(new int[]{900, 940, 950, 1100, 1500, 1800},new int[]{910, 1200, 1120, 1130, 1900, 2000},6));
    }

    static int findPlatform(int arr[], int dep[], int n)
    {
        int ans = 0;
        List<Train> list = new ArrayList<>();
        PriorityQueue<Train> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

        if (n == 0) return 0;

        for (int i = 0; i < n; i++) {
            list.add(new Train(arr[i],dep[i]));
        }

        list.sort(Comparator.comparingInt(o -> o.start));

        for (int i = 0; i < n; i++) {
            while(!queue.isEmpty() && queue.peek().end < list.get(i).start){
                queue.poll();
            }
            queue.add(list.get(i));
            ans = Math.max(ans,queue.size());
        }
        return ans;
    }
}

class Train{
    int start;
    int end;

    public Train(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

package gojek.merginginterval;

import java.util.*;

public class MinimumPlatforms {
    static int findPlatform(int arr[], int dep[], int n)
    {
        List<Platform> list = new ArrayList<>();

        PriorityQueue<Platform> queue = new PriorityQueue<>(Comparator.comparingInt(o->o.high));

        int ans = 0;

        if (n == 0) return 0;

        for (int i = 0; i < arr.length; i++) {
            list.add(
                    new Platform(arr[i], dep[i])
            );
        }

        list.sort(Comparator.comparingInt(o->o.low));

        for (int i = 0;i< list.size();i++) {
            while (!queue.isEmpty() && queue.peek().high < list.get(i).low) {
                queue.poll();
            }
            queue.add(list.get(i));
            ans = Math.max(ans, queue.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumPlatforms a = new MinimumPlatforms();
        int ans = a.findPlatform(new int[]{900, 1100, 1235}, new int[]{1000, 1200, 1240}, 1);
        System.out.println("args = " + ans);
    }

}

class Platform{
    int low;
    int high;

    public Platform(int low, int high){
        this.low = low;
        this.high = high;
    }
}

package merginginterval;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println("args = " + Arrays.deepToString(mergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

    public int[][] merge(int[][] intervals) {
        Stack<Interval> stack = new Stack<>();
        List<Interval> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        if (list.size() == 0) return new int[][]{};

        list.sort(Comparator.comparingInt(o -> o.low));

        stack.push(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            Interval interval = list.get(i);
            Interval previous = stack.peek();

            if (interval.low <= previous.high ){
                previous.high = Math.max(interval.high, previous.high);
            }else{
                stack.push(interval);
            }
        }

        int[][] ans = new int[stack.size()][2];
        int k = 0;
        while(!stack.isEmpty()){
            Interval pop = stack.pop();
            ans[k] = new int[]{pop.low, pop.high};
            k++;
        }
        return ans;
    }
}

class Interval {
    int low;
    int high;

    public Interval(int low, int high) {
        this.low = low;
        this.high = high;
    }
}

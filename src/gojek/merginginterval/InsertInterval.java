package gojek.merginginterval;

import java.util.*;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Stack<Interval> stack = new Stack<>();
        List<Interval> list = new ArrayList<>();

        if (intervals.length == 0) return new int[][]{newInterval};

        for (int[] interval : intervals) {
            list.add(new Interval(interval[0], interval[1]));
        }

        int index = 0;
        while(index<list.size() && list.get(index).low < newInterval[0]){
            stack.push(list.get(index));
            index++;
        }

        stack.push(new Interval(newInterval[0],newInterval[1]));

        while(index< list.size()){
            Interval previous = stack.peek();
            Interval data = list.get(index);
            if (previous.high >= data.low){
                previous.high = Math.max(previous.high, data.high);
            }else{
                stack.push(data);
            }
        }
        int[][] ans = new int[stack.size()][2];
        int k = 0;
        while(!stack.isEmpty()){
            Interval pop = stack.pop();
            ans[k] = new int[]{pop.low, pop.high};
            k++;
        }


        List<int[]> list1 = Arrays.asList(ans);
        Collections.reverse(list1);

        for (int i = 0; i < list1.size(); i++) {
            ans[i] = list1.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        merginginterval.InsertInterval insertInterval = new merginginterval.InsertInterval();
        System.out.println("args = " + Arrays.deepToString(insertInterval.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})));
    }
}

class Interval{
    int high;
    int low;
    public Interval(int low,int high){
        this.high = high;
        this.low = low;
    }
}

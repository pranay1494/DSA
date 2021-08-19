package merginginterval;

import java.util.*;

public class InsertInterval {
    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        System.out.println("args = " + Arrays.deepToString(insertInterval.insert(new int[][]{{3,5},{12,15}}, new int[]{6,6})));

    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        Stack<Interval> stack = new Stack<>();
        List<Interval> list = new ArrayList<>();
        boolean isInsterted = false;

        for (int i = 0; i < intervals.length; i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        if (list.size() == 0) return new int[][]{newInterval};

        if (newInterval.length > 0 && newInterval[0] < list.get(0).low ){
            stack.push(new Interval(newInterval[0],newInterval[1]));
            isInsterted = true;
        }else {
            stack.push(list.get(0));
        }

        int temp =0;
        while(temp < list.size()) {
            Interval interval = list.get(temp);
            Interval previous = stack.peek();

            if (newInterval[0] <= previous.high && !isInsterted){
                previous.high = Math.max(newInterval[1], previous.high);
                isInsterted = true;
            }

            if (interval.low <= previous.high ){
                previous.high = Math.max(interval.high, previous.high);
                temp++;
            }else{
                if (newInterval[0] < interval.low && !isInsterted){
                    stack.push(new Interval(newInterval[0],newInterval[1]));
                    isInsterted = true;
                }else{
                    temp++;
                    stack.push(interval);
                }
            }
        }

        if(!isInsterted){
            Interval peek = stack.peek();
            if (newInterval[0] <= peek.high){
                peek.high = Math.max(newInterval[1], peek.high);
            }else{
                stack.push(new Interval(newInterval[0],newInterval[1]));
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

}

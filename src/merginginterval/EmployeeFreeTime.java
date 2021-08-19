package merginginterval;

import java.util.*;

public class EmployeeFreeTime {
    public static void main(String[] args) {

        List<ArrayList<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(3,5),new Interval(7,9))));
        System.out.println("args = " + solve(input));
    }

    static List<Interval> solve(List<ArrayList<Interval>> times){
        Stack<Interval> stack = new Stack<>();
        List<Interval> list = new ArrayList<>();

        if (times.size()  == 0) return null;

        for (ArrayList<Interval> time : times) {
            list.addAll(time);
        }

        list.sort(Comparator.comparingInt(o -> o.start));

        stack.push(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            Interval previous = stack.peek();
            if (previous.end >= list.get(i).start){
                previous.end = Math.max(previous.end, list.get(i).end);
            }else{
                stack.push(list.get(i));
            }
        }

        list.clear();
        Interval prev = null;
        while(!stack.isEmpty()){
            if (prev != null){
                Interval current = stack.peek();
                list.add(new Interval(current.end, prev.start));
            }
            prev = stack.pop();
        }

        return list;
    }

    static class Interval{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}

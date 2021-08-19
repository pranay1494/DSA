package merginginterval;

import java.util.*;

public class CpuLoadTime {
    public static void main(String[] args) {
        CpuLoadTime loadTime = new CpuLoadTime();
        List<CPUTask> list = new ArrayList<>();
        list.add(new CPUTask(1,4,2));
        list.add(new CPUTask(2,4,1));
        list.add(new CPUTask(3,6,5));

        System.out.println("args = " + loadTime.solve(list));
    }

    int solve(List<CPUTask> taskList){

        Stack<CPUTask> stack = new Stack<>();

        if (taskList.size() == 0) return 0;

        taskList.sort(Comparator.comparingInt(o -> o.start));

        stack.push(taskList.get(0));

        int ans = stack.peek().load;

        for (int i = 1; i < taskList.size(); i++) {
            CPUTask previous = stack.peek();
            if (previous.end > taskList.get(i).start){
                previous.end = Math.max(previous.end, taskList.get(i).end);
                previous.load = previous.load + taskList.get(i).load;
            }else{
                stack.push(taskList.get(i));
            }
            ans = Math.max(ans,stack.peek().load);
        }
        return ans;
    }
}

class CPUTask{
    int start;
    int end;
    int load;

    public CPUTask(int start, int end, int load) {
        this.start = start;
        this.end = end;
        this.load = load;
    }
}

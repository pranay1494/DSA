package heap;

import java.util.PriorityQueue;

/**
 * https://www.geeksforgeeks.org/minimum-sum-two-numbers-formed-digits-array-2/
 */

public class MinimumSum {
    public static void main(String[] args) {
        int arr[] = {6, 8, 4, 5, 2, 3};
        int n = 6;
        MinimumSum sum = new MinimumSum();

        String solve = sum.solve(arr, n);
        System.out.println("args = " + solve);
    }

    String solve(int arr[], int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(arr[i]);
        }

        StringBuilder number1 = new StringBuilder();
        StringBuilder number2 = new StringBuilder();
        long ans = 0;
        while (!queue.isEmpty()){
            number1 = (number1).append(queue.poll());
            if (!queue.isEmpty()){
                number2 = (number2).append(queue.poll());
            }
        }
        long l = 0;
        if (!number1.toString().isEmpty()) l = Long.parseLong(number1.toString());
        long r = 0;
        if (!number2.toString().isEmpty()) r = Long.parseLong(number2.toString());
        ans = l + r;
        return ans+"";
    }
}

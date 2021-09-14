package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatestElementToTheRight {

    public static void main(String[] args) {

        System.out.println("args = " + Arrays.toString(nextLargerElement(new long[]{6, 8, 0, 1, 3}, 5)));
    }
    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here

        long[] ans = new long[n];
        Stack<Long> s = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && s.peek() < arr[i]){
                s.pop();
            }
            ans[i] = (s.isEmpty())?-1:s.peek();
            s.push(arr[i]);
        }
        return ans;
    }
}

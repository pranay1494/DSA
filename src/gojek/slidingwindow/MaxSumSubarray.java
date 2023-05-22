package gojek.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumSubarray {
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N){
        // code here

        int i = 0;
        int j=0;
        long sum = 0;
        long ans = 0;

        while(j<N){
            sum+=Arr.get(j);
            if (j-i+1 < K){
                j++;
            } else if (j-i+1 == K){
                // calculate the result
                ans = Math.max(ans,sum);
                sum-=Arr.get(i);
                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSumSubarray a = new MaxSumSubarray();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        System.out.println("args = " + a.maximumSumSubarray(2, list,4));
    }
}

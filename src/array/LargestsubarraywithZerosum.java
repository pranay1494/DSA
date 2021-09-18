package array;

import java.util.Arrays;
import java.util.HashMap;

public class LargestsubarraywithZerosum {
    public static void main(String[] args) {
        LargestsubarraywithZerosum zerosum = new LargestsubarraywithZerosum();
        System.out.println("args = " + zerosum.maxLen(new int[]{15,-2,2,-8,1,7,10,23},8));
    }
    int maxLen(int arr[], int n)
    {
        int sum =0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();


        for(int i = 0; i < n; i++){
            sum+= arr[i];
            if(sum == 0){ // if sum becomes zero it means that element subarray from start results in sum 0
                ans = i+1;
            }else{
                if(map.get(sum)!=null){    // if the sum was present already and we see the sum again it is safe to say that elements in between adds up to 0.
                                            //we dont put this in hashmap since we need to find max window and if the sum is already present that will no doubt result in bigger subarray
                    int index = map.get(sum);
                    ans = Math.max(ans,i - index);
                }else{   // add the element to hashmap
                    map.put(sum,i);
                }
            }
        }
        return ans;
    }

}

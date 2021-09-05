package backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();

        System.out.println("args = " + permutations.permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        int r = nums.length - 1;
        List<List<Integer>> answer = new ArrayList<>();
        permutation(nums, 0, r, answer);
        return answer;
    }

    private void permutation(int[] nums, int l, int r, List<List<Integer>> answer) {
        if (l == r){
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            answer.add(list);
        }

        for (int i = l; i <= r ; i++) {
            swap(nums,l,i);
            permutation(nums, l+1 , r, answer);
            swap(nums,l,i);
        }
    }

    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

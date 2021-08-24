package array;

import java.util.Arrays;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        SearchInRotatedSortedArray rotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println("args = " + rotatedSortedArray.search(new int[]{4,5,6,7,8,9},5));
    }

    public int search(int[] nums, int target) {
        int min = search(nums, nums.length, 0, nums.length - 1);
        int index = -1;
        if (target <= nums[nums.length - 1]){
            index = binarySearch(nums,min, nums.length - 1,target);
        } else{
            index = binarySearch(nums,0, min - 1,target);
        }
        return index;
    }

    private int search(int[] nums, int n, int start, int end){
        while (start <= end) {
            int mid = (start + end) / 2;

            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            if (nums[mid] <= nums[next] && nums[mid] <= nums[prev]) return mid;

            if (nums[mid] <= nums[end]){
                end = mid - 1;
            }
            else if (nums[start] <= nums[mid]) {
                start = mid + 1;
            }
        }
        return 0;
    }

    private int binarySearch(int[] nums, int start, int end, int k){
        if (start<=end){
            int mid = (start + end)/2;
            if (nums[mid] == k){
                return mid;
            }

            if (nums[mid] > k){
                return binarySearch(nums,start,mid-1, k);
            }else {
                return binarySearch(nums,mid + 1,end, k);
            }
        }
        return -1;

    }

}

package array;


public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray rotatedSortedArray = new FindMinimuminRotatedSortedArray();

        System.out.println("args = " + rotatedSortedArray.findMin(new int[]{2,3,4,5,1}));
    }

    public int findMin(int[] nums) {
        return search(nums, nums.length, 0, nums.length - 1);
    }

    private int search(int[] nums, int n, int start, int end){
        while (start <= end) {
            int mid = (start + end) / 2;

            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            if (nums[mid] <= nums[next] && nums[mid] <= nums[prev]) return nums[mid];

            if (nums[mid] <= nums[end]){
                end = mid - 1;
            }
            else if (nums[start] <= nums[mid]) {
                start = mid + 1;
            }
        }
        return nums[0];
        // first commit
        // second commit
        // third commit
        // 4th commit
        // 5th commit
    }
}

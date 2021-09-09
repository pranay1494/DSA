package array;

public class FloorInSortedArray {
    static int findFloor(long arr[], int n, long x)
    {
        int high = n - 1;
        int low = 0;
        int res = -1;

        while(low<=high){
            int mid = low + (high - low)/2;

            if(arr[mid] == x) return mid;

            if(arr[mid] < x){
                res = mid;
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return res;
    }
}

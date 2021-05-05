package heap;

public class KthMaxElemeent {
    public static void main(String[] args) {
        KthMaxElemeent element = new KthMaxElemeent();

        System.out.println("args = " + element.findKthLargest(new int[]{3,2,1,5,6,4},2));
    }

    public int findKthLargest(int[] nums, int k) {
        int[] arr = new int[nums.length+1];
        int size = nums.length;

        for(int i=0; i< nums.length ;i++){
            arr[i+1] = nums[i];
        }

        buildHeap(arr, size);

        return kthMax(arr, k, size);
    }


    private int kthMax(int[] arr, int k , int size) {
        for(int i = 0 ; i < k-1; i++){
            arr[1] = arr[size];
            size = size - 1;
            maxHeapify(arr,1,size);
        }
        return arr[1];
    }

    private void maxHeapify(int[] a , int index, int size){
        int left = 2 * index;
        int right = 2 * index + 1;
        int largest;
        if(left<=size && a[left] > a[index]){
            largest = left;
        }
        else{
            largest = index;
        }

        if(right<=size && a[right] > a[largest]){
            largest = right;
        }

        if (index != largest ){
            swap(a,largest,index);
            maxHeapify(a,largest,size);
        }
    }

    private void buildHeap(int[] nums, int k){
        for(int i = k/2 ;i >=1 ; i--){
            maxHeapify(nums,i,k);
        }
    }

    private void swap(int[] a , int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}

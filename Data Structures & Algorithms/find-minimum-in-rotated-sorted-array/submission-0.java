class Solution {
    public int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int ans  = -1;
        int mini = Integer.MAX_VALUE;
        while(low < high){
            int mid = low + (high - low)/2;
                if(arr[mid] > arr[high]){
                    low = mid+1;
                }
                else{
                    high = mid;
                  
                }
 
        }
        return arr[low];
    }
}

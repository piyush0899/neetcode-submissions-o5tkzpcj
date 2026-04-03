class Solution {
    public int maxArea(int[] arr) {
      
        int left = 0;
        int right = arr.length -1;
        int min = Integer.MAX_VALUE;
        int amount = 0;
        int max = Integer.MIN_VALUE;
        while(left < right){

            min = Math.min(arr[left],arr[right]);
            amount = min*(right - left);
            if(arr[left]<=arr[right]){
                left++;
            }
            else{
                right--;
            }
               max = Math.max(max,amount);
        }
     
    return max;
    }
}

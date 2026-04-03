class Solution {
    public int longestConsecutive(int[] nums) {
        
        int n = nums.length;
        if(n == 0){
            return 0;
        }
       Arrays.sort(nums);
    int count =0;
    int lastSmaller = Integer.MIN_VALUE;
    int longest = 0;
    for(int i = 0 ; i<n; i++){
        
            if (nums[i] == lastSmaller + 1) {   // consecutive
                count++;
                lastSmaller = nums[i];
            }
            else if (nums[i] != lastSmaller) {  // new sequence
                count = 1;
                lastSmaller = nums[i];
            }
        longest = Math.max(longest,count);
    }
return longest;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        HashSet <Integer> set = new HashSet<>();
        
        
        for(int i = 0 ; i< n ; i++){

                set.add(nums[i]);
        }
        int longest = 0;
        for(int i : set){
            int count = 1;
            if(set.contains(i-1)){
                continue;
            }
            else{
                while(set.contains(i+1)){
                    count++;
                    i = i+1;
                }
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }
}

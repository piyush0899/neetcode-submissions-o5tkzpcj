class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int [] Output = new int [2];
        for(int i = 0 ; i < nums.length ; i++){

                int diff = target - nums[i];
                if(mpp.containsKey(diff)){
                    Output[1] = i;
                    Output[0] = mpp.get(diff);
                    return Output;
                }
                mpp.put(nums[i],i);
        }

        return Output;
    }
}

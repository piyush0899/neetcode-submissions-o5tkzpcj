class Solution {
    public int subarraySum(int[] nums, int k) {
        
          int n = nums.length;

        int sum = 0;
        int count = 0;

        Map<Integer, Integer> mpp =
            new HashMap<>();

        for (int i = 0; i < n; i++) {

            sum += nums[i];

            // subarray from 0 to i
            if (sum == k) {
                count++;
            }

            int diff = sum - k;

            // previous prefix exists
            if (mpp.containsKey(diff)) {

                count += mpp.get(diff);
            }

            // store frequency
            mpp.put(sum,
                    mpp.getOrDefault(sum, 0) + 1);
        }

        return count;
    
    }
}
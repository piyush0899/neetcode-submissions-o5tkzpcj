

class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int n = nums.length;

        if (k > n) {
            return false;
        }

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // Total sum must be divisible by k
        if (total % k != 0) {
            return false;
        }

        int target = total / k;

        Arrays.sort(nums);

        // Sort in descending order
        reverse(nums);

        // Largest number cannot exceed target
        if (nums[0] > target) {
            return false;
        }

        int[] subsetSums = new int[k];

        return backtrack(nums, 0, subsetSums, target);
    }

    private boolean backtrack(
            int[] nums,
            int index,
            int[] subsetSums,
            int target) {

        // All numbers have been assigned
        if (index == nums.length) {

            for (int sum : subsetSums) {
                if (sum != target) {
                    return false;
                }
            }

            return true;
        }

        int num = nums[index];

        for (int i = 0; i < subsetSums.length; i++) {

            // Do not exceed target
            if (subsetSums[i] + num > target) {
                continue;
            }

            // Place number in this subset
            subsetSums[i] += num;

            if (backtrack(nums, index + 1, subsetSums, target)) {
                return true;
            }

            // Backtrack
            subsetSums[i] -= num;

            // Empty subsets are equivalent
            if (subsetSums[i] == 0) {
                break;
            }
        }

        return false;
    }

    private void reverse(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
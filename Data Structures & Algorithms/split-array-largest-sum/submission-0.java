class Solution {

    public int splitArray(int[] nums, int k) {

        int left = 0;
        int right = 0;

        // Find minimum and maximum possible answer
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        // Binary Search on answer
        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {

                // mid is possible
                // Try to find a smaller answer
                right = mid;

            } else {

                // mid is not possible
                // Need a bigger answer
                left = mid + 1;
            }
        }

        return left;
    }


    private boolean canSplit(int[] nums, int k, int maxSum) {

        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {

            if (currentSum + num > maxSum) {

                // Start a new subarray
                subarrays++;
                currentSum = num;

            } else {

                currentSum += num;
            }

            // Already need more than k subarrays
            if (subarrays > k) {
                return false;
            }
        }

        return true;
    }
}
class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        int currentMax = 0;
        int maxSum = Integer.MIN_VALUE;

        int currentMin = 0;
        int minSum = Integer.MAX_VALUE;

        for (int num : nums) {

            totalSum += num;

            // Kadane's Algorithm - Maximum Subarray
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane's Algorithm - Minimum Subarray
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }

        // If all elements are negative,
        // circular calculation would give 0 incorrectly
        if (maxSum < 0) {
            return maxSum;
        }

        int circularMax = totalSum - minSum;

        return Math.max(maxSum, circularMax);
    }
}
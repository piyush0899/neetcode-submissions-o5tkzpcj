class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        // Find minimum capacity and maximum capacity
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        // Binary Search on capacity
        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                // This capacity works
                // Try smaller capacity
                right = mid;
            } else {
                // This capacity does not work
                // Need bigger capacity
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canShip(int[] weights, int days, int capacity) {

        int currentWeight = 0;
        int daysUsed = 1;

        for (int weight : weights) {

            if (currentWeight + weight > capacity) {

                // Start a new day
                daysUsed++;
                currentWeight = weight;

            } else {

                currentWeight += weight;
            }

            // Already exceeded allowed days
            if (daysUsed > days) {
                return false;
            }
        }

        return true;
    }
}
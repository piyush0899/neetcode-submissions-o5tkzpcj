class Solution {

    public boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {
                return true;
            }

            // Duplicate case
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }

            // Left half is sorted
            if (nums[left] < nums[mid]) {

                // Target lies in sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }

            // Right half is sorted
            else {

                // Target lies in sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}
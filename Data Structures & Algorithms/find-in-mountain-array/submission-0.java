/**
 * // This is MountainArray's API.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        // Step 1: Find peak
        int peak = findPeak(mountainArr);

        // Step 2: Search target in increasing part
        int leftResult = binarySearchAscending(
                mountainArr,
                target,
                0,
                peak
        );

        // If found on left side, return it
        if (leftResult != -1) {
            return leftResult;
        }

        // Step 3: Search target in decreasing part
        return binarySearchDescending(
                mountainArr,
                target,
                peak + 1,
                mountainArr.length() - 1
        );
    }


    // Find index of mountain peak
    private int findPeak(MountainArray mountainArr) {

        int left = 0;
        int right = mountainArr.length() - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            int midValue = mountainArr.get(mid);
            int nextValue = mountainArr.get(mid + 1);

            if (midValue < nextValue) {

                // We are on increasing side
                left = mid + 1;

            } else {

                // We are on decreasing side
                // Peak can be mid or on the left
                right = mid;
            }
        }

        return left;
    }


    // Normal binary search for increasing array
    private int binarySearchAscending(
            MountainArray mountainArr,
            int target,
            int left,
            int right) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            }

            if (value < target) {

                // Target is on right
                left = mid + 1;

            } else {

                // Target is on left
                right = mid - 1;
            }
        }

        return -1;
    }


    // Binary search for decreasing array
    private int binarySearchDescending(
            MountainArray mountainArr,
            int target,
            int left,
            int right) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            }

            if (value > target) {

                // In decreasing array,
                // smaller values are on right
                left = mid + 1;

            } else {

                // Larger values are on left
                right = mid - 1;
            }
        }

        return -1;
    }
}
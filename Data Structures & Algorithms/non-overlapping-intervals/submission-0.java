class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        // Counter for how many intervals we need to remove
        int count = 0;

        // Track end time of last non-overlapping interval
        int prevEnd = intervals[0][1];

        // Loop through remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If current interval overlaps with previous
            if (intervals[i][0] < prevEnd) {
                // Increment count to remove this interval
                count++;
            } else {
                // Update previous end time
                prevEnd = intervals[i][1];
            }
        }

        // Return total number of intervals removed
        return count;
    }
}

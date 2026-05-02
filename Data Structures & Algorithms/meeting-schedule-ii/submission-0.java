/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

       if (intervals == null || intervals.size() == 0) return 0;

        // Step 1: sort by start time
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        // Step 2: min heap for end times
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add first meeting
        pq.add(intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {

            Interval curr = intervals.get(i);

            // if room free
            if (curr.start >= pq.peek()) {
                pq.poll();
            }

            // allocate room
            pq.add(curr.end);
        }

        return pq.size();
    }
}

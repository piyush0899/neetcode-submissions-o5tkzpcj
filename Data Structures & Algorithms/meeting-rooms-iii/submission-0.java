
import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {

        // Sort meetings by their original start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Min heap containing available room numbers
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        // Min heap: {meeting end time, room number}
        // Sort by end time, then by room number
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                return Long.compare(a[1], b[1]);
            }
        );

        // Count meetings held in each room
        int[] meetingCount = new int[n];

        for (int[] meeting : meetings) {

            long start = meeting[0];
            long end = meeting[1];

            long duration = end - start;

            // Free all rooms whose meetings have ended
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {

                long[] completedMeeting = busyRooms.poll();

                int room = (int) completedMeeting[1];

                availableRooms.offer(room);
            }

            // Case 1: At least one room is available
            if (!availableRooms.isEmpty()) {

                // Select the lowest numbered available room
                int room = availableRooms.poll();

                // Schedule meeting at its original time
                busyRooms.offer(new long[]{end, room});

                meetingCount[room]++;
            }

            // Case 2: All rooms are busy
            else {

                // Get the room that becomes free earliest
                long[] earliestMeeting = busyRooms.poll();

                long freeTime = earliestMeeting[0];
                int room = (int) earliestMeeting[1];

                // Delay the meeting but preserve its duration
                long newEndTime = freeTime + duration;

                busyRooms.offer(new long[]{newEndTime, room});

                meetingCount[room]++;
            }
        }

        // Find the room with the maximum number of meetings
        int answer = 0;

        for (int i = 1; i < n; i++) {

            if (meetingCount[i] > meetingCount[answer]) {
                answer = i;
            }
        }

        return answer;
    }
}

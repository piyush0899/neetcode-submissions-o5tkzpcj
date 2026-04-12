class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int q = queries.length;
        int[][] qArr = new int[q][2];
        
        for (int i = 0; i < q; i++) {
            qArr[i][0] = queries[i];
            qArr[i][1] = i;
        }

        Arrays.sort(qArr, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        ); // [length, end]

        int[] res = new int[q];
        Arrays.fill(res, -1);

        int i = 0;

        for (int[] query : qArr) {
            int val = query[0];
            int idx = query[1];

            // Add intervals whose start <= query
            while (i < intervals.length && intervals[i][0] <= val) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                int len = right - left + 1;

                pq.offer(new int[]{len, right});
                i++;
            }

            // Remove invalid intervals (end < query)
            while (!pq.isEmpty() && pq.peek()[1] < val) {
                pq.poll();
            }

            // Top of heap = smallest valid interval
            if (!pq.isEmpty()) {
                res[idx] = pq.peek()[0];
            }
        }

        return res;
    }
}

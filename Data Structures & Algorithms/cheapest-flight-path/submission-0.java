class Solution {
    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] flight : flights) {

            graph.putIfAbsent(flight[0], new ArrayList<>());

            graph.get(flight[0]).add(
                    new int[]{flight[1], flight[2]}
            );
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(
                        (a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, src, 0});

        int[] stops = new int[n];

        Arrays.fill(stops, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int cost = curr[0];
            int node = curr[1];
            int step = curr[2];

            if (node == dst)
                return cost;

            if (step > k)
                continue;

            if (step > stops[node])
                continue;

            stops[node] = step;

            if (!graph.containsKey(node))
                continue;

            for (int[] next : graph.get(node)) {

                pq.offer(new int[]{
                        cost + next[1],
                        next[0],
                        step + 1
                });
            }
        }

        return -1;
    }
}

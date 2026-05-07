class Solution {
   
    public int networkDelayTime(int[][] times, int n, int k) {

        // Step 1: Build graph
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] t : times) {

            int u = t[0];
            int v = t[1];
            int w = t[2];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[]{v, w});
        }

        // Step 2: Min Heap [time, node]
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[]{0, k});

        // shortest distance map
        Set<Integer> visited = new HashSet<>();

        int time = 0;

        // Step 3: Dijkstra
        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int currTime = curr[0];
            int node = curr[1];

            if (visited.contains(node)) continue;

            visited.add(node);

            time = currTime;

            if (graph.containsKey(node)) {

                for (int[] nei : graph.get(node)) {

                    int nextNode = nei[0];
                    int weight = nei[1];

                    if (!visited.contains(nextNode)) {
                        pq.add(new int[]{
                            currTime + weight,
                            nextNode
                        });
                    }
                }
            }
        }

        return visited.size() == n ? time : -1;
}
}

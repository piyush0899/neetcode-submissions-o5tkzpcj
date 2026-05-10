class Solution {
     Map<String, PriorityQueue<String>> graph = new HashMap<>();

    LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        // Step 1: Build graph
        for (List<String> ticket : tickets) {

            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.putIfAbsent(from, new PriorityQueue<>());

            graph.get(from).add(to);
        }

        // Step 2: DFS
        dfs("JFK");

        return result;
    }

    private void dfs(String airport) {

        PriorityQueue<String> pq = graph.get(airport);

        while (pq != null && !pq.isEmpty()) {

            String next = pq.poll();

            dfs(next);
        }

        // add at front
        result.addFirst(airport);
    }
}

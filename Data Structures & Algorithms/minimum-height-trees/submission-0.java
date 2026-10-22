

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> result = new ArrayList<>();

        // Special case: only one node
        if (n == 1) {
            result.add(0);
            return result;
        }

        // Build the adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] degree = new int[n];

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);

            degree[a]++;
            degree[b]++;
        }

        // Add all current leaf nodes to the queue
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        int remainingNodes = n;

        // Remove leaves layer by layer
        while (remainingNodes > 2) {

            int size = queue.size();
            remainingNodes -= size;

            for (int i = 0; i < size; i++) {
                int leaf = queue.poll();

                // Remove this leaf from its neighbors
                for (int neighbor : graph.get(leaf)) {
                    degree[neighbor]--;

                    // Neighbor becomes a leaf
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // The remaining one or two nodes are the MHT roots
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}


class Solution {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(
            int n, int[][] edges) {

        int m = edges.length;

        // Store original edge index along with each edge
        int[][] sortedEdges = new int[m][4];

        for (int i = 0; i < m; i++) {
            sortedEdges[i][0] = edges[i][0];
            sortedEdges[i][1] = edges[i][1];
            sortedEdges[i][2] = edges[i][2];
            sortedEdges[i][3] = i;
        }

        // Sort edges by weight
        Arrays.sort(sortedEdges, (a, b) ->
            Integer.compare(a[2], b[2])
        );

        // Weight of the original MST
        int mstWeight = kruskal(n, sortedEdges, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            int originalIndex = sortedEdges[i][3];

            // Test 1: Exclude this edge
            int weightWithoutEdge = kruskal(
                n, sortedEdges, originalIndex, -1
            );

            if (weightWithoutEdge > mstWeight ||
                weightWithoutEdge == Integer.MAX_VALUE) {

                critical.add(originalIndex);

            } else {

                // Test 2: Force this edge into the MST
                int weightWithEdge = kruskal(
                    n, sortedEdges, -1, originalIndex
                );

                if (weightWithEdge == mstWeight) {
                    pseudoCritical.add(originalIndex);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(critical);
        result.add(pseudoCritical);

        return result;
    }

    private int kruskal(
            int n,
            int[][] edges,
            int excludedEdge,
            int forcedEdge) {

        DSU dsu = new DSU(n);
        int totalWeight = 0;
        int edgesUsed = 0;

        // Force the selected edge first, if applicable
        if (forcedEdge != -1) {
            for (int[] edge : edges) {
                if (edge[3] == forcedEdge) {

                    if (dsu.union(edge[0], edge[1])) {
                        totalWeight += edge[2];
                        edgesUsed++;
                    }

                    break;
                }
            }
        }

        // Process remaining edges in increasing weight order
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            int index = edge[3];

            if (index == excludedEdge || index == forcedEdge) {
                continue;
            }

            if (dsu.union(u, v)) {
                totalWeight += weight;
                edgesUsed++;
            }

            if (edgesUsed == n - 1) {
                break;
            }
        }

        // A spanning tree must contain exactly n - 1 edges
        if (edgesUsed != n - 1) {
            return Integer.MAX_VALUE;
        }

        return totalWeight;
    }

    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return false;
            }

            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }

            return true;
        }
    }
}

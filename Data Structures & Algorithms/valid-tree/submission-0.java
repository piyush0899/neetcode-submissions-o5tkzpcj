class Solution {
   public boolean validTree(int n, int[][] edges) {

        // Tree must have n-1 edges
        if (edges.length != n - 1) {
            return false;
        }

        List<Integer>[] graph =
                new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {

            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited =
                new boolean[n];

        dfs(0, -1, graph, visited);

        // Check connected
        for (boolean v : visited) {

            if (!v) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int node,
                     int parent,
                     List<Integer>[] graph,
                     boolean[] visited) {

        visited[node] = true;

        for (int neighbor : graph[node]) {

            if (neighbor == parent) {
                continue;
            }

            if (!visited[neighbor]) {

                dfs(neighbor,
                    node,
                    graph,
                    visited);
            }
        }
    }
}

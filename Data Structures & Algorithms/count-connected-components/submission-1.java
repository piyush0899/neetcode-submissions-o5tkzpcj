class Solution {
    public int countComponents(int n, int[][] edges) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {

            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        int count = 0;

        Queue<Integer> queue =
                new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                count++;

                queue.offer(i);
                visited[i] = true;

                while (!queue.isEmpty()) {

                    int curr = queue.poll();

                    for (int nei : graph[curr]) {

                        if (!visited[nei]) {

                            visited[nei] = true;
                            queue.offer(nei);
                        }
                    }
                }
            }
        }

        return count;
    }
}

class Solution {
    public boolean canFinish(int numCourses,
                             int[][] prerequisites) {

        // graph
        List<List<Integer>> graph =
            new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // build graph
        for (int[] p : prerequisites) {

            int course = p[0];
            int prereq = p[1];

            graph.get(prereq).add(course);
        }

        // 0 = unvisited
        // 1 = visiting
        // 2 = visited
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {

            if (dfs(i, graph, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course,
                        List<List<Integer>> graph,
                        int[] visited) {

        // cycle found
        if (visited[course] == 1) {
            return true;
        }

        // already processed
        if (visited[course] == 2) {
            return false;
        }

        visited[course] = 1;

        for (int nei : graph.get(course)) {

            if (dfs(nei, graph, visited)) {
                return true;
            }
        }

        visited[course] = 2;

        return false;
    }
}

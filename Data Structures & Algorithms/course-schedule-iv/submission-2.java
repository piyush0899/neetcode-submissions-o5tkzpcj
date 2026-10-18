

class Solution {
    public List<Boolean> checkIfPrerequisite(
            int numCourses,
            int[][] prerequisites,
            int[][] queries) {

        // reachable[i][j] means course i is a prerequisite of course j
        boolean[][] reachable = new boolean[numCourses][numCourses];

        // Mark direct prerequisites
        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];

            reachable[a][b] = true;
        }

        // Find indirect prerequisites using Floyd-Warshall
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {

                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }

        // Answer each query
        List<Boolean> answer = new ArrayList<>();

        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];

            answer.add(reachable[u][v]);
        }

        return answer;
    }
}
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // graph
        List<List<Integer>> graph =
            new ArrayList<>();

        for (int i = 0;
             i < numCourses;
             i++) {

            graph.add(new ArrayList<>());
        }

        // indegree array
        int[] indegree =
            new int[numCourses];

        // build graph
        for (int[] pre : prerequisites) {

            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course);

            indegree[course]++;
        }

        Queue<Integer> q =
            new LinkedList<>();

        // add indegree 0 nodes
        for (int i = 0;
             i < numCourses;
             i++) {

            if (indegree[i] == 0) {

                q.offer(i);
            }
        }

        int[] ans =
            new int[numCourses];

        int index = 0;

        // BFS
        while (!q.isEmpty()) {

            int node = q.poll();

            ans[index++] = node;

            for (int neighbor :
                 graph.get(node)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {

                    q.offer(neighbor);
                }
            }
        }

        // cycle exists
        if (index != numCourses) {

            return new int[]{};
        }

        return ans;
    } 
    }


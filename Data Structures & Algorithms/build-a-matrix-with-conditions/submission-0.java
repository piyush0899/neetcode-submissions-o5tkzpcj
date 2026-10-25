
class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        // Find a valid order for rows
        int[] rowOrder = topologicalSort(k, rowConditions);

        // If row conditions contain a cycle, no answer exists
        if (rowOrder.length == 0) {
            return new int[0][0];
        }

        // Find a valid order for columns
        int[] colOrder = topologicalSort(k, colConditions);

        // If column conditions contain a cycle, no answer exists
        if (colOrder.length == 0) {
            return new int[0][0];
        }

        // Store the row position of each number
        int[] rowPosition = new int[k + 1];

        for (int i = 0; i < k; i++) {
            rowPosition[rowOrder[i]] = i;
        }

        // Store the column position of each number
        int[] colPosition = new int[k + 1];

        for (int i = 0; i < k; i++) {
            colPosition[colOrder[i]] = i;
        }

        // Build the k x k matrix
        int[][] matrix = new int[k][k];

        for (int num = 1; num <= k; num++) {
            int row = rowPosition[num];
            int col = colPosition[num];

            matrix[row][col] = num;
        }

        return matrix;
    }

    private int[] topologicalSort(int k, int[][] conditions) {

        // Build the graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= k; i++) {
            graph.add(new ArrayList<>());
        }

        // Calculate incoming edges for every node
        int[] indegree = new int[k + 1];

        for (int[] condition : conditions) {
            int from = condition[0];
            int to = condition[1];

            graph.get(from).add(to);
            indegree[to]++;
        }

        // Add nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int num = 1; num <= k; num++) {
            if (indegree[num] == 0) {
                queue.offer(num);
            }
        }

        int[] order = new int[k];
        int index = 0;

        // Kahn's algorithm
        while (!queue.isEmpty()) {

            int current = queue.poll();
            order[index] = current;
            index++;

            for (int neighbor : graph.get(current)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If some nodes remain, the graph contains a cycle
        if (index != k) {
            return new int[0];
        }

        return order;
    }
}
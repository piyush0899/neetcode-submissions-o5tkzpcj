
class Solution {
    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        // Graph: variable -> (neighbor, division value)
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            // a / b = value
            graph.get(a).put(b, value);

            // b / a = 1 / value
            graph.get(b).put(a, 1.0 / value);
        }

        double[] answer = new double[queries.size()];

        // Process each query
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            // Unknown variables cannot be evaluated
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                answer[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                answer[i] = dfs(start, end, graph, visited);
            }
        }

        return answer;
    }

    private double dfs(
            String current,
            String target,
            Map<String, Map<String, Double>> graph,
            Set<String> visited) {

        // A variable divided by itself is 1
        if (current.equals(target)) {
            return 1.0;
        }

        visited.add(current);

        // Explore neighboring variables
        for (Map.Entry<String, Double> entry
                : graph.get(current).entrySet()) {

            String neighbor = entry.getKey();
            double weight = entry.getValue();

            if (visited.contains(neighbor)) {
                continue;
            }

            double result = dfs(neighbor, target, graph, visited);

            if (result != -1.0) {
                return weight * result;
            }
        }

        // No path exists between the variables
        return -1.0;
    }
}

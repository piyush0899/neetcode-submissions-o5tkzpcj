import java.util.*;

class Solution {

    public int findMaximizedCapital(
            int k,
            int w,
            int[] profits,
            int[] capital) {

        int n = profits.length;

        // Store {requiredCapital, profit}
        int[][] projects = new int[n][2];

        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        // Sort projects by required capital
        Arrays.sort(projects, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        // Max Heap based on profit
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );

        int projectIndex = 0;

        for (int i = 0; i < k; i++) {

            // Add all projects that we can currently afford
            while (projectIndex < n
                    && projects[projectIndex][0] <= w) {

                maxHeap.offer(projects[projectIndex][1]);

                projectIndex++;
            }

            // No project is affordable
            if (maxHeap.isEmpty()) {
                break;
            }

            // Select project with maximum profit
            int profit = maxHeap.poll();

            w += profit;
        }

        return w;
    }
}
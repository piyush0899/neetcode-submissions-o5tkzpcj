
import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        // Minimum effort required to reach each cell
        int[][] effort = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        // Min heap: {current effort, row, column}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        effort[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        // Up, down, left, right
        int[] rowDirection = {-1, 1, 0, 0};
        int[] colDirection = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int currentEffort = current[0];
            int row = current[1];
            int col = current[2];

            // Ignore outdated heap entries
            if (currentEffort > effort[row][col]) {
                continue;
            }

            // Destination reached
            if (row == rows - 1 && col == cols - 1) {
                return currentEffort;
            }

            // Explore all four directions
            for (int i = 0; i < 4; i++) {

                int newRow = row + rowDirection[i];
                int newCol = col + colDirection[i];

                if (newRow < 0 || newRow >= rows ||
                    newCol < 0 || newCol >= cols) {
                    continue;
                }

                int heightDifference = Math.abs(
                    heights[row][col] - heights[newRow][newCol]
                );

                // Path effort is the maximum difference along the path
                int newEffort = Math.max(
                    currentEffort, heightDifference
                );

                if (newEffort < effort[newRow][newCol]) {
                    effort[newRow][newCol] = newEffort;

                    pq.offer(new int[]{
                        newEffort, newRow, newCol
                    });
                }
            }
        }

        return 0;
    }
}

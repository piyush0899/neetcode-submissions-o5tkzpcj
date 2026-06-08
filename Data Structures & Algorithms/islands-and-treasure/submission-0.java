class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // add all treasures
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == 0) {

                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 ||
                    nc < 0 ||
                    nr >= rows ||
                    nc >= cols ||
                    grid[nr][nc] != Integer.MAX_VALUE) {

                    continue;
                }

                grid[nr][nc] = grid[r][c] + 1;

                queue.offer(new int[]{nr, nc});
            }
        }
    }
}

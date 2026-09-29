class Solution {

    public Node construct(int[][] grid) {
        return solve(grid, 0, 0, grid.length);
    }

    private Node solve(int[][] grid, int row, int col, int size) {

        // Check whether current region has same values
        boolean same = true;
        int value = grid[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {

                if (grid[i][j] != value) {
                    same = false;
                    break;
                }
            }

            if (!same) {
                break;
            }
        }

        // If all values are same, create leaf node
        if (same) {
            return new Node(value == 1, true);
        }

        // Divide into 4 equal parts
        int half = size / 2;

        Node topLeft = solve(grid, row, col, half);

        Node topRight = solve(grid, row, col + half, half);

        Node bottomLeft = solve(grid, row + half, col, half);

        Node bottomRight = solve(grid, row + half, col + half, half);

        // Current node is not a leaf
        Node root = new Node(true, false);

        root.topLeft = topLeft;
        root.topRight = topRight;
        root.bottomLeft = bottomLeft;
        root.bottomRight = bottomRight;

        return root;
    }
}
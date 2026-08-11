class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;   // non-null if a word ends here
        int refs;      // number of words passing through this node
    }

    private char[][] board;
    private int rows, cols;
    private List<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            node.refs++;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (node.children[i] == null) {
                    node.children[i] = new TrieNode();
                }
                node = node.children[i];
                node.refs++;
            }
            node.word = word;
        }

        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        this.result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(r, c, root);
            }
        }
        return result;
    }

    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void dfs(int r, int c, TrieNode parent) {
        char ch = board[r][c];
        if (ch == '#') return;

        TrieNode node = parent.children[ch - 'a'];
        if (node == null) return;

        if (node.word != null) {
            result.add(node.word);
            node.word = null;   // avoid duplicate reports
            node.refs--;
        }

        board[r][c] = '#';
        for (int[] d : DIRS) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                dfs(nr, nc, node);
            }
        }
        board[r][c] = ch;

        if (node.refs == 0) {
            parent.children[ch - 'a'] = null;   // prune exhausted branch
        }
    }
}
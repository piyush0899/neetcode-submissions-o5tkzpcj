class WordDictionary {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchFrom(word, 0, root);
    }

    private boolean searchFrom(
            String word, int position, TrieNode node) {

        if (position == word.length()) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(position);

        if (ch == '.') {
            // Dot can match any character
            for (TrieNode child : node.children) {
                if (child != null
                        && searchFrom(word, position + 1, child)) {
                    return true;
                }
            }

            return false;
        }

        TrieNode next = node.children[ch - 'a'];

        return next != null
                && searchFrom(word, position + 1, next);
    }
}
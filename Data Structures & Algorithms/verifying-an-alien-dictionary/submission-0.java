
class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        // Store the rank of each character in the alien alphabet
        int[] rank = new int[26];

        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            rank[ch - 'a'] = i;
        }

        // Compare every pair of adjacent words
        for (int i = 0; i < words.length - 1; i++) {

            String word1 = words[i];
            String word2 = words[i + 1];

            int j = 0;
            int minLength = Math.min(word1.length(), word2.length());

            // Find the first position where characters differ
            while (j < minLength &&
                   word1.charAt(j) == word2.charAt(j)) {
                j++;
            }

            // One word is a prefix of the other
            if (j == minLength) {
                if (word1.length() > word2.length()) {
                    return false;
                }
            } else {
                // Compare characters using alien alphabet ranks
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);

                if (rank[ch1 - 'a'] > rank[ch2 - 'a']) {
                    return false;
                }
            }
        }

        return true;
    }
}
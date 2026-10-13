
class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> dictionary = new HashSet<>(wordDict);

        Map<Integer, List<String>> memo = new HashMap<>();

        return backtrack(s, 0, dictionary, memo);
    }

    private List<String> backtrack(
            String s,
            int start,
            Set<String> dictionary,
            Map<Integer, List<String>> memo) {

        List<String> result = new ArrayList<>();

        // Entire string has been processed
        if (start == s.length()) {
            result.add("");
            return result;
        }

        // Return previously calculated results
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        // Try every possible ending position
        for (int end = start + 1; end <= s.length(); end++) {

            String word = s.substring(start, end);

            // Continue only if word exists in dictionary
            if (dictionary.contains(word)) {

                List<String> remainingSentences =
                        backtrack(s, end, dictionary, memo);

                for (String sentence : remainingSentences) {

                    if (sentence.isEmpty()) {
                        result.add(word);
                    } else {
                        result.add(word + " " + sentence);
                    }
                }
            }
        }

        memo.put(start, result);

        return result;
    }
}
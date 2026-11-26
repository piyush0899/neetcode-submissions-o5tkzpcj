

class Solution {
    public List<String> stringMatching(String[] words) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {

            for (int j = 0; j < words.length; j++) {

                // A word cannot be a substring of itself
                if (i == j) {
                    continue;
                }

                // Check whether words[i] exists inside words[j]
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }
}
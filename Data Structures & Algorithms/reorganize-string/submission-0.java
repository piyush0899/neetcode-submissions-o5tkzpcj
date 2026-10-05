

class Solution {

    public String reorganizeString(String s) {

        // Step 1: Count frequency
        int[] frequency = new int[26];

        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        // Step 2: Max Heap
        // Store {character, frequency}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[1], a[1])
        );

        for (int i = 0; i < 26; i++) {

            if (frequency[i] > 0) {
                pq.offer(new int[]{i, frequency[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        // Previous character which we cannot use immediately again
        int[] previous = null;

        while (!pq.isEmpty()) {

            // Pick most frequent character
            int[] current = pq.poll();

            // Add current character to result
            result.append((char) (current[0] + 'a'));

            // Use one occurrence
            current[1]--;

            // Put previous character back into heap
            if (previous != null && previous[1] > 0) {
                pq.offer(previous);
            }

            // Current becomes previous
            previous = current;
        }

        // If we could not use all characters,
        // rearrangement is impossible
        if (result.length() != s.length()) {
            return "";
        }

        return result.toString();
    }
}
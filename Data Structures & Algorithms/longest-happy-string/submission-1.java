

class Solution {

    public String longestHappyString(int a, int b, int c) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x, y) -> y[1] - x[1]
        );

        if (a > 0) {
            pq.offer(new int[]{'a', a});
        }

        if (b > 0) {
            pq.offer(new int[]{'b', b});
        }

        if (c > 0) {
            pq.offer(new int[]{'c', c});
        }

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            char ch = (char) current[0];

            int n = result.length();

            // Check if adding current character creates
            // aaa, bbb or ccc
            if (n >= 2
                    && result.charAt(n - 1) == ch
                    && result.charAt(n - 2) == ch) {

                // No other character is available
                if (pq.isEmpty()) {
                    break;
                }

                // Take second most frequent character
                int[] second = pq.poll();

                char secondChar = (char) second[0];

                result.append(secondChar);

                second[1]--;

                if (second[1] > 0) {
                    pq.offer(second);
                }

                // Put current character back
                pq.offer(current);

            } else {

                // Current character is safe
                result.append(ch);

                current[1]--;

                if (current[1] > 0) {
                    pq.offer(current);
                }
            }
        }

        return result.toString();
    }
}
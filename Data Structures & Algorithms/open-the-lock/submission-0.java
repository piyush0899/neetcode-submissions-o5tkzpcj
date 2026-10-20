

class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        // If the starting position is blocked, we cannot move
        if (dead.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");

        int turns = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process all states reachable in the current number of turns
            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                if (current.equals(target)) {
                    return turns;
                }

                // Try rotating each of the four wheels
                for (int wheel = 0; wheel < 4; wheel++) {

                    char[] chars = current.toCharArray();

                    // Rotate one step forward (9 -> 0)
                    chars[wheel] = (char) ('0' + (chars[wheel] - '0' + 1) % 10);
                    String next = new String(chars);

                    if (!dead.contains(next) && !visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }

                    // Rotate one step backward (0 -> 9)
                    chars[wheel] = (char) ('0' + (chars[wheel] - '0' + 8) % 10);
                    next = new String(chars);

                    if (!dead.contains(next) && !visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }

            turns++;
        }

        return -1;
    }
}
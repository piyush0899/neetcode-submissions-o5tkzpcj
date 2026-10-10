import java.util.*;

class Solution {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(1, n, k, current, result);

        return result;
    }

    private void backtrack(
            int start,
            int n,
            int k,
            List<Integer> current,
            List<List<Integer>> result) {

        // Combination contains k numbers
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try choosing each available number
        for (int i = start; i <= n; i++) {

            current.add(i);

            backtrack(i + 1, n, k, current, result);

            // Backtrack: remove the last chosen number
            current.remove(current.size() - 1);
        }
    }
}
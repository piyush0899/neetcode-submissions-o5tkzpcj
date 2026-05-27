class Solution {
 public List<List<Integer>>
    permute(int[] nums) {

        List<List<Integer>> ans =
            new ArrayList<>();

        boolean[] visited =
            new boolean[nums.length];

        backtrack(nums,
                  visited,
                  new ArrayList<>(),
                  ans);

        return ans;
    }

    private void backtrack(int[] nums,
                           boolean[] visited,
                           List<Integer> curr,
                           List<List<Integer>> ans) {

        // permutation completed
        if (curr.size() == nums.length) {

            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0;
             i < nums.length;
             i++) {

            // skip already used
            if (visited[i]) {
                continue;
            }

            // choose
            visited[i] = true;
            curr.add(nums[i]);

            // explore
            backtrack(nums,
                      visited,
                      curr,
                      ans);

            // undo (backtrack)
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}

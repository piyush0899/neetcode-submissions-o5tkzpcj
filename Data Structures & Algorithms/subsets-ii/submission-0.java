class Solution {
 public List<List<Integer>>
    subsetsWithDup(int[] nums) {

        List<List<Integer>> ans =
            new ArrayList<>();

        Arrays.sort(nums);

        backtrack(nums,
                  0,
                  new ArrayList<>(),
                  ans);

        return ans;
    }

    private void backtrack(int[] nums,
                           int start,
                           List<Integer> curr,
                           List<List<Integer>> ans) {

        // every state is a subset
        ans.add(new ArrayList<>(curr));

        for (int i = start;
             i < nums.length;
             i++) {

            // skip duplicates
            if (i > start &&
                nums[i] == nums[i - 1]) {

                continue;
            }

            // choose
            curr.add(nums[i]);

            // explore
            backtrack(nums,
                      i + 1,
                      curr,
                      ans);

            // backtrack
            curr.remove(curr.size() - 1);
        }
    }
}

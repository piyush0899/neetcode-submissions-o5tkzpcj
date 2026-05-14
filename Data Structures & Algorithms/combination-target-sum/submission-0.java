class Solution {
   public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, target, 0,
                  new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums,
                           int target,
                           int index,
                           List<Integer> curr,
                           List<List<Integer>> result) {

        // found combination
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        // invalid case
        if (target < 0 || index == nums.length) {
            return;
        }

        // include current number
        curr.add(nums[index]);

        backtrack(nums,
                  target - nums[index],
                  index, // same index
                  curr,
                  result);

        // backtrack
        curr.remove(curr.size() - 1);

        // skip current number
        backtrack(nums,
                  target,
                  index + 1,
                  curr,
                  result);
    }
}

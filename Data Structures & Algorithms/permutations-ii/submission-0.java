class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, current, result);

        return result;
    }

    private void backtrack(
            int[] nums,
            boolean[] used,
            List<Integer> current,
            List<List<Integer>> result) {

        // All elements are selected
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Element already used in current permutation
            if (used[i]) {
                continue;
            }

            // Skip duplicate elements at the same level
            if (i > 0
                    && nums[i] == nums[i - 1]
                    && !used[i - 1]) {
                continue;
            }

            // Choose the element
            current.add(nums[i]);
            used[i] = true;

            // Explore next position
            backtrack(nums, used, current, result);

            // Backtrack
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
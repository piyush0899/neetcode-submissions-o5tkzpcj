class Solution {

    public int subsetXORSum(int[] nums) {
        return calculateXOR(nums, 0, 0);
    }

    private int calculateXOR(int[] nums, int index, int currentXOR) {

        // All elements have been considered
        if (index == nums.length) {
            return currentXOR;
        }

        // Choice 1: Include current element
        int include = calculateXOR(
            nums,
            index + 1,
            currentXOR ^ nums[index]
        );

        // Choice 2: Exclude current element
        int exclude = calculateXOR(
            nums,
            index + 1,
            currentXOR
        );

        return include + exclude;
    }
}

class Solution {
    public int rangeBitwiseAnd(int left, int right) {

        int shift = 0;

        // Find the common binary prefix
        while (left != right) {
            left = left >> 1;
            right = right >> 1;

            shift++;
        }

        // Restore the common prefix to its original position
        return left << shift;
    }
}

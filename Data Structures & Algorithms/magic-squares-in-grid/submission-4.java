
class Solution {
    public void reverseString(char[] grid) {
        int left = 0;
        int right = grid.length - 1;

        while (left < right) {
            // Swap characters
            char temp = grid[left];
            grid[left] = grid[right];
            grid[right] = temp;

            // Move pointers
            left++;
            right--;
        }
    }
}
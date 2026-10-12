

class Solution {

    public boolean makesquare(int[] matchsticks) {

        int n = matchsticks.length;

        if (n < 4) {
            return false;
        }

        int total = 0;

        for (int stick : matchsticks) {
            total += stick;
        }

        // Total length must be divisible by 4
        if (total % 4 != 0) {
            return false;
        }

        int side = total / 4;

        // Largest matchstick first
        Arrays.sort(matchsticks);

        // Reverse array to get descending order
        for (int i = 0; i < n / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[n - 1 - i];
            matchsticks[n - 1 - i] = temp;
        }

        // If the largest stick exceeds one side
        if (matchsticks[0] > side) {
            return false;
        }

        int[] sides = new int[4];

        return backtrack(matchsticks, 0, sides, side);
    }

    private boolean backtrack(
            int[] matchsticks,
            int index,
            int[] sides,
            int target) {

        // All matchsticks have been placed
        if (index == matchsticks.length) {
            return sides[0] == target
                    && sides[1] == target
                    && sides[2] == target
                    && sides[3] == target;
        }

        int stick = matchsticks[index];

        for (int i = 0; i < 4; i++) {

            // Do not exceed the target side length
            if (sides[i] + stick > target) {
                continue;
            }

            // Place the stick on this side
            sides[i] += stick;

            if (backtrack(matchsticks, index + 1, sides, target)) {
                return true;
            }

            // Backtrack: remove the stick
            sides[i] -= stick;

            // All sides are equivalent when empty
            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }
}
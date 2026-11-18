
class Solution {
    public long minEnd(int n, int x) {

        long result = x;
        long num = n - 1;

        int bitPosition = 0;

        while (num > 0) {

            // Check whether the current bit of x is 0
            if (((result >> bitPosition) & 1) == 0) {

                // Place the current bit of num into this position
                if ((num & 1) == 1) {
                    result |= (1L << bitPosition);
                }

                // Move to the next bit of num
                num >>= 1;
            }

            // Move to the next bit position
            bitPosition++;
        }

        return result;
    }
}

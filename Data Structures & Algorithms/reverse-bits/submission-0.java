class Solution {
    public int reverseBits(int n) {
         
    int result = 0;

    for (int i = 0; i < 32; i++) {

        // Step 1: get last bit
        int bit = n & 1;

        // Step 2: shift result left
        result = result << 1;

        // Step 3: add bit
        result = result | bit;

        // Step 4: shift n right
        n = n >> 1;
    }

    return result;
    }
}

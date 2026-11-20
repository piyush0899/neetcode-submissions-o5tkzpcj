
class Solution {
    public String gcdOfStrings(String str1, String str2) {

        // Check whether both strings follow the same repeating pattern
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Find GCD of both string lengths
        int length = gcd(str1.length(), str2.length());

        // Return the common prefix of GCD length
        return str1.substring(0, length);
    }

    private int gcd(int a, int b) {

        while (b != 0) {
            int remainder = a % b;

            a = b;
            b = remainder;
        }

        return a;
    }
}

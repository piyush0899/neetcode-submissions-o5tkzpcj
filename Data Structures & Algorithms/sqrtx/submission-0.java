class Solution {
    public int mySqrt(int x) {

        int left = 0;
        int right = x;
        int answer = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if ((long) mid * mid == x) {
                return mid;
            }
            else if ((long) mid * mid < x) {
                // mid can be the answer
                answer = mid;
                left = mid + 1;
            }
            else {
                // mid is too large
                right = mid - 1;
            }
        }

        return answer;
    }
}
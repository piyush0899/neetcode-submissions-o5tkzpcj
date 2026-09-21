public class Solution extends GuessGame {

    public int guessNumber(int n) {

        int left = 1;
        int right = n;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int result = guess(mid);

            if (result == 0) {
                // Correct guess
                return mid;
            }
            else if (result == -1) {
                // mid is greater than pick
                right = mid - 1;
            }
            else {
                // mid is smaller than pick
                left = mid + 1;
            }
        }

        return -1;
    }
}
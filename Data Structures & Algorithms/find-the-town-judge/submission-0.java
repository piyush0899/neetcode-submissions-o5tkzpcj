
class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] trustGiven = new int[n + 1];
        int[] trustReceived = new int[n + 1];

        // Count trust relationships
        for (int[] relationship : trust) {
            int personA = relationship[0];
            int personB = relationship[1];

            trustGiven[personA]++;
            trustReceived[personB]++;
        }

        // Find the person who trusts nobody
        // and is trusted by everyone else
        for (int person = 1; person <= n; person++) {

            if (trustGiven[person] == 0 &&
                trustReceived[person] == n - 1) {
                return person;
            }
        }

        return -1;
    }
}
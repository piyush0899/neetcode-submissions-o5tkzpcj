class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // frequency of s1
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        int windowSize = s1.length();

        // first window
        for (int i = 0; i < windowSize; i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        // check first window
        if (matches(count1, count2))
            return true;

        // slide window
        for (int i = windowSize; i < s2.length(); i++) {

            // add new character
            count2[s2.charAt(i) - 'a']++;

            // remove old character
            count2[s2.charAt(i - windowSize) - 'a']--;

            if (matches(count1, count2))
                return true;
        }

        return false;
    }
    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }
}

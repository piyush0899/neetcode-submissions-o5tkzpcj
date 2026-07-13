class Solution {
public int lengthOfLastWord(String s) {
        // Trim any trailing spaces
        s = s.trim();
        int length = 0;
        
        // Traverse backward from the last character
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break; // Stop when we hit a space before the last word
            }
            length++;
        }
        return length;
    }
}
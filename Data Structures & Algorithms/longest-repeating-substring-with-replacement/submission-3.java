class Solution {
    public int characterReplacement(String s, int k) {
       int left = 0;
      int maxFreq = 0;
       int maxLen = 0;
       int freq[] = new int[26];
       for(int right =0 ; right < s.length();right++){
        int index = s.charAt(right) - 'A';
        freq[index]++;
        maxFreq = Math.max(maxFreq,freq[index]);
        // int window = right - left + 1;
        while((right - left + 1) - maxFreq > k){
            freq[s.charAt(left) - 'A']--;
            left++;
        }
        maxLen = Math.max(maxLen,right - left + 1);
       }
       return maxLen;
    }
}

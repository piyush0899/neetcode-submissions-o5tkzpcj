
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for(int i =0 ; i< s.length(); i++)
        {
            boolean vis[] = new boolean[256];
            for(int j = i; j < s.length(); j++){
                 
                 if(vis[s.charAt(j)] == true ){
                    break;
                 }
                 else{
                    max = Math.max(max,j-i+1);
                    vis[s.charAt(j)] = true;
                 }

            }

        }
        return max;
    }
}

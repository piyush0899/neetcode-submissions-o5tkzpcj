class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
 char[] charArray = t.toCharArray(); 
      Arrays.sort(charArray); //
        
        // 3. Convert the sorted character array back to a String
        String sortedString = new String(charArray); 
        
        char[] charArray1 = s.toCharArray(); 
      Arrays.sort(charArray1); //
        
        // 3. Convert the sorted character array back to a String
        String sortedString1 = new String(charArray1);//
        String s2 = sortedString1+sortedString1;


        if(s2.contains(sortedString)){
            return true;
        }
        return false;
    }
}

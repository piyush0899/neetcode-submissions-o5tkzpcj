class Solution {
    public boolean isPalindrome(String s) {
        
        String cleaned = "";

        for(char ch : s.toCharArray()){

            if(Character.isLetterOrDigit(ch)){
                cleaned += Character.toLowerCase(ch);
            }

        }
        String sb = new StringBuilder(cleaned).reverse().toString();

        if(cleaned.equals(sb)){
            return true;
        }
        else{
            return false;
        }
    }
}

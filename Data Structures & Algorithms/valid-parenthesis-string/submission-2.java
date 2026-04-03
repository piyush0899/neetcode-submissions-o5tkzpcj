class Solution {
    public boolean checkValidString(String s) {

    int count = 0;
    int count1 = 0;
     for(int i = 0 ; i<s.length(); i++){

            if(s.charAt(i) == '('){
                count++;
                count1++;
            }
            else if(s.charAt(i) == ')'){
                count--;
                count1--;
            }
            else{
                count++;
                count1--;
            }

            if(count < 0) return false;
            if(count1 < 0) count1 = 0;
     }
    return (count1 == 0);

    }
}

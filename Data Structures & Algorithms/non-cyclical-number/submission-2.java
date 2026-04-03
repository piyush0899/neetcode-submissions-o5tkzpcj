class Solution {
   
        public boolean isHappy(int n) {
        
            HashSet <Integer> visit = new HashSet<>();
            while(!visit.contains(n)){
                visit.add(n);
                n=sumOfsquares(n);
                if(n == 1)
                {
                    return true;
                }
               
            }
        return false;
    }

    public int sumOfsquares(int n){
        int output = 0;
        while(n > 0){
            int digits = n%10;
            output = output + digits*digits;
            n = n/10;
        }
        return output;
    }

}

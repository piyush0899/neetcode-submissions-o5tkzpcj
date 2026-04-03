class Solution {
    public int[] plusOne(int[] digits) {

     int n = digits.length;
     long sum = 0;
     int m = n;
    
     for(int i =0 ; i< n; i++){

        sum = sum +digits[i]*(long)Math.pow(10,m-1);
        m--;
     }
    
    sum = sum +1;
    System.out.println(sum);
    String sum1 =  String.valueOf(sum);
    char ch[] = sum1.toCharArray();
    int ans[] = new int[ch.length];
    for(int i =0 ; i<ch.length; i++){
        ans[i] = ch[i] - '0';
    }
return ans;
    }
}

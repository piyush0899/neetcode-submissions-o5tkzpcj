class Solution {
    public String multiply(String num1, String num2) {
        
        long nu1 = Long.parseLong(num1);
        long nu2 = Long.parseLong(num2);
        long result =nu1*nu2;
        String result1 = new String();
        result1 = String.valueOf(result);

        return result1;

    }
}

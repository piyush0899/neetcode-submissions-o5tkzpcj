class Solution {
    public int maxProfit(int[] prices) {
        
        int max = 0;
        int mini = Integer.MAX_VALUE;

        for(int i =0 ; i< prices.length; i++){

                if(prices[i] < mini){
                    mini = prices[i];
                }
                int diff = prices[i] - mini;
                if(max < diff){
                    max = diff;
                }
        }
return max;
    }
}

class Solution {
    public int maxProduct(int[] nums) {

        int maxProd = 1;
        int minProd = 1;
        int result = Integer.MIN_VALUE;

        for(int i =0 ; i<nums.length; i++){

            int currentProd = nums[i];

            if(currentProd < 0){
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(currentProd,maxProd*currentProd);
            minProd = Math.min(currentProd,minProd*currentProd);

            result = Math.max(result,maxProd);

        }

        return result;
    }
}

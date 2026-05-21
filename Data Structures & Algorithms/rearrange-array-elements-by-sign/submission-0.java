class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int ans [] = new int [n];
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for(int i =0 ; i<n;i++){
            if(nums[i] >= 0){
                pos.add(nums[i]);
            }
            else{
                neg.add(nums[i]);
            }
        }

        if(pos.size() >= neg.size()){

            for(int i = 0; i<neg.size();i++){
                ans[2*i] = pos.get(i);
                ans[2*i+1] = neg.get(i);
            }
            int index = neg.size()*2;
            for(int i = neg.size() ; i <pos.size();i++){
                ans[index] = pos.get(i);
            }
        }
        else{
         

            for(int i = 0; i<pos.size();i++){
                ans[2*i] = pos.get(i);
                ans[2*i+1] = neg.get(i);
            }
            int index = pos.size()*2;
            for(int i = pos.size() ; i <neg.size();i++){
                ans[index] = neg.get(i);
            }
        }

return ans;

    }
}
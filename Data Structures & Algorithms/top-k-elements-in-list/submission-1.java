class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> mpp = new HashMap<>();

        for(int i = 0; i<nums.length;i++ ){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> mpp.get(a) - mpp.get(b)
        );
        int count = 0;
        for(int num : mpp.keySet()){
            pq.offer(num);
            count++;
            if(count > k){
                pq.poll();
            }
        }
       
        int res[] = new int[k];

        for(int i=0;i<k;i++){
            res[i] = pq.peek();
            pq.poll();
        }

return res;

    }
}

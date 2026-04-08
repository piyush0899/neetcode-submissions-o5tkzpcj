class Solution {
    public int lastStoneWeight(int[] stones) {
         // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // Add all stones
        for (int stone : stones) {
            pq.add(stone);
        }
        
        // Process
        while (pq.size() > 1) {
            int y = pq.poll(); // largest
            int x = pq.poll(); // second largest
            
            if (y != x) {
                pq.add(y - x);
            }
        }
        
        return pq.isEmpty() ? 0 : pq.peek();
    }
}

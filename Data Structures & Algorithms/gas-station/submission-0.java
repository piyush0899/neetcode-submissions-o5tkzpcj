class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
         int n = gas.length;
        int startIdx = -1;
        for (int i = 0; i < n; i++) {
            
            // Current Available gas
            int currGas = 0;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                
                // Circular Index
                int idx = (i + j) % n;
                currGas = currGas + gas[idx] - cost[idx];
                
                // If Available gas is less than zero, then it isn't
                // possible to proceed further with this starting point
                if (currGas < 0) {
                    flag = false;
                    break;
                }
            }
            
          	// If flag is true, then we have found
      		// the valid starting point
            if (flag) {
                startIdx = i;
                break;
            }
        }
        
        return startIdx;
    }
}

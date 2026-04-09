class Solution {
    public List<Integer> partitionLabels(String s) {
         int[] lastIndex = new int[26];
        
        // Step 1: Store last occurrence
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;
        
        // Step 2: Traverse
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            
            // Partition found
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        
        return result;
    }
}

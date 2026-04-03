class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
         // Step 1: size check
        if (hand.length % groupSize != 0) return false;

        // Step 2: frequency map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 3: sort array
        Arrays.sort(hand);

        // Step 4: process
        for (int num : hand) {

            if (map.get(num) == 0) continue;

            // try to form group
            for (int i = 0; i < groupSize; i++) {

                int curr = num + i;

                if (map.getOrDefault(curr, 0) == 0) {
                    return false;
                }

                map.put(curr, map.get(curr) - 1);
            }
        }

        return true;
    }
}

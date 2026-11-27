class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> currentRow = new ArrayList<>();

            // First element is always 1
            currentRow.add(1);

            // Calculate middle elements
            for (int j = 1; j < i; j++) {

                int left = result.get(i - 1).get(j - 1);
                int right = result.get(i - 1).get(j);

                currentRow.add(left + right);
            }

            // Last element is 1 (except for the first row)
            if (i > 0) {
                currentRow.add(1);
            }

            result.add(currentRow);
        }

        return result;
    }
}

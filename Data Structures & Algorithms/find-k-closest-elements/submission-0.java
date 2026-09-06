class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = arr.length - k;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // left is the starting index of the answer window
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
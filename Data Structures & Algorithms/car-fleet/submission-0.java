class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
          int n = position.length;

    // Step 1: pair position + time
    double[][] cars = new double[n][2];

    for (int i = 0; i < n; i++) {
        cars[i][0] = position[i];
        cars[i][1] = (double)(target - position[i]) / speed[i];
    }

    // Step 2: sort by position descending
    Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

    int fleets = 0;
    double prevTime = 0;

    // Step 3: traverse
    for (int i = 0; i < n; i++) {

        double currTime = cars[i][1];

        if (currTime > prevTime) {
            fleets++;
            prevTime = currTime;
        }
    }

    return fleets;
    }
}

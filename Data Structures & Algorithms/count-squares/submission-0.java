class CountSquares {

   
    Map<String, Integer> map;

    public CountSquares() {

        map = new HashMap<>();
    }

    public void add(int[] point) {

        int x = point[0];
        int y = point[1];

        String key = x + "," + y;

        map.put(key,
                map.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {

        int x1 = point[0];
        int y1 = point[1];

        int result = 0;

        for (String key : map.keySet()) {

            String[] arr = key.split(",");

            int x2 = Integer.parseInt(arr[0]);
            int y2 = Integer.parseInt(arr[1]);

            // diagonal condition
            if (Math.abs(x1 - x2) !=
                Math.abs(y1 - y2) ||

                x1 == x2 ||
                y1 == y2) {

                continue;
            }

            // remaining corners
            String p1 = x1 + "," + y2;
            String p2 = x2 + "," + y1;

            result +=
                map.get(key) *
                map.getOrDefault(p1, 0) *
                map.getOrDefault(p2, 0);
        }

        return result;
    }
}

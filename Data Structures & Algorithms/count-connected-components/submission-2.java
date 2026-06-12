class Solution {
  public int countComponents(int n, int[][] edges) {

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;

        for (int[] edge : edges) {

            int p1 = find(edge[0], parent);
            int p2 = find(edge[1], parent);

            if (p1 != p2) {

                parent[p1] = p2;
                components--;
            }
        }

        return components;
    }

    private int find(int x,
                     int[] parent) {

        if (parent[x] != x) {
            parent[x] =
                find(parent[x], parent);
        }

        return parent[x];
    }
}

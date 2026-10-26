
class Solution {

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;

        // A single index is already connected to itself
        if (n == 1) {
            return true;
        }

        // If any number is 1, it cannot connect to any other number
        for (int num : nums) {
            if (num == 1) {
                return false;
            }
        }

        // Maximum possible value in nums
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // DSU works on array indices
        DSU dsu = new DSU(n);

        // Map each prime factor to the first index containing it
        int[] primeOwner = new int[max + 1];
        Arrays.fill(primeOwner, -1);

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            // Extract distinct prime factors
            for (int factor = 2; factor * factor <= num; factor++) {

                if (num % factor == 0) {

                    // Connect this index to the previous index
                    // containing the same prime factor
                    if (primeOwner[factor] != -1) {
                        dsu.union(i, primeOwner[factor]);
                    } else {
                        primeOwner[factor] = i;
                    }

                    // Remove all occurrences of this factor
                    while (num % factor == 0) {
                        num /= factor;
                    }
                }
            }

            // Any remaining number greater than 1 is prime
            if (num > 1) {
                if (primeOwner[num] != -1) {
                    dsu.union(i, primeOwner[num]);
                } else {
                    primeOwner[num] = i;
                }
            }
        }

        // Every index must belong to the same connected component
        return dsu.getComponents() == 1;
    }

    static class DSU {
        int[] parent;
        int[] size;
        int components;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            components = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            // Union by size
            if (size[rootX] < size[rootY]) {
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }

            parent[rootY] = rootX;
            size[rootX] += size[rootY];

            components--;
        }

        int getComponents() {
            return components;
        }
    }
}
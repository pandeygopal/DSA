
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }

        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE;

        for (int[] arr : ops) {
            if (minA > arr[0]) {
                minA = arr[0];
            }

            if (minB > arr[1]) {
                minB = arr[1];
            }
        }

        return minA * minB;

    }
}
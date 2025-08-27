class Solution {
    private static final int[][] DIRS = {
        {-1, +1}, 
        {+1, +1}, 
        {+1, -1},  
        {-1, -1}   
    };

    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][][][] memo = new int[m][n][2][2][4];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int t = 0; t < 2; t++)
                    for (int v = 0; v < 2; v++)
                        for (int d = 0; d < 4; d++)
                            memo[i][j][t][v][d] = -1;

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int ni = i + DIRS[d][0], nj = j + DIRS[d][1];
                        result = Math.max(result,
                            1 + dfs(grid, ni, nj, false, 2, d, memo));
                    }
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid,
                    int i, int j,
                    boolean turned,
                    int num,
                    int dir, 
                    int[][][][][] memo) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != num)
            return 0;

        int turnedIdx = turned ? 1 : 0;
        int valIdx = (num == 2 ? 0 : 1);
        if (memo[i][j][turnedIdx][valIdx][dir] != -1)
            return memo[i][j][turnedIdx][valIdx][dir];

        int nextNum = (num == 2 ? 0 : 2);

        int res = 1 + dfs(grid,
                         i + DIRS[dir][0], j + DIRS[dir][1],
                         turned, nextNum, dir, memo);

        if (!turned) {
            int newDir = (dir + 1) % 4;
            res = Math.max(res, 1 + dfs(grid,
                                        i + DIRS[newDir][0], j + DIRS[newDir][1],
                                        true, nextNum, newDir, memo));
        }

        memo[i][j][turnedIdx][valIdx][dir] = res;
        return res;
    }
}

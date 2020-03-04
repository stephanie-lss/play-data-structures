package com.solution200;

/**
 * @author LiSheng
 * @date 2020/2/27 15:54
 */
public class Solution2 {
    private int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int m, n;
    private boolean[][] visited;
    private int res;

    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        res = 0;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + direct[i][0];
            int newY = y + direct[i][1];
            if (inBroad(newX, newY) && grid[newX][newY] == '1') {
                if (!visited[newX][newY]) {
                    dfs(grid, newX, newY);
                }
            }
        }
    }

    private boolean inBroad(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}

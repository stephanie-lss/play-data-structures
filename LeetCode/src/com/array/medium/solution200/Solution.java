package com.array.medium.solution200;

/**
 * @author LiSheng
 * @date 2020/2/27 15:54
 */
public class Solution {
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
            if (isBroad(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }
    }

    private boolean isBroad(int newX, int newY) {
        return newX >= 0 && newX < m && newY >= 0 && newY < n;
    }
}

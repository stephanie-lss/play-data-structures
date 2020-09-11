package com.solution63;

/**
 * @author LiSheng
 * @date 2020/7/6 19:53
 */
class Solution {
    private int[][] direct = {{1, 0}, {0, 1}};
    private boolean[][] visited;
    private int path = 0;
    private int row;
    private int col;
    private int[][] grid;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (null == obstacleGrid || (row = obstacleGrid.length) == 0) {
            return 0;
        }
        this.col = obstacleGrid[0].length;
        this.visited = new boolean[row][col];
        this.grid = obstacleGrid;
        dfs(0, 0);
        return path;
    }

    private boolean dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 1) {
            return false;
        }
        if (x == row - 1 && y == col - 1) {
            path++;
            return true;
        }
        visited[x][y] = true;
        for (int i = 0; i < 2; i++) {
            int newX = x + direct[i][0];
            int newY = y + direct[i][1];
            dfs(newX, newY);
        }
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(new Solution().uniquePathsWithObstacles(grid));
    }
}
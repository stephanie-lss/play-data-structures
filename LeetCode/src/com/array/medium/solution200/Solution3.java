package com.array.medium.solution200;

/**
 * @author LiSheng
 * @date 2020/4/15 15:42
 */
class Solution3 {

    private boolean[][] visited;
    int res;
    int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int newX = x + direct[i][0];
            int newY = y + direct[i][1];
            if (inArea(grid, newX, newY) && !visited[newX][newY] && grid[newX][newY] == 1) {
                visited[newX][newY] = true;
                dfs(grid, newX, newY);
            }
        }
    }

    private boolean inArea(char[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    public static void main(String[] args) {
        char[][] grid = {{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
//        char[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0 ,0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        System.out.println(new Solution3().numIslands(grid));
    }
}
package com.solution329;

/**
 * @author LiSheng
 * @date 2020/7/27 9:08
 */
class Solution {
    private int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private boolean[][] visited;
    private int row;
    private int col;
    private int[][] memo;

    // 记忆化搜索 DFS 时间O(m*n) 空间O（m*n)
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || (row = matrix.length) == 0 || (col = matrix[0].length) == 0) {
            return 0;
        }
        int max = 0;
        this.memo = new int[row][col];
        this.visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;

    }

    private int dfs(int[][] matrix, int x, int y) {
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        // 标记单元格是否被访问过
        visited[x][y] = true;
        int len = 0;
        // 遍历四个方向
        for (int i = 0; i < 4; i++) {
            int newX = x + direct[i][0];
            int newY = y + direct[i][1];
            if (newX >= 0 && newX < row && newY >= 0 && newY < col && matrix[x][y] < matrix[newX][newY] && !visited[newX][newY]) {
                len = Math.max(len, dfs(matrix, newX, newY));
            }
        }
        // 恢复
        visited[x][y] = false;
        // 再加上(x,y)自己的长度
        memo[x][y] = len + 1;
        return memo[x][y];
    }
}
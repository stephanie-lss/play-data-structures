package com.offer.interview12;

/**
 * @author LiSheng
 * @date 2020/7/4 13:56
 */
class Solution3 {
    private int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    protected char[][] grid;
    private boolean[][] visited;
    private int row;
    private int col;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        this.row = board.length;
        this.col = board[0].length;
        this.visited = new boolean[row][col];
        this.grid = board;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(String word, int index, int x, int y) {
        if (index == word.length()) {
            return true;
        }
        if (!inArea(x, y) || visited[x][y]) {
            return false;
        }
        if (word.charAt(index) == grid[x][y]) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + direct[i][0];
                int newY = y + direct[i][1];
                if (dfs(word, index + 1, newX, newY)) {
                    return true;
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}
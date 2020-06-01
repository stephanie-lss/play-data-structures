package com.offer.interview12;

/**
 * @author LiSheng
 * @date 2020/6/1 9:09
 */
public class Solution2 {
    private boolean[][] visited;
    private int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int row;
    private int col;

    public boolean exist(char[][] board, String word) {
        this.row = board.length;
        if (row == 0) {
            return false;
        }
        this.col = board[0].length;
        this.visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (!inArea(x, y) || visited[x][y]) {
            return false;
        }
        char c = word.charAt(index);
        if (c == board[x][y]) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + direct[i][0];
                int newY = y + direct[i][1];
                if (dfs(board, newX, newY, word, index + 1)) {
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

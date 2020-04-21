package com.array.medium.solution130;

/**
 * @author LiSheng
 * @date 2020/4/15 20:05
 */
public class Solution2 {

    int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[][] visited;


    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) {
            return;
        }
        int col = board[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 || j == 0 || i == row - 1 || j == col - 1) && board[i][j] == 'O') {
                    visited[i][j] = true;
                    dfs(board, i, j, row, col);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y, int row, int col) {
        for (int i = 0; i < 4; i++) {
            int newX = x + direct[i][0];
            int newY = y + direct[i][1];
            if (inArea(newX, newY, row, col) && !visited[newX][newY] && board[newX][newY] == 'O') {
                visited[newX][newY] = true;
                dfs(board, newX, newY, row, col);
            }
        }
    }

    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}

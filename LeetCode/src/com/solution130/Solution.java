package com.solution130;

/**
 * @author LiSheng
 * @date 2020/2/28 10:56
 */
public class Solution {
    private int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m;
    private int n;

    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1 && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (!inArea(x, y) || 'X' == board[x][y] || '*' == board[x][y]) {
            return;
        }
        board[x][y] = '*';
        for (int i = 0; i < 4; i++) {
            int newx = x + direct[i][0];
            int newy = y + direct[i][1];
            if (inArea(newx, newy)) {
                dfs(board, newx, newy);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}

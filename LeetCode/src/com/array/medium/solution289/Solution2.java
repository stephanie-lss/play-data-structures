package com.array.medium.solution289;

/**
 * @author LiSheng
 * @date 2020/4/18 11:01
 */
class Solution2 {
    private int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                checkLive(new int[]{i, j}, board);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private void checkLive(int[] cell, int[][] board) {
        int liveCount = 0;
        for (int i = 0; i < 8; i++) {
            int newX = cell[0] + direct[i][0];
            int newY = cell[1] + direct[i][1];
            if (inArea(newX, newY, board.length, board[0].length)) {
                if (Math.abs(board[newX][newY]) == 1) {
                    liveCount++;
                }
            }
        }
        if (board[cell[0]][cell[1]] == 1 && (liveCount < 2 || liveCount > 3)) {
            board[cell[0]][cell[1]] = -1;
        }
        if (board[cell[0]][cell[1]] == 0 && liveCount == 3) {
            board[cell[0]][cell[1]] = 2;
        }
    }

    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}
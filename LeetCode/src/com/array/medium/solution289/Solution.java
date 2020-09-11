package com.array.medium.solution289;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/4/18 11:01
 */
class Solution {
    private int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    private int[][] res;

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        res = new int[row][col];

        Queue<int[]> live = new LinkedList<>();
        Queue<int[]> dead = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = board[i][j];
                if (board[i][j] == 1) {
                    live.offer(new int[]{i, j});
                } else {
                    dead.offer(new int[]{i, j});
                }
            }
        }
        while (!live.isEmpty() || !dead.isEmpty()) {
            if (!live.isEmpty()) {
                int[] liveCell = live.poll();
                checkLive(liveCell, board);
            }
            if (!dead.isEmpty()) {
                int[] deadCell = dead.poll();
                checkLive(deadCell, board);
            }
        }
        System.arraycopy(res,0,board,0,row);
    }

    private void checkLive(int[] cell, int[][] board) {
        int liveCount = 0;
        for (int i = 0; i < 8; i++) {
            int newX = cell[0] + direct[i][0];
            int newY = cell[1] + direct[i][1];
            if (inArea(newX, newY, board.length, board[0].length)) {
                if (board[newX][newY] == 1) {
                    liveCount++;
                }
            }
        }
        if (board[cell[0]][cell[1]] == 1 && (liveCount < 2 || liveCount > 3)) {
            res[cell[0]][cell[1]] = 0;
        }
        if (board[cell[0]][cell[1]] == 0 && liveCount == 3) {
            res[cell[0]][cell[1]] = 1;
        }
    }

    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}
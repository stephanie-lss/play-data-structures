package com.array.medium.solution542;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/4/15 9:42
 */
class Solution {
    private int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        int[][] res = new int[row][col];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = poll[0] + direct[i][0];
                int newY = poll[1] + direct[i][1];
                if (inArea(row, col, newX, newY) && !visited[newX][newY]) {
                    res[newX][newY] = res[poll[0]][poll[1]] + 1;
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return res;
    }

    private boolean inArea(int row, int col, int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}
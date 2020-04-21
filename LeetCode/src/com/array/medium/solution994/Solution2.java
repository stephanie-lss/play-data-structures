package com.array.medium.solution994;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/4/15 16:37
 */
public class Solution2 {

    private int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int res;
    private boolean hasGood;

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            hasGood = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] badOrange = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int tmpX = badOrange[0] + direct[j][0];
                    int tmpY = badOrange[1] + direct[j][1];
                    if (inArea(row, col, tmpX, tmpY) && grid[tmpX][tmpY] == 1) {
                        grid[tmpX][tmpY] = 2;
                        queue.offer(new int[]{tmpX, tmpY});
                        hasGood = true;
                    }
                }
            }
            if (hasGood) {
                res++;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return res;
    }

    private boolean inArea(int row, int col, int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }

    public static void main(String[] args) {
//        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int[][] grid = {{0}};
        System.out.println(new Solution2().orangesRotting(grid));
    }
}

package com.array.medium.solution1162;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/3/29 12:30
 */
public class Solution {
    private int[][] direct = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        if (queue.isEmpty() || queue.size() == row * col) {
            return -1;
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = poll[0] + direct[i][0];
                int newY = poll[1] + direct[i][1];
                if (inArea(newX, newY, row, col) && !visited[newX][newY] && grid[newX][newY] == 0) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                    grid[newX][newY] = grid[poll[0]][poll[1]] + 1;
                }
            }
            if (queue.isEmpty()) {
                return grid[poll[0]][poll[1]] - 1;
            }
        }
        throw null;
    }

    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(new Solution().maxDistance(grid));
    }
}

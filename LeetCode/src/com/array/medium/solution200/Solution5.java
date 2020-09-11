package com.array.medium.solution200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/4/20 10:01
 */
public class Solution5 {
    private int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private boolean[][] visited;
    private int res = 0;
    private Queue<int[]> queue = new LinkedList<>();

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    res++;
                    bfs(grid, i, j, row, col);
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int x, int y, int row, int col) {
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = top[0] + direct[i][0];
                int newY = top[1] + direct[i][1];
                if (inArea(newX, newY, row, col) && !visited[newX][newY] && grid[newX][newY] == 1) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }

    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}

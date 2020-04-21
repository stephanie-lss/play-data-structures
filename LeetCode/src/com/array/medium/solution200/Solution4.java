package com.array.medium.solution200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/4/15 15:42
 */
class Solution4 {

    private boolean[][] visited;
    int res;
    int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                    bfs(grid, queue);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = position[0] + direct[i][0];
                int newY = position[1] + direct[i][1];
                if (inArea(grid, newX, newY) && !visited[newX][newY] && grid[newX][newY] ==1) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }

    private boolean inArea(char[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    public static void main(String[] args) {
//        char[][] grid = {{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
        char[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0 ,0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        System.out.println(new Solution4().numIslands(grid));
    }
}
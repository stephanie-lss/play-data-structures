package com.solution1162;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/3/29 12:30
 */
public class Solution {
    private int[][] direct = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int maxDistance(int[][] grid) {
        int row = grid.length;
        int line = grid[0].length;
        // 创建BFS算法中所需得队列
        Queue<int[]> queue = new ArrayDeque<>();
        //遍历整个地图，将所有陆地入队
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        boolean hasOcean = false;
        int[] point = null;

        // 从陆地依次遍历四个方向
        while (!queue.isEmpty()) {
            //出队
            point = queue.poll();
            int x = point[0];
            int y = point[1];

            //四个方向
            for (int i = 0; i < 4; i++) {
                //新地点
                int newX = x + direct[i][0];
                int newY = y + direct[i][1];
                //判断是否越界或者是否以及遍历过了
                if (!isArea(grid, newX, newY) || grid[newX][newY] != 0) {
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1;
                hasOcean = true;
                //将新地点入队
                queue.offer(new int[]{newX, newY});
            }
        }
        if (point == null || !hasOcean) {
            return -1;
        }
        return grid[point[0]][point[1]] - 1;
    }

    private boolean isArea(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid[0].length && y < grid.length;
    }
}

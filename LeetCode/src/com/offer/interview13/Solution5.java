package com.offer.interview13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/7/4 14:22
 */
class Solution5 {
    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0) {
            return 0;
        }
        int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] grid = queue.poll();
            if (grid[0] < 0 || grid[0] >= m || grid[1] < 0 || grid[1] >= n || visited[grid[0]][grid[1]]) {
                continue;
            }
            if (grid[0] / 10 + grid[0] % 10 + grid[1] / 10 + grid[1] % 10 <= k) {
                visited[grid[0]][grid[1]] = true;
                count++;
                for (int i = 0; i < 4; i++) {
                    int newX = grid[0] + direct[i][0];
                    int newY = grid[1] + direct[i][1];
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return count;
    }
}
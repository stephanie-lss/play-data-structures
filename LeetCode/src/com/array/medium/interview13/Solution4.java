package com.array.medium.interview13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/4/15 11:45
 */
class Solution4 {
    public int movingCount(int m, int n, int k) {
        int[][] direct = {{1, 0}, {0, 1}};
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        count++;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 2; i++) {
                int newX = x + direct[i][0];
                int newY = y + direct[i][1];
                if (inArea(m, n, newX, newY) && !visited[newX][newY] && (newX / 10 + newX % 10 + newY / 10 + newY % 10) <= k) {
                    System.out.println(newX + " " + newY);
                    visited[newX][newY] = true;
                    count++;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return count;
    }

    private boolean inArea(int m, int n, int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().movingCount(7, 2, 3));
    }
}
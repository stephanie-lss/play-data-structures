package com.interview13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/4/8 9:27
 */
class Solution3 {
    int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            if (inArea(position[0], position[1], m, n) && !visited[position[0]][position[1]] && (position[0] / 10 + position[0] % 10 + position[1] / 10 + position[1] % 10) <= k) {
                visited[position[0]][position[1]] = true;
                System.out.println(position[0]+":"+position[1]);
                res++;
                for (int i = 0; i < 4; i++) {
                    int newX = position[0] + direct[i][0];
                    int newY = position[1] + direct[i][1];
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return res;
    }

    private boolean inArea(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }


    public static void main(String[] args) {
        System.out.println(new Solution3().movingCount(16, 8, 4));
    }
}
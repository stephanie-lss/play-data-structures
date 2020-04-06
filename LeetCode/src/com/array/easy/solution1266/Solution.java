package com.array.easy.solution1266;

/**
 * @author LiSheng
 * @date 2020/3/31 20:06
 */
public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int curX = points[i][0];
            int nextX = points[i + 1][0];
            int curY = points[i][1];
            int nextY = points[i + 1][1];
            res += Math.max(Math.abs(nextX - curX), Math.abs(nextY - curY));
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(new Solution().minTimeToVisitAllPoints(points));
    }
}

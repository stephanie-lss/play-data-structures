package com.zhousai.three;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/18 16:17
 */
class Solution {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] me = {0, 0, 0};
        int[] res = new int[requirements.length];
        boolean[] visited = new boolean[requirements.length];
        Arrays.fill(res, -1);

        for (int j = 0; j < requirements.length; j++) {
            if (0 == requirements[j][0] + requirements[j][1] + requirements[j][2]) {
                res[j] = 0;
                visited[j] = true;
            }
        }
        for (int i = 1; i <= increase.length; i++) {
            for (int j = 0; j < 3; j++) {
                me[j] += increase[i - 1][j];
            }
            for (int j = 0; j < requirements.length; j++) {
                if (visited[j]) {
                    continue;
                }
                if (me[0] >= requirements[j][0] && me[1] >= requirements[j][1] && me[2] >= requirements[j][2]) {
                    res[j] = i;
                    visited[j] = true;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] inc = {{0, 4, 5}, {4, 8, 8}, {8, 6, 1}, {10, 10, 0}};
//        int[][] inc = {{2, 8, 4},{2, 5, 0},{10, 9, 8}};
        int[][] req = {{12, 11, 16}, {20, 2, 6}, {9, 2, 6}, {10, 18, 3}, {8, 14, 9}};
//        int[][] req = {{2, 11, 3}, {15, 10, 7}, {9, 17, 12}, {8, 1, 14}};
        System.out.println(new Solution().getTriggerTime(inc, req));
    }
}
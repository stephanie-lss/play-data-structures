package com.array.easy.solution1252;

/**
 * @author LiSheng
 * @date 2020/3/31 18:17
 */
public class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int count = 0;
        int[][] res = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            int idx = 0;
            while (idx < m) {
                res[indices[i][0]][idx++]++;
            }
            int idy = 0;
            while (idy < n) {
                res[idy++][indices[i][1]]++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (res[i][j] % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] ind = {{0, 1}, {1, 1}};
        System.out.println(new Solution().oddCells(2, 3, ind));
    }
}

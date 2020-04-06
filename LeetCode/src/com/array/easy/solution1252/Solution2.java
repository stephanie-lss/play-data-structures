package com.array.easy.solution1252;

/**
 * @author LiSheng
 * @date 2020/3/31 18:17
 */
public class Solution2 {
    public int oddCells(int n, int m, int[][] indices) {
        int[] row = new int[n];
        int[] line = new int[m];
        for (int i = 0; i < indices.length; i++) {
            row[indices[i][0]]++;
            line[indices[i][1]]++;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((row[i] + line[j]) % 2 != 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ind = {{0, 1}, {1, 1}};
        System.out.println(new Solution2().oddCells(2, 3, ind));
    }
}

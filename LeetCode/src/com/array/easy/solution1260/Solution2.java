package com.array.easy.solution1260;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/31 18:43
 */
public class Solution2 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                k %= m * n;
                arr[k++] = grid[i][j];
            }
        }

        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < m * n; i++) {
            tmp.add(arr[i]);
            if ((i + 1) % 3 == 0) {
                res.add(tmp);
                tmp = new ArrayList<>();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        new Solution2().shiftGrid(grid, k);
    }
}

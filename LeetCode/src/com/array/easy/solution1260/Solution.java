package com.array.easy.solution1260;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/31 18:43
 */
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k %= m * n;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
        }
        List<Integer> rightList = list.subList(0, m * n - k);
        List<Integer> leftList = list.subList(m * n - k, m * n);
        leftList.addAll(rightList);
        List<Integer> tmp = new ArrayList<>();
        for (Integer i : leftList) {
            tmp.add(i);
            if (tmp.size() == n) {
                res.add(tmp);
                tmp = new ArrayList<>();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        new Solution().shiftGrid(grid, k);
    }
}

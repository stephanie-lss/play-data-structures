package com.array.easy.solution1380;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/1 13:28
 */
public class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int j = 0; j < matrix[0].length; j++) {
                if (min > matrix[i][j]) {
                    idx = j;
                    min = matrix[i][j];
                }
            }
            boolean flag = true;
            for (int j = 0; j < matrix.length; j++) {
                if (min < matrix[j][idx] && j != i) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(min);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        new Solution().luckyNumbers(mat);
    }
}

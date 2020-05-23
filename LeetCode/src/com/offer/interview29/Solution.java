package com.offer.interview29;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/22 11:21
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int left = 0, right = matrix[0].length - 1, top = 0, botton = matrix.length - 1;
        while (true) {
            //从左往右走
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if (++top > botton) {
                break;
            }
            //从上往下走
            for (int i = top; i <= botton; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            //从右往左走
            for (int i = right; i >= left; i--) {
                res.add(matrix[botton][i]);
            }
            if (--botton < top) {
                break;
            }
            //从下往上走
            for (int i = botton; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
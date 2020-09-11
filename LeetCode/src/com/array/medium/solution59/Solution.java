package com.array.medium.solution59;

/**
 * @author LiSheng
 * @date 2020/4/13 14:51
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int t = 0;
        int b = n - 1;
        int l = 0;
        int r = n - 1;
        int num = 1;
        while (true) {
            //从左往右走
            for (int i = l; i <= r; i++) {
                res[t][i] = num++;
            }
            t++;
            if (t > b) {
                break;
            }
            //从上往下走
            for (int i = t; i <= b; i++) {
                res[i][r] = num++;
            }
            r--;
            if (r < l) {
                break;
            }
            //从右往左走
            for (int i = r; i >= l; i--) {
                res[b][i] = num++;
            }
            b--;
            if (b < t) {
                break;
            }
            //从下往上走
            for (int i = b; i >= t; i--) {
                res[i][l] = num++;
            }
            l++;
            if (l > r) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateMatrix(3));
    }
}

package com.array.medium.solution1329;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author LiSheng
 * @date 2020/4/13 16:32
 */
public class Solution2 {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        ArrayList<Integer>[] diags = new ArrayList[m + n - 1];
        for (int i = 0; i < diags.length; i++) {
            diags[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diags[j - i + m - 1].add(mat[i][j]);
            }
        }
        for (ArrayList<Integer> diag : diags) {
            Collections.sort(diag);
        }
        int[] idx = new int[m + n - 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = diags[j - i + m - 1].get(idx[j - i + m - 1]);
                idx[j - i + m - 1]++;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        System.out.println(new Solution2().diagonalSort(mat));
    }
}

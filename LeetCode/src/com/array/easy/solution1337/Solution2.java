package com.array.easy.solution1337;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/3/31 21:56
 */
public class Solution2 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] bat = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    bat[i]++;
                }
            }
        }
        int[] copy = Arrays.copyOf(bat, bat.length);
        Arrays.sort(bat);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < copy.length; j++) {
                if (bat[i] == copy[j]) {
                    res[i] = j;
                    copy[j] = Integer.MAX_VALUE;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int k = 3;
        new Solution2().kWeakestRows(mat, k);
    }
}

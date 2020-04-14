package com.array.medium.solution1329;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/4/13 16:32
 */
public class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = m - 2; i >= 0; i--) {
            LinkedList<Integer> list = new LinkedList<>();
            int j = 0;
            while (i < m && j < n) {
                list.add(mat[i++][j++]);
            }
            i--;
            j--;
            Collections.sort(list);
            while (!list.isEmpty()) {
                mat[i--][j--] = list.removeLast();
            }
            i++;
        }
        for (int i = 1; i < n; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            int j = 0;
            while (i < n && j < m) {
                list.addLast(mat[j++][i++]);
            }
            i--;
            j--;
            Collections.sort(list);
            while (!list.isEmpty()) {
                mat[j--][i--] = list.removeLast();
            }
            i++;
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        System.out.println(new Solution().diagonalSort(mat));
    }
}

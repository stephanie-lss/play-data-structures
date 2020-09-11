package com.array.easy.solution661;

/**
 * @author LiSheng
 * @date 2020/3/30 11:57
 */
public class Solution {
    private int[][] direct = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                calculateAve(M, res, i, j);
            }
        }
        return res;
    }

    private void calculateAve(int[][] M, int[][] res, int i, int j) {
        int sum = 0;
        int count = 0;
        for (int k = 0; k < 9; k++) {
            int newX = i + direct[k][0];
            int newY = j + direct[k][1];
            if (inArea(M, newX, newY)) {
                count++;
                sum += M[newX][newY];
            }
        }
        res[i][j] = sum / count;
    }

    private boolean inArea(int[][] M, int x, int y) {
        return x >= 0 && x < M.length && y >= 0 && y < M[0].length;
    }

    public static void main(String[] args) {
        int[][] M = {{1}};
        new Solution().imageSmoother(M);
    }
}

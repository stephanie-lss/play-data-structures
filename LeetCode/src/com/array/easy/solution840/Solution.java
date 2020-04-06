package com.array.easy.solution840;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/3/30 17:27
 */
class Solution {
    private int[][] direct = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (isCool(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isCool(int[][] grid, int x, int y) {
        int[] num = new int[9];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            num[i] = grid[x + direct[i][0]][y + direct[i][1]];
            if (num[i] > 0 && num[i] <= 9) {
                set.add(num[i]);
            } else {
                return false;
            }
        }
        if (set.size() != 9){
            return false;
        }
        int ref = num[0] + num[1] + num[2];
        if (num[3] + num[4] + num[5] != ref || num[6] + num[7] + num[8] != ref || num[0] + num[3] + num[6] != ref || num[1] + num[4] + num[7] != ref || num[2] + num[5] + num[8] != ref || num[0] + num[4] + num[8] != ref || num[2] + num[4] + num[6] != ref) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}};
        new Solution().numMagicSquaresInside(grid);
    }
}
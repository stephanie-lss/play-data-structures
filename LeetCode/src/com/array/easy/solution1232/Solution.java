package com.array.easy.solution1232;

/**
 * @author LiSheng
 * @date 2020/3/31 18:04
 */
public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        double t1 = coordinates[0][1] - coordinates[1][1];
        double t2 = coordinates[0][0] - coordinates[1][0];
        double t = t1 / t2;
        for (int i = 1; i < coordinates.length - 1; i++) {
            double k1 = coordinates[i][1] - coordinates[i + 1][1];
            double k2 = coordinates[i][0] - coordinates[i + 1][0];
            double k = k1 / k2;
            if (t - k != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] coo = {{-4, -3}, {1, 0}, {3, -1}, {0, -1}, {-5, 2}};
        System.out.println(new Solution().checkStraightLine(coo));
    }
}

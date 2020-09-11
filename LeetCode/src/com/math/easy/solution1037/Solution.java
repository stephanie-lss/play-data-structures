package com.math.easy.solution1037;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/12 12:35
 */
public class Solution {
    public boolean isBoomerang(int[][] points) {
        if (Arrays.equals(points[0], points[1]) || Arrays.equals(points[1], points[2]) || Arrays.equals(points[0], points[2])) {
            return false;
        }
        double k1 = 0.0, k2 = 0.0, k3 = 0.0;
        if ((points[2][0] - points[1][0]) != 0) {
            k1 = (points[2][1] - points[1][1]) * 1.0 / (points[2][0] - points[1][0]) * 1.0;
        }
        if ((points[2][0] - points[0][0]) != 0) {
            k2 = (points[2][1] - points[0][1]) * 1.0 / (points[2][0] - points[0][0]) * 1.0;
        }
        if ((points[1][0] - points[0][0]) != 0) {
            k3 = (points[1][1] - points[0][1]) * 1.0 / (points[1][0] - points[0][0]) * 1.0;
        }
        if (k1 == k2 && k2 == k3) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 1}, {1, 1}};
        System.out.println(new Solution().isBoomerang(points));
    }
}

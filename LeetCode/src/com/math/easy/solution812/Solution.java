package com.math.easy.solution812;

/**
 * @author LiSheng
 * @date 2020/4/10 19:37
 */
public class Solution {
    public double largestTriangleArea(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        double res = 0.0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    res = Math.max(res, heron(points[i], points[j], points[k]));
                }
            }
        }
        return res;
    }

    private double heron(int[] point, int[] point1, int[] point2) {
        double a = Math.sqrt(Math.pow(point[0] - point1[0], 2) + Math.pow(point[1] - point1[1], 2));
        double b = Math.sqrt(Math.pow(point[0] - point2[0], 2) + Math.pow(point[1] - point2[1], 2));
        double c = Math.sqrt(Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
        double p = (a + b + c) / 2;
        return Math.sqrt(Math.abs(p * (p - a) * (p - b) * (p - c)));
    }
}

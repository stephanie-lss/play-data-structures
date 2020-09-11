package com.math.easy.solution598;

/**
 * @author LiSheng
 * @date 2020/4/8 17:56
 */
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int[] op : ops) {
            if (op[0] < minX) {
                minX = op[0];
            }
            if (op[1] < minY){
                minY = op[1];
            }
        }
        return minX * minY;
    }

    //18
    //3
    //[[16,1],[14,3],[14,2],[4,1],[10,1],[11,1],[8,3],[16,2],[13,1],[8,3],[2,2],[9,1],[3,1],[2,2],[6,3]]
    public static void main(String[] args) {
        int[][] ops = {{20,10},{26,11},{2,11},{4,16},{2,3},{23,13},{7,15},{11,11},{25,13},{11,13},{13,11},{13,16},{26,17}};
//        int[][] ops = {{16, 1}, {14, 3}, {14, 2}, {4, 1}, {10, 1}, {11, 1}, {8, 3}, {16, 2}, {13, 1}, {8, 3}, {2, 2}, {9, 1}, {3, 1}, {2, 2}, {6, 3}};
        System.out.println(new Solution().maxCount(26, 17, ops));
    }
}

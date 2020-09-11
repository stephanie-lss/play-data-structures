package com.array.easy.solution1184;

/**
 * @author LiSheng
 * @date 2020/3/31 16:13
 */
public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int d1 = 0;
        int d2 = 0;
        int l = Math.min(start, destination);
        int r = Math.max(start, destination);
        for (int i = 0; i < distance.length; i++) {
            if (i >= l && i < r) {
                d1 += distance[i];
            } else {
                d2 += distance[i];
            }
        }
        return Math.min(d1, d2);
    }

    public static void main(String[] args) {
        int[] dis = {1, 2, 3, 4};
        int start = 3;
        int des = 0;
        System.out.println(new Solution().distanceBetweenBusStops(dis, start, des));
    }
}

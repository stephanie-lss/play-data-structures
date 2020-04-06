package com.array.hard.solution42;

/**
 * @author LiSheng
 * @date 2020/4/4 10:01
 */
public class Solution {
    public int trap(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (maxLeft < height[j]) {
                    maxLeft = height[j];
                }
            }
            int maxRight = Integer.MIN_VALUE;
            for (int j = i + 1; j < height.length; j++) {
                if (maxRight < height[j]) {
                    maxRight = height[j];
                }
            }
            int min = Math.min(maxLeft, maxRight);
            if (min > height[i]) {
                res += min - height[i];
            }
        }
        return res;
    }
}

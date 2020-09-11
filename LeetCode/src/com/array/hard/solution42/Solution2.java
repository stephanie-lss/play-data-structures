package com.array.hard.solution42;

/**
 * @author LiSheng
 * @date 2020/4/4 10:01
 */
public class Solution2 {
    public int trap(int[] height) {
        int res = 0;
        int[] maxLeft = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(height[i - 1], maxLeft[i - 1]);
        }
        int[] maxRight = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                res += min - height[i];
            }
        }
        return res;
    }
}

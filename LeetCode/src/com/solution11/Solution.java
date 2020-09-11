package com.solution11;

/**
 * @author LiSheng
 * @date 2020/4/18 10:00
 */
class Solution {
    public int maxArea(int[] height) {
        int maxWater = -1;
        if (height.length <= 1) {
            return maxWater;
        }
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > i; j--) {
                int tmp = Math.min(height[i], height[j]) * (j - i);
                maxWater = Math.max(maxWater, tmp);
                if (height[j] >= height[i]) {
                    break;
                }
            }
        }
        return maxWater;
    }
}
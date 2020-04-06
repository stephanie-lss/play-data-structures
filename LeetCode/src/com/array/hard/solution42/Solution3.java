package com.array.hard.solution42;

/**
 * @author LiSheng
 * @date 2020/4/4 10:01
 */
public class Solution3 {
    public int trap(int[] height) {
        int res = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 1;
        int right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(height[left - 1], maxLeft);
                int min = maxLeft;
                if (min > height[left]) {
                    res += min - height[left];
                }
                left++;
            }else {
                maxRight= Math.max(height[right + 1], maxRight);
                int min = maxRight;
                if (min > height[right]) {
                    res += min - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
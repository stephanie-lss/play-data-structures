package com.array.easy.solution747;

/**
 * @author LiSheng
 * @date 2020/3/30 16:13
 */
public class Solution2 {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int m = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                m = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > m) {
                m = nums[i];
            }
        }
        return max >= 2 * m ? maxIndex : -1;
    }
}

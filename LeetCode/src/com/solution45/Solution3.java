package com.solution45;

/**
 * @author LiSheng
 * @date 2020/5/4 10:34
 */
public class Solution3 {
    public int jump(int[] nums) {
        int step = 0;
        if (nums.length == 1) {
            return step;
        }
        int border = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            border = Math.max(border, i + nums[i]);
            if (i == end) {
                end = border;
                step++;
                if (border >= nums.length - 1) {
                    return step;
                }
            }
        }
        throw null;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 1, 3, 1, 1, 1};
        System.out.println(new Solution3().jump(nums));
    }
}

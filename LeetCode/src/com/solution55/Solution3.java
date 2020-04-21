package com.solution55;

/**
 * @author LiSheng
 * @date 2020/4/17 10:42
 */
class Solution3 {
    public boolean canJump(int[] nums) {
        int d = 0;
        for (int i = 0; i < nums.length - 1 && i <= d; i++) {
            d = Math.max(d, i + nums[i]);
            if (d >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={2,0,0};
        System.out.println(new Solution3().canJump(nums));
    }
}
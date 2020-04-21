package com.solution55;

/**
 * @author LiSheng
 * @date 2020/4/17 9:40
 */
public class Solution {
    public boolean canJump(int[] nums) {
        return helper(nums, 0, 0);
    }

    private boolean helper(int[] nums, int index, int p) {
        if (index == nums.length - 1) {
            return true;
        }
        if (index >= nums.length) {
            return false;
        }
        int pace = nums[p];
        for (int i = 1; i <= pace; i++) {
            if (nums[index + i] == 0) {
                continue;
            }
            if (helper(nums, index + i, ++p)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {24357, 24356, 24355, 24354, 24353, 24352, 24351, 24350, 24349, 24348, 24347, 24346, 24345, 24344, 24343, 24342, 24341, 24340, 24339, 24338, 24337, 24336, 24335};
        System.out.println(new Solution().canJump(nums));
    }
}

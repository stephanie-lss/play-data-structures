package com.offer.interview03.solution3;

/**
 * @author LiSheng
 * @date 2020/5/29 19:55
 */
class Solution2 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }else {
                continue;
            }
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(new Solution2().findRepeatNumber(nums));
    }
}
package com.array.easy.interview03;

/**
 * @author LiSheng
 * @date 2020/4/1 15:22
 */
public class Solution2 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = tmp;
            }
        }
        throw null;
    }
}

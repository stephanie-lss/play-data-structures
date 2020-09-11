package com.solution287;

/**
 * @author LiSheng
 * @date 2020/5/26 8:42
 */
class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 5, 6, 7};
        System.out.println(new Solution().findDuplicate(nums));
    }
}

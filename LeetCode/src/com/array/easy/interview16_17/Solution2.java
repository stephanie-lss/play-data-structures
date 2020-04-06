package com.array.easy.interview16_17;

/**
 * @author LiSheng
 * @date 2020/4/1 22:10
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution2().maxSubArray(arr));
    }
}

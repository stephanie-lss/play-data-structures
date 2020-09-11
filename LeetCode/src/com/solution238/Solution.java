package com.solution238;

/**
 * @author LiSheng
 * @date 2020/6/4 8:34
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int tmp = 1;
        for (int i = 0; i < n; i++) {
            res[i] = tmp;
            tmp *= nums[i];
        }
        tmp = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= tmp;
            tmp *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        int[] x = new Solution().productExceptSelf(nums);
        for (int i : x) {
            System.out.println(i);
        }
    }
}
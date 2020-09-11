package com.top100.solution560;

/**
 * @author LiSheng
 * @date 2020/5/15 9:35
 */
public class Solution5 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            int j = i + 1;
            while (true) {
                if (sum == k) {
                    res++;
                }
                if (j >= nums.length) {
                    break;
                }
                sum += nums[j++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4, 0, 3};
        System.out.println(new Solution5().subarraySum(nums, 3));
    }
}

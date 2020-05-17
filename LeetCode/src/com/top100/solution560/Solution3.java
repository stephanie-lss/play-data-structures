package com.top100.solution560;

/**
 * @author LiSheng
 * @date 2020/5/5 18:03
 */
class Solution3 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                if (sum[j] - sum[i] == k){
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(new Solution3().subarraySum(nums, 2));
    }
}
package com.dp.linear.solution213;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/25 13:16
 */
public class Solution3 {
    public int rob(int[] nums) {
        int n = nums.length;
        return n == 1 ? nums[0] : (n == 0 ? 0 : Math.max(dp(Arrays.copyOfRange(nums, 0, n - 1)), dp(Arrays.copyOfRange(nums, 1, n))));
    }

    public int dp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //状态：房屋
        //dp[i]表示前i个房子所偷的金额
        //base case
        int pre = 0;
        int cur = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            //偷或者不偷
            int tmp = cur;
            cur = Math.max(cur, pre + nums[i - 1]);
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,4};
        System.out.println(new Solution3().rob(nums));
    }
}

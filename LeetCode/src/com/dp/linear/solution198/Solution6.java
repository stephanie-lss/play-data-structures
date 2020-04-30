package com.dp.linear.solution198;

/**
 * @author LiSheng
 * @date 2020/4/25 10:46
 */
public class Solution6 {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //状态：房屋
        //dp[i]表示前i个房子所偷的金额
        int[] dp = new int[nums.length + 1];
        //base case
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            //偷或者不偷
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new Solution6().rob(nums));
    }
}

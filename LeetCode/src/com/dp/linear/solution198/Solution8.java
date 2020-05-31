package com.dp.linear.solution198;

/**
 * @author LiSheng
 * @date 2020/5/29 10:45
 */
public class Solution8 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        //dp[i]表示数组的前i个房子能偷到的最高金额
        int[] dp = new int[n + 1];
        //base case——第一个房子直接偷——第二个房子就偷前两个中金额较大的房子
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new Solution8().rob(nums));
    }
}

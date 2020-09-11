package com.dp.linear.solution198;

/**
 * @author LiSheng
 * @date 2020/4/25 10:46
 */
public class Solution7 {

    public int rob(int[] nums) {
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
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new Solution7().rob(nums));
    }
}

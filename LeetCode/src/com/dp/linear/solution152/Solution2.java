package com.dp.linear.solution152;

/**
 * @author LiSheng
 * @date 2020/5/18 20:16
 */
public class Solution2 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, x = 1, y = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            x = Math.max(num, x * num);
            y = Math.min(num, y * num);
            max = Math.max(max, x);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(new Solution2().maxProduct(nums));
    }
}

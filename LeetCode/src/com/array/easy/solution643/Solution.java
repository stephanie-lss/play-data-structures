package com.array.easy.solution643;

/**
 * @author LiSheng
 * @date 2020/3/30 11:32
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = -Double.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            double sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[i + j];
            }
            max = Math.max(max, sum / k);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={-1};
        int k = 1;
        System.out.println(new Solution().findMaxAverage(nums,k));
    }
}

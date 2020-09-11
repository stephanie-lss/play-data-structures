package com.array.easy.solution485;

/**
 * @author LiSheng
 * @date 2020/3/28 22:39
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (max < count) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(new Solution().findMaxConsecutiveOnes(nums));
    }
}

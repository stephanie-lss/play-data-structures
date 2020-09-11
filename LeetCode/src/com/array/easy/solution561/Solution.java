package com.array.easy.solution561;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/29 19:07
 */
public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res += nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,4,3,2};
        System.out.println(new Solution().arrayPairSum(nums));
    }
}

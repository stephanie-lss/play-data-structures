package com.array.easy.solution217;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/28 20:37
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}

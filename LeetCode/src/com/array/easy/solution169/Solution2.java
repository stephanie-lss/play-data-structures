package com.array.easy.solution169;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/28 18:57
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

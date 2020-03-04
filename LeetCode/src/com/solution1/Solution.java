package com.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/2/19 19:51
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (record.containsKey(complement)) {
                int[] res = {i, record.get(complement)};
                return res;
            } else {
                record.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException("the input has no solution!");
    }
}

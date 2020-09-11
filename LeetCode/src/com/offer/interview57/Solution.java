package com.offer.interview57;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/5/13 21:26
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(target - num)) {
                return new int[]{num, target - num};
            }
        }
        throw null;
    }
}
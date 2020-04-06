package com.array.easy.interview03;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/4/1 15:22
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        throw null;
    }
}

package com.offer.interview56_II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/5/12 15:19
 */
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) == 3) {
                freq.remove(num);
            }
        }
        return freq.keySet().iterator().next();
    }
}


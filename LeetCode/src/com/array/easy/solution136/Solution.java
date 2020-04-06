package com.array.easy.solution136;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/3/29 17:36
 */
public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            if (!freq.containsKey(num)) {
                freq.put(num, 1);
            } else {
                freq.put(num, freq.get(num) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        throw null;
    }
}

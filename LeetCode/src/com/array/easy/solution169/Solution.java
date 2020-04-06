package com.array.easy.solution169;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/3/28 18:57
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!freq.containsKey(nums[i])) {
                freq.put(nums[i], 1);
            } else {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            }
        }
        n = n / 2;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue()>n){
                return entry.getKey();
            }
        }
        throw null;
    }
}

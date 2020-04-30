package com.interview.solution56_1;

import java.util.HashMap;

/**
 * @author LiSheng
 * @date 2020/4/28 9:30
 */
class Solution {
    public int[] singleNumbers(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!freq.containsKey(nums[i])) {
                freq.put(nums[i], 1);
            } else {
                freq.remove(nums[i]);
            }
        }
        int[] res = new int[2];
        int idx = 0;
        for (Integer i : freq.keySet()) {
            res[idx++] = i;
        }
        return res;
    }
}

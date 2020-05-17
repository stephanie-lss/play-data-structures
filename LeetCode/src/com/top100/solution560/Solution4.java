package com.top100.solution560;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/5/5 20:05
 */
public class Solution4 {
    public int subarraySum(int[] nums, int k) {
        int res = 0, sum = 0;
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (record.containsKey(sum - k)) {
                res += record.get(sum - k);
            }
            record.put(sum, record.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}

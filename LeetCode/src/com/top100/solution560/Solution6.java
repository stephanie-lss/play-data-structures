package com.top100.solution560;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/5/15 10:02
 */
public class Solution6 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, res = 0;
        for (int num : nums) {
            sum += num;
            if (record.containsKey(sum - k)) {
                res += record.get(sum - k);
            }
            record.put(sum, record.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4, 0, 3};
        System.out.println(new Solution6().subarraySum(nums, 3));
    }
}

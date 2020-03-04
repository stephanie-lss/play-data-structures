package com.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/2/19 19:51
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            record.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (record.containsKey(complement) && i != record.get(complement)) {
                int[] res = {i, record.get(complement)};
                return res;
            }
        }

        throw new IllegalArgumentException("the input has no solution!");
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] ints = new Solution().twoSum(nums, 6);
        for (int i : ints) {
            System.out.print(i+" ");
        }
    }
}

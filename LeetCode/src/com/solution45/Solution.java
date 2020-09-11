package com.solution45;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/5/4 9:11
 * NOT AC
 */
class Solution {
    int min = Integer.MAX_VALUE;
    Map<AbstractMap.SimpleEntry<Integer, Integer>, Integer> memo = new HashMap<>();

    public int jump(int[] nums) {
        return dfs(nums, 0, 0, nums.length - 1);
    }

    private int dfs(int[] nums, int count, int step, int n) {
        if (memo.containsKey(new AbstractMap.SimpleEntry<>(count, step))) {
            return memo.get(new AbstractMap.SimpleEntry<>(count, step));
        }
        if (step >= n) {
            return count;
        }
        for (int i = nums[step]; i >= 1; i--) {
            int tmp = dfs(nums, count + 1, step + i, n);
            if (min >= tmp) {
                min = tmp;
            } else {
                return min;
            }
        }
        memo.put(new AbstractMap.SimpleEntry<>(count, step), min);
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        System.out.println(new Solution().jump(nums));
    }
}
package com.dp.knapsack.solution494;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/4/23 17:03
 */
class Solution3 {
    Map<AbstractMap.SimpleEntry<Integer, Integer>, Integer> record = new HashMap<>();

    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, S, 0);
    }

    private int dfs(int[] nums, int S, int index) {
        if (record.containsKey(new AbstractMap.SimpleEntry<>(S, index))) {
            return record.get(new AbstractMap.SimpleEntry<>(S, index));
        }
        if (index == nums.length) {
            return S == 0 ? 1 : 0;
        }
        record.put(new AbstractMap.SimpleEntry<>(S, index), dfs(nums, S + nums[index], index + 1) + dfs(nums, S - nums[index], index + 1));
        return dfs(nums, S + nums[index], index + 1) + dfs(nums, S - nums[index], index + 1);
    }
}

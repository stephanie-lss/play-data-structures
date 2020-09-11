package com.array.easy.solution532;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/3/29 10:47
 */
public class Solution {

    Set<Integer> setMax = new HashSet<>();
    Set<Integer> setMin = new HashSet<>();

    public int findPairs(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        return findPairs(nums, k, 0);
    }

    private int findPairs(int[] nums, int k, int index) {
        int count = 0;
        if (index == nums.length - 1) {
            return count;
        }
        int a = nums[index];
        for (int i = index + 1; i < nums.length; i++) {
            if (Math.abs(a - nums[i]) == k && (setMax.contains(Math.max(a, nums[i])) && setMin.contains(Math.min(a, nums[i])))) {
                setMax.add(Math.max(a, nums[i]));
                setMin.add(Math.min(a, nums[i]));
                count++;
            }
        }
        count += findPairs(nums, k, index + 1);
        return count;
    }
}

package com.solution219;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/2/20 10:24
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            }
            record.add(nums[i]);
            if (record.size() == k + 1) {
                record.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        System.out.println(new com.solution219.Solution().containsNearbyDuplicate(nums,2));
    }
}

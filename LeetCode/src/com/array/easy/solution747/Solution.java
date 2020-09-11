package com.array.easy.solution747;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/30 15:57
 */
public class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int n = nums.length;
        List<Integer> copy = new ArrayList<>(n);
        for (int num : nums) {
            copy.add(num);
        }
        Arrays.sort(nums);
        if (nums[n - 1] >= 2 * nums[n - 2]) {
            return copy.indexOf(nums[n - 1]);
        } else {
            return -1;
        }
    }
}

package com.array.easy.solution268;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/28 20:50
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] record = new int[n+1];
        Arrays.fill(record, 0);
        for (int i = 0; i < n; i++) {
            record[nums[i]]++;
        }
        for (int i = 0; i <= n; i++) {
            if (record[i] == 0) {
                return i;
            }
        }
        throw null;
    }
}

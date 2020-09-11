package com.math.easy.solution645;

/**
 * @author LiSheng
 * @date 2020/4/12 12:10
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] freq = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (freq[nums[i]] == 1) {
                res[0] = nums[i];
            } else {
                freq[nums[i]]++;
            }
        }
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0) {
                res[1] = i;
            }
        }
        return res;
    }
}

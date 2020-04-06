package com.array.easy.solution1365;

/**
 * @author LiSheng
 * @date 2020/3/31 22:43
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums[i]; j++) {
                count += freq[j];
            }
            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        new Solution().smallerNumbersThanCurrent(nums);
    }
}

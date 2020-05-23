package com.offer.interview61;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/5/22 10:29
 */
class Solution {
    public boolean isStraight(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return true;
        }
        Arrays.sort(nums);
        int boss = 0, firstNonZore = 0;
        while (nums[firstNonZore] == 0) {
            boss++;
            firstNonZore++;
        }
        int[] res = new int[n];
        res[0] = nums[firstNonZore];
        for (int i = 1, j = firstNonZore + 1; i < n; i++) {
            if (j == n) {
                return boss == n - i;
            }
            while (nums[j] == 0) {
                j++;
            }
            if (nums[j] == res[i - 1] + 1) {
                res[i] = nums[j++];
            } else {
                if (boss == 0) {
                    return false;
                } else {
                    res[i] = res[i - 1] + 1;
                    boss--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {11, 0, 9, 0, 0};
        System.out.println(new Solution().isStraight(nums));
    }
}
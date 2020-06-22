package com.offer.interview61;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/6/18 11:27
 */
public class Solution2 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int boss = 0;
        int idx = 0;
        while (true) {
            if (nums[idx] == 0) {
                idx++;
                boss++;
            } else {
                break;
            }
        }
        int start = nums[idx];
        int[] res = new int[5];
        Arrays.fill(res, -1);
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] - start >= 5) {
                return false;
            }else {
                res[nums[i] - start] = 0;
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == -1) {
                boss--;
            }
        }
        return boss >= 0;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 4, 5, 8};
        System.out.println(new Solution2().isStraight(nums));
    }
}

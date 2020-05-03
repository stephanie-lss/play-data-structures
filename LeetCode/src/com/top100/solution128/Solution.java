package com.top100.solution128;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/5/3 10:49
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            int leftLongest = 0;
            int leftCur = num - 1;
            while (set.contains(leftCur)) {
                leftLongest++;
                leftCur--;
            }
            int rightLongest = 0;
            int rightCur = num + 1;
            while (set.contains(rightCur)) {
                rightLongest++;
                rightCur++;
            }
            max = Math.max(leftLongest + rightLongest + 1, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new Solution().longestConsecutive(nums));
    }
}
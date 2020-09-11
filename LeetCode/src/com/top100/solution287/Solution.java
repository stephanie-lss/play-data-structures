package com.top100.solution287;

/**
 * @author LiSheng
 * @date 2020/4/28 21:18
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println(new Solution().findDuplicate(nums));
    }
}

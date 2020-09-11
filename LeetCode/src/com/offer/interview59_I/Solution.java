package com.offer.interview59_I;

/**
 * @author LiSheng
 * @date 2020/5/21 11:29
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, left = 0, right = 0, max = Integer.MIN_VALUE;
        if (n == 0){
            return new int[0];
        }
        int[] res = new int[n - k + 1];
        while (right < k) {
            max = Math.max(max, nums[right]);
            right++;
        }
        res[0] = max;
        int idx = 1;
        while (right < n) {
            int c = nums[right];
            right++;

            int d = nums[left];
            left++;

            if (c >= max) {
                max = c;
            } else if (d == max) {
                max = Integer.MIN_VALUE;
                for (int i = left; i < right; i++) {
                    max = Math.max(max, nums[i]);
                }
            }
            res[idx++] = max;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 4, 1, 3, 1, 5, 7, 1, 2, 1, 5, 3, 6, 7};
        int[] res = new Solution().maxSlidingWindow(nums, 3);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
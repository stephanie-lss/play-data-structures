package com.offer.interview59_I;

/**
 * @author LiSheng
 * @date 2020/6/17 14:32
 */
public class Solution3 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        int max = Integer.MIN_VALUE, left = 0, right = k;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] res = new int[n - k + 1];
        res[0] = max;
        int idx = 1;
        while (right < n) {
            int c = nums[right];
            int d = nums[left];
            right++;
            left++;
            if (c >= max) {
                max = c;
                res[idx++] = max;
            } else {
                if (d != max) {
                    res[idx++] = max;
                } else {
                    max = Integer.MIN_VALUE;
                    for (int i = left; i < right; i++) {
                        max = Integer.max(max, nums[i]);
                    }
                    res[idx++] = max;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,3,4};
        int[] ints = new Solution3().maxSlidingWindow(nums, 1);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}

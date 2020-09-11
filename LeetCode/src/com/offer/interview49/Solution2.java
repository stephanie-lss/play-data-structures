package com.offer.interview49;

/**
 * @author LiSheng
 * @date 2020/6/12 16:03
 */
public class Solution2 {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int p1 = 0, p2 = 0, p3 = 0;
        for (int i = 1; i < n; i++) {
            nums[i] = Math.min(Math.min(nums[p1] * 2, nums[p2] * 3), nums[p3] * 5);
            if (nums[i] == nums[p1] * 2) {
                p1++;
            }
            if (nums[i] == nums[p2] * 3) {
                p2++;
            }
            if (nums[i] == nums[p3] * 5) {
                p3++;
            }
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().nthUglyNumber(10));
    }
}

package com.array.easy.interview53_II;

/**
 * @author LiSheng
 * @date 2020/4/1 18:29
 */
public class Solution3 {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = right - (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else if (nums[mid] > mid) {
                right = mid - 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(new Solution3().missingNumber(nums));
    }
}

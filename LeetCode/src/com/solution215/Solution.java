package com.solution215;

/**
 * @author LiSheng
 * @date 2020/6/29 13:03
 */
class Solution {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int p = partition(nums, 0, nums.length - 1);
        while (k != p) {
            if (p < k) {
                p = partition(nums, p + 1, nums.length - 1);
            } else {
                p = partition(nums, 0, p - 1);
            }
        }
        return nums[p];
    }

    private int partition(int[] nums, int l, int r) {
        int ref = nums[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < ref && (j++ != i)) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        int tmp = nums[j];
        nums[j] = nums[l];
        nums[l] = tmp;
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {7, 6, 5, 4, 3, 2, 1};
        System.out.println(new Solution().findKthLargest(nums, 2));
    }
}
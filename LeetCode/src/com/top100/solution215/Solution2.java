package com.top100.solution215;

/**
 * @author LiSheng
 * @date 2020/4/28 19:25
 */
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int n = partion(nums, start, end);
        quickSort(nums, start, n - 1);
        quickSort(nums, n + 1, end);
    }

    private int partion(int[] nums, int start, int end) {
        swap(nums, (int) (Math.random() * (end - start) + start), start);
        int ref = nums[start];
        int idx = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < ref && idx++ < end) {
                int tmp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = tmp;
            }
        }
        int tmp = nums[start];
        nums[start] = nums[idx];
        nums[idx] = tmp;
        return idx;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(new Solution2().findKthLargest(nums, 4));
    }
}

package com.offer.interview51;

/**
 * @author LiSheng
 * @date 2020/7/11 13:16
 */
public class Solution2 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftCount = mergeSort(nums, left, mid);
        int rightCount = mergeSort(nums, mid + 1, right);
        if (nums[mid] < nums[mid + 1]) {
            return leftCount + rightCount;
        }
        return leftCount + rightCount + merge(nums, left, mid, right);
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int count = 0;
        int idx = 0;
        int low = left, high = mid + 1;
        while (low <= mid && high <= right) {
            if (nums[low] <= nums[high]) {
                temp[idx++] = nums[low++];
            } else if (nums[low] > nums[high]) {
                count += mid - low + 1;
                temp[idx++] = nums[high++];
            }
        }
        while (low <= mid) {
            temp[idx++] = nums[low++];
        }
        while (high <= right) {
            temp[idx++] = nums[high++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
        return count;
    }
}

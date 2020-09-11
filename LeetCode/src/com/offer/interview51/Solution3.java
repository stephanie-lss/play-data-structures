package com.offer.interview51;

/**
 * @author LiSheng
 * @date 2020/7/30 10:15
 */
public class Solution3 {
    public int reversePairs(int[] nums) {
        int low = 0, high = 0;
        if (nums == null || (high = nums.length) == 0) {
            return 0;
        }
        return mergeSort(nums, low, high - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        int leftCount = mergeSort(nums, low, mid);
        int rightCount = mergeSort(nums, mid + 1, high);
        if (mid + 1 <= high && nums[mid] < nums[mid + 1]) {
            return leftCount + rightCount;
        }
        return merge(nums, low, mid, high) + leftCount + rightCount;
    }

    private int merge(int[] nums, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int left = low, right = mid + 1;
        int count = 0, idx = 0;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                tmp[idx++] = nums[left++];
            } else {
                count += mid - left + 1;
                tmp[idx++] = nums[right++];
            }
        }
        while (left <= mid) {
            tmp[idx++] = nums[left++];
        }
        while (right <= high) {
            tmp[idx++] = nums[right++];
        }
        for (int i = 0; i < tmp.length; i++) {
            nums[low + i] = tmp[i];
        }
        return count;
    }
}

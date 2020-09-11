package com.solution315;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/7/11 13:38
 */
class Solution {
    private int[] output;
    private int[] indexs;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        this.output = new int[nums.length];
        this.indexs = new int[nums.length];
        for (int i = 0; i < indexs.length; i++) {
            indexs[i] = i;
        }
        mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < output.length; i++) {
            res.add(output[i]);
        }
        return res;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        if (nums[indexs[mid]] < nums[indexs[mid + 1]]) {
            return;
        }
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int idx = 0;
        int low = left, high = mid + 1;
        while (low <= mid && high <= right) {
            if (nums[indexs[low]] <= nums[indexs[high]]) {
                output[indexs[low]] += high - mid - 1;
                temp[idx++] = indexs[low++];
            } else if (nums[indexs[low]] > nums[indexs[high]]) {
                temp[idx++] = indexs[high++];
            }
        }
        while (low <= mid) {
            output[indexs[low]] += right - mid;
            temp[idx++] = indexs[low++];
        }
        while (high <= right) {
            temp[idx++] = indexs[high++];
        }
        for (int i = 0; i < temp.length; i++) {
            indexs[left + i] = temp[i];
        }
    }
}
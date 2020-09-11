package com.offer.interview45;

/**
 * @author LiSheng
 * @date 2020/5/16 18:40
 */
class Solution2 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        return String.join("", strs);
    }

    private void quickSort(String[] strs, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(strs, left, right);
        quickSort(strs, left, mid - 1);
        quickSort(strs, mid + 1, right);
    }

    private int partition(String[] strs, int left, int right) {
        swap(strs, left, (int) (Math.random() * (right - left) + left));
        String low = strs[left];
        int i = left;
        for (int j = left + 1; j <= right; j++) {
            if ((low + strs[j]).compareTo(strs[j] + low) > 0 && i++ != j) {
                swap(strs, i, j);
            }
        }
        swap(strs, left, i);
        return i;
    }

    private void swap(String[] strs, int i, int j) {
        String tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(new Solution2().minNumber(nums));
    }
}
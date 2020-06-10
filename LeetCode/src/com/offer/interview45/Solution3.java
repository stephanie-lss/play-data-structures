package com.offer.interview45;

/**
 * @author LiSheng
 * @date 2020/6/10 15:12
 */
public class Solution3 {
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        quickSort(strings, 0, nums.length - 1);
        return String.join("", strings);
    }

    private void quickSort(String[] nums, int l, int r) {
        if (l < r) {
            int p = partition(nums, l, r);
            quickSort(nums, l, p - 1);
            quickSort(nums, p + 1, r);
        }
    }

    private int partition(String[] nums, int l, int r) {
        String ref = nums[l];
        int p = l;
        for (int i = l + 1; i <= r; i++) {
            if ((ref + nums[i]).compareTo(nums[i] + ref) > 0 && p++ != i) {
                String tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
            }
        }
        String tmp = nums[p];
        nums[p] = nums[l];
        nums[l] = tmp;
        return p;
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(new Solution3().minNumber(nums));
    }
}

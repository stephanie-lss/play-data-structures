package com.interview.solution51;

/**
 * @author LiSheng
 * @date 2020/4/24 9:52
 */
public class Solution2 {

    int res = 0;

    public int reversePairs(int[] nums) {
        helper(nums, 0, nums.length - 1);
        return res;
    }

    private void helper(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            helper(nums, left, mid);
            helper(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int[] arr = new int[right - left + 1];
        int idx = 0;

        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                arr[idx++] = nums[l++];
            } else if (nums[l] > nums[r]) {
                arr[idx++] = nums[r++];
                res += mid - l + 1;
            }
        }
        while (l <= mid) {
            arr[idx++] = nums[l++];
        }

        while (r <= right) {
            arr[idx++] = nums[r++];
        }

        for (int i = 0; i < arr.length; i++) {
            nums[left + i] = arr[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {3998,2586,5437,589,1390,4131,2243,837,5507,1167,2084,457,2943,261,2616,1787,776,986,5161};
        System.out.println(new Solution2().reversePairs(nums));
        for (int num : nums) {
            System.out.print(num +" ");
        }
    }
}
